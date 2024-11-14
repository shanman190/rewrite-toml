package org.openrewrite.toml.internal;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jspecify.annotations.Nullable;
import org.openrewrite.FileAttributes;
import org.openrewrite.internal.EncodingDetectingInputStream;
import org.openrewrite.marker.Markers;
import org.openrewrite.toml.internal.grammar.TomlParser;
import org.openrewrite.toml.internal.grammar.TomlParserBaseVisitor;
import org.openrewrite.toml.tree.*;

import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Collections;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static org.openrewrite.Tree.randomId;

public class TomlParserVisitor extends TomlParserBaseVisitor<Toml> {
    private final Path path;
    private final String source;
    private final Charset charset;
    private final boolean charsetBomMarked;

    @Nullable
    private final FileAttributes fileAttributes;

    private int cursor = 0;
    private int codePointCursor = 0;

    public TomlParserVisitor(Path path, @Nullable FileAttributes fileAttributes, EncodingDetectingInputStream source) {
        this.path = path;
        this.fileAttributes = fileAttributes;
        this.source = source.readFully();
        this.charset = source.getCharset();
        this.charsetBomMarked = source.isCharsetBomMarked();
    }

    @Override
    public Toml.Document visitDocument(TomlParser.DocumentContext ctx) {
        return !ctx.children.isEmpty() && ctx.children.get(0) instanceof TerminalNode && ((TerminalNode) ctx.children.get(0)).getSymbol().getType() == TomlParser.EOF ? new Toml.Document(
                randomId(),
                path,
                Space.EMPTY,
                Markers.EMPTY,
                charset.name(),
                charsetBomMarked,
                null,
                fileAttributes,
                Collections.emptyList(),
                Space.EMPTY
        ) : convert(ctx, (c, prefix) -> new Toml.Document(
                randomId(),
                path,
                prefix,
                Markers.EMPTY,
                charset.name(),
                charsetBomMarked,
                null,
                fileAttributes,
                c.expression().stream().map(e -> (TomlValue) visit(e)).collect(Collectors.toList()),
                Space.format(source, cursor, source.length())
        ));
    }

    @Override
    public TomlKey visitKey(TomlParser.KeyContext ctx) {
        return new Toml.Identifier(
                randomId(),
                Space.EMPTY,
                Markers.EMPTY,
                ctx.getText()
        );
    }

    @Override
    public Toml.KeyValue visitKey_value(TomlParser.Key_valueContext ctx) {
        return new Toml.KeyValue(
                randomId(),
                Space.EMPTY,
                Markers.EMPTY,
                TomlRightPadded.build(visitKey(ctx.key())).withAfter(sourceBefore("=")),
                visitValue(ctx.value())
        );
    }

    @Override
    public Toml.Literal visitValue(TomlParser.ValueContext ctx) {
        if (ctx.string() != null) {
            return convert(ctx, (c, prefix) -> new Toml.Literal(
                    randomId(),
                    prefix,
                    Markers.EMPTY,
                    c.getText(),
                    c.getText()
            ));
        }
        return null;
    }

    private Space prefix(ParserRuleContext ctx) {
        return prefix(ctx.getStart());
    }

    private Space prefix(@Nullable TerminalNode terminalNode) {
        return terminalNode == null ? Space.EMPTY : prefix(terminalNode.getSymbol());
    }

    private Space prefix(Token token) {
        int start = token.getStartIndex();
        if (start < codePointCursor) {
            return Space.EMPTY;
        }
        return Space.format(source, cursor, advanceCursor(start));
    }

    public int advanceCursor(int newCodePointIndex) {
        for (; codePointCursor < newCodePointIndex; codePointCursor++) {
            cursor = source.offsetByCodePoints(cursor, 1);
        }
        return cursor;
    }

    private <C extends ParserRuleContext, T> @Nullable T convert(C ctx, BiFunction<C, Space, T> conversion) {
        if (ctx == null) {
            return null;
        }

        T t = conversion.apply(ctx, prefix(ctx));
        if (ctx.getStop() != null) {
            advanceCursor(ctx.getStop().getStopIndex() + 1);
        }

        return t;
    }

    private <T> T convert(TerminalNode node, BiFunction<TerminalNode, Space, T> conversion) {
        T t = conversion.apply(node, prefix(node));
        advanceCursor(node.getSymbol().getStopIndex() + 1);
        return t;
    }

    private void skip(TerminalNode node) {
        advanceCursor(node.getSymbol().getStopIndex() + 1);
    }

    /**
     * @return Source from <code>cursor</code> to next occurrence of <code>untilDelim</code>,
     * and if not found in the remaining source, the empty String. If <code>stop</code> is reached before
     * <code>untilDelim</code> return the empty String.
     */
    private Space sourceBefore(String untilDelim) {
        int delimIndex = positionOfNext(untilDelim, null);
        if (delimIndex < 0) {
            return Space.EMPTY; // unable to find this delimiter
        }

        Space space = Space.format(source, cursor, delimIndex);
        advanceCursor(codePointCursor + Character.codePointCount(source, cursor, delimIndex) + untilDelim.length());
        return space;
    }

    private int positionOfNext(String untilDelim, @Nullable Character stop) {
        boolean inMultiLineComment = false;
        boolean inSingleLineComment = false;

        int delimIndex = cursor;
        for (; delimIndex < source.length() - untilDelim.length() + 1; delimIndex++) {
            if (inSingleLineComment) {
                if (source.charAt(delimIndex) == '\n') {
                    inSingleLineComment = false;
                }
            } else {
                if (inMultiLineComment) {
                    if (source.charAt(delimIndex) == '*' && source.charAt(delimIndex + 1) == '/') {
                        inMultiLineComment = false;
                        delimIndex += 2;
                    }
                } else if (source.charAt(delimIndex) == '/' && source.length() - untilDelim.length() > delimIndex + 1) {
                    int next = source.charAt(delimIndex + 1);
                    if (next == '/') {
                        inSingleLineComment = true;
                        delimIndex++;
                    } else if (next == '*') {
                        inMultiLineComment = true;
                        delimIndex++;
                    }
                }

                if (!inMultiLineComment && !inSingleLineComment) {
                    if (stop != null && source.charAt(delimIndex) == stop) {
                        return -1; // reached stop word before finding the delimiter
                    }

                    if (source.startsWith(untilDelim, delimIndex)) {
                        break; // found it!
                    }
                }
            }
        }

        return delimIndex > source.length() - untilDelim.length() ? -1 : delimIndex;
    }
}