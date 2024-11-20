package org.openrewrite.toml.internal;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jspecify.annotations.Nullable;
import org.openrewrite.FileAttributes;
import org.openrewrite.internal.EncodingDetectingInputStream;
import org.openrewrite.marker.Markers;
import org.openrewrite.toml.internal.grammar.TomlParser;
import org.openrewrite.toml.internal.grammar.TomlParserBaseVisitor;
import org.openrewrite.toml.marker.InlineTable;
import org.openrewrite.toml.tree.Space;
import org.openrewrite.toml.tree.Toml;
import org.openrewrite.toml.tree.TomlKey;
import org.openrewrite.toml.tree.TomlRightPadded;

import java.nio.charset.Charset;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

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
    public Toml visitChildren(RuleNode node) {
        Toml result = defaultResult();
        int n = node.getChildCount();
        for (int i = 0; i < n; i++) {
            if (!shouldVisitNextChild(node, result)) {
                break;
            }

            ParseTree c = node.getChild(i);
            if (c instanceof TomlParser.CommentContext) {
                continue;
            }

            Toml childResult = c.accept(this);
            result = aggregateResult(result, childResult);
        }

        return result;
    }

    @Override
    public Toml.Document visitDocument(TomlParser.DocumentContext ctx) {
        if (!ctx.children.isEmpty() && ctx.children.get(0) instanceof TerminalNode && ((TerminalNode) ctx.children.get(0)).getSymbol().getType() == TomlParser.EOF) {
            new Toml.Document(
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
            );
        }

        List<Toml> elements = new ArrayList<>();
        // The last element is a "TerminalNode" which we are uninterested in
        for (int i = 0; i < ctx.children.size() - 1; i++) {
            Toml element = visit(ctx.children.get(i));
            if (element != null) {
                elements.add(element);
            }
        }

        return new Toml.Document(
                randomId(),
                path,
                Space.EMPTY,
                Markers.EMPTY,
                charset.name(),
                charsetBomMarked,
                null,
                fileAttributes,
                elements,
                Space.format(source, cursor, source.length())
        );
    }

    @Override
    public TomlKey visitKey(TomlParser.KeyContext ctx) {
        return convert(ctx, (c, prefix) -> new Toml.Identifier(
                randomId(),
                prefix,
                Markers.EMPTY,
                c.getText()
        ));
    }

    @Override
    public Toml.KeyValue visitKeyValue(TomlParser.KeyValueContext ctx) {
        return convert(ctx, (c, prefix) -> new Toml.KeyValue(
                randomId(),
                prefix,
                Markers.EMPTY,
                TomlRightPadded.build(visitKey(c.key())).withAfter(sourceBefore("=")),
                visitValue(c.value())
            ));
    }

    @Override
    public Toml visitString(TomlParser.StringContext ctx) {
        return convert(ctx, (c, prefix) -> {
            String string = c.getText();
            return new Toml.Literal(
                    randomId(),
                    prefix,
                    Markers.EMPTY,
                    string,
                    string.substring(1, string.length() - 1)
            );
        });
    }

    @Override
    public Toml visitInteger(TomlParser.IntegerContext ctx) {
        return convert(ctx, (c, prefix) -> {
            String rawNumber = c.getText();
            String number = rawNumber.replace("_", "");
            Long numberValue = rawNumber.startsWith("0x") ? Long.parseLong(number.substring(2), 16) :
                    rawNumber.startsWith("0o") ? Long.parseLong(number.substring(2), 8) :
                            rawNumber.startsWith("0b") ? Long.parseLong(number.substring(2), 2) :
                                Long.parseLong(number);
            return new Toml.Literal(
                    randomId(),
                    prefix,
                    Markers.EMPTY,
                    rawNumber,
                    numberValue
            );
        });
    }

    @Override
    public Toml visitFloatingPoint(TomlParser.FloatingPointContext ctx) {
        return convert(ctx, (c, prefix) -> {
            String rawNumber = c.getText();
            if (c.NAN() != null) {
                return new Toml.Literal(
                        randomId(),
                        prefix,
                        Markers.EMPTY,
                        rawNumber,
                        "nan"
                );
            } else if (c.INF() != null) {
                return new Toml.Literal(
                        randomId(),
                        prefix,
                        Markers.EMPTY,
                        rawNumber,
                        "inf"
                );
            }

            String number = rawNumber.replace("_", "");
            Float numberValue = Float.parseFloat(number);
            return new Toml.Literal(
                    randomId(),
                    prefix,
                    Markers.EMPTY,
                    rawNumber,
                    numberValue
            );
        });
    }

    @Override
    public Toml visitBool(TomlParser.BoolContext ctx) {
        return convert(ctx, (c, prefix) -> {
            String bool = c.getText();
            Boolean boolValue = Boolean.parseBoolean(bool);
            return new Toml.Literal(
                    randomId(),
                    prefix,
                    Markers.EMPTY,
                    bool,
                    boolValue
            );
        });
    }

    private static final DateTimeFormatter RFC3339_OFFSET_DATE_TIME;

    static {
        RFC3339_OFFSET_DATE_TIME = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ISO_LOCAL_DATE)
                .appendLiteral(' ')
                .append(DateTimeFormatter.ISO_LOCAL_TIME)
                .parseLenient()
                .appendOffsetId()
                .parseStrict()
                .toFormatter();
    }

    @Override
    public Toml visitDateTime(TomlParser.DateTimeContext ctx) {
        return convert(ctx, (c, prefix) -> {
            String dateTime = c.getText();
            if (c.OFFSET_DATE_TIME() != null) {
                return new Toml.Literal(
                        randomId(),
                        prefix,
                        Markers.EMPTY,
                        dateTime,
                        dateTime.contains("T") ? OffsetDateTime.parse(dateTime) : OffsetDateTime.parse(dateTime, RFC3339_OFFSET_DATE_TIME)
                );
            } else if (c.LOCAL_DATE_TIME() != null) {
                return new Toml.Literal(
                        randomId(),
                        prefix,
                        Markers.EMPTY,
                        dateTime,
                        LocalDateTime.parse(dateTime)
                );
            } else if (c.LOCAL_DATE() != null) {
                return new Toml.Literal(
                        randomId(),
                        prefix,
                        Markers.EMPTY,
                        dateTime,
                        LocalDate.parse(dateTime)
                );
            }

            return new Toml.Literal(
                    randomId(),
                    prefix,
                    Markers.EMPTY,
                    dateTime,
                    LocalTime.parse(dateTime)
            );
        });
    }

    @Override
    public Toml visitArray(TomlParser.ArrayContext ctx) {
        return convert(ctx, (c, prefix) -> {
            sourceBefore("[");
            List<TomlParser.ValueContext> values = c.value();
            List<TomlRightPadded<Toml>> elements = new ArrayList<>();
            for (int i = 0; i < values.size(); i++) {
                Toml element = visit(values.get(i));
                if (i == values.size() - 1) {
                    if (positionOfNext(",", ']') >= 0) {
                        elements.add(TomlRightPadded.build(element).withAfter(sourceBefore(",")));
                        elements.add(TomlRightPadded.build((Toml) new Toml.Empty(randomId(), Space.EMPTY, Markers.EMPTY)).withAfter(sourceBefore("]")));
                    } else {
                        elements.add(TomlRightPadded.build(element).withAfter(sourceBefore("]")));
                    }
                } else {
                    elements.add(TomlRightPadded.build(element).withAfter(sourceBefore(",")));
                }
            }

            return new Toml.Array(
                    randomId(),
                    prefix,
                    Markers.EMPTY,
                    elements
            );
        });
    }

    @Override
    public Toml visitInlineTable(TomlParser.InlineTableContext ctx) {
        return convert(ctx, (c, prefix) -> {
            sourceBefore("{");
            List<TomlParser.KeyValueContext> values = c.keyValue();
            List<TomlRightPadded<Toml>> elements = new ArrayList<>();
            for (int i = 0; i < values.size(); i++) {
                Toml element = visit(values.get(i));
                if (i == values.size() - 1) {
                    if (positionOfNext(",", '}') >= 0) {
                        elements.add(TomlRightPadded.build(element).withAfter(sourceBefore(",")));
                        elements.add(TomlRightPadded.build((Toml) new Toml.Empty(randomId(), Space.EMPTY, Markers.EMPTY)).withAfter(sourceBefore("}")));
                    } else {
                        elements.add(TomlRightPadded.build(element).withAfter(sourceBefore("}")));
                    }
                } else {
                    elements.add(TomlRightPadded.build(element).withAfter(sourceBefore(",")));
                }
            }

            return new Toml.Table(
                    randomId(),
                    prefix,
                    Markers.build(Collections.singletonList(new InlineTable(randomId()))),
                    null,
                    elements
            );
        });
    }

    @Override
    public Toml visitStandardTable(TomlParser.StandardTableContext ctx) {
        return convert(ctx, (c, prefix) -> {
            sourceBefore("[");
            String tableName = c.key().getText();
            Toml.Identifier name = new Toml.Identifier(
                    randomId(),
                    sourceBefore(tableName),
                    Markers.EMPTY,
                    tableName
            );
            TomlRightPadded<Toml.Identifier> nameRightPadded = TomlRightPadded.build(name).withAfter(sourceBefore("]"));

            List<TomlParser.ExpressionContext> values = c.expression();
            List<TomlRightPadded<Toml>> elements = new ArrayList<>();
            for (int i = 0; i < values.size(); i++) {
                elements.add(TomlRightPadded.build(visit(values.get(i))));
            }

            return new Toml.Table(
                    randomId(),
                    prefix,
                    Markers.EMPTY,
                    nameRightPadded,
                    elements
            );
        });
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
        boolean inSingleLineComment = false;

        int delimIndex = cursor;
        for (; delimIndex < source.length() - untilDelim.length() + 1; delimIndex++) {
            if (inSingleLineComment) {
                if (source.charAt(delimIndex) == '\n') {
                    inSingleLineComment = false;
                }
            } else {
                if (source.charAt(delimIndex) == '#') {
                    inSingleLineComment = true;
                    delimIndex++;
                }

                if (!inSingleLineComment) {
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
