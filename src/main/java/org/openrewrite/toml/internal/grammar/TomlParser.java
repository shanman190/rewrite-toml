// Generated from java-escape by ANTLR 4.11.1
package org.openrewrite.toml.internal.grammar;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class TomlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, NL=2, COMMENT=3, L_BRACKET=4, DOUBLE_L_BRACKET=5, R_BRACKET=6, DOUBLE_R_BRACKET=7,
		EQUALS=8, DOT=9, COMMA=10, BASIC_STRING=11, LITERAL_STRING=12, UNQUOTED_KEY=13,
		VALUE_WS=14, L_BRACE=15, BOOLEAN=16, ML_BASIC_STRING=17, ML_LITERAL_STRING=18,
		FLOAT=19, INF=20, NAN=21, DEC_INT=22, HEX_INT=23, OCT_INT=24, BIN_INT=25,
		OFFSET_DATE_TIME=26, LOCAL_DATE_TIME=27, LOCAL_DATE=28, LOCAL_TIME=29,
		INLINE_TABLE_WS=30, R_BRACE=31, ARRAY_WS=32;
	public static final int
		RULE_document = 0, RULE_expression = 1, RULE_comment = 2, RULE_keyValue = 3,
		RULE_key = 4, RULE_simpleKey = 5, RULE_unquotedKey = 6, RULE_quotedKey = 7,
		RULE_dottedKey = 8, RULE_value = 9, RULE_string = 10, RULE_integer = 11,
		RULE_floatingPoint = 12, RULE_bool = 13, RULE_dateTime = 14, RULE_array = 15,
		RULE_arrayValues = 16, RULE_commentOrNl = 17, RULE_nlOrComment = 18, RULE_table = 19,
		RULE_standardTable = 20, RULE_inlineTable = 21, RULE_inlineTableKeyvals = 22,
		RULE_inlineTableKeyvalsNonEmpty = 23, RULE_arrayTable = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"document", "expression", "comment", "keyValue", "key", "simpleKey",
			"unquotedKey", "quotedKey", "dottedKey", "value", "string", "integer",
			"floatingPoint", "bool", "dateTime", "array", "arrayValues", "commentOrNl",
			"nlOrComment", "table", "standardTable", "inlineTable", "inlineTableKeyvals",
			"inlineTableKeyvalsNonEmpty", "arrayTable"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'['", "'[['", "']'", "']]'", "'='", "'.'", "','",
			null, null, null, null, "'{'", null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "NL", "COMMENT", "L_BRACKET", "DOUBLE_L_BRACKET", "R_BRACKET",
			"DOUBLE_R_BRACKET", "EQUALS", "DOT", "COMMA", "BASIC_STRING", "LITERAL_STRING",
			"UNQUOTED_KEY", "VALUE_WS", "L_BRACE", "BOOLEAN", "ML_BASIC_STRING",
			"ML_LITERAL_STRING", "FLOAT", "INF", "NAN", "DEC_INT", "HEX_INT", "OCT_INT",
			"BIN_INT", "OFFSET_DATE_TIME", "LOCAL_DATE_TIME", "LOCAL_DATE", "LOCAL_TIME",
			"INLINE_TABLE_WS", "R_BRACE", "ARRAY_WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TomlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DocumentContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EOF() { return getToken(TomlParser.EOF, 0); }
		public List<TerminalNode> NL() { return getTokens(TomlParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(TomlParser.NL, i);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			expression();
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(51);
				match(NL);
				setState(52);
				expression();
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public KeyValueContext keyValue() {
			return getRuleContext(KeyValueContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BASIC_STRING:
			case LITERAL_STRING:
			case UNQUOTED_KEY:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				keyValue();
				setState(61);
				comment();
				}
				break;
			case L_BRACKET:
			case DOUBLE_L_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				table();
				setState(64);
				comment();
				}
				break;
			case EOF:
			case NL:
			case COMMENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				comment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommentContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(TomlParser.COMMENT, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_comment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT) {
				{
				setState(69);
				match(COMMENT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KeyValueContext extends ParserRuleContext {
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(TomlParser.EQUALS, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public KeyValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterKeyValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitKeyValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitKeyValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyValueContext keyValue() throws RecognitionException {
		KeyValueContext _localctx = new KeyValueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_keyValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			key();
			setState(73);
			match(EQUALS);
			setState(74);
			value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KeyContext extends ParserRuleContext {
		public SimpleKeyContext simpleKey() {
			return getRuleContext(SimpleKeyContext.class,0);
		}
		public DottedKeyContext dottedKey() {
			return getRuleContext(DottedKeyContext.class,0);
		}
		public KeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_key);
		try {
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				simpleKey();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				dottedKey();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleKeyContext extends ParserRuleContext {
		public QuotedKeyContext quotedKey() {
			return getRuleContext(QuotedKeyContext.class,0);
		}
		public UnquotedKeyContext unquotedKey() {
			return getRuleContext(UnquotedKeyContext.class,0);
		}
		public SimpleKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterSimpleKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitSimpleKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitSimpleKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleKeyContext simpleKey() throws RecognitionException {
		SimpleKeyContext _localctx = new SimpleKeyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_simpleKey);
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BASIC_STRING:
			case LITERAL_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				quotedKey();
				}
				break;
			case UNQUOTED_KEY:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				unquotedKey();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnquotedKeyContext extends ParserRuleContext {
		public TerminalNode UNQUOTED_KEY() { return getToken(TomlParser.UNQUOTED_KEY, 0); }
		public UnquotedKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unquotedKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterUnquotedKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitUnquotedKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitUnquotedKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnquotedKeyContext unquotedKey() throws RecognitionException {
		UnquotedKeyContext _localctx = new UnquotedKeyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_unquotedKey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(UNQUOTED_KEY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuotedKeyContext extends ParserRuleContext {
		public TerminalNode BASIC_STRING() { return getToken(TomlParser.BASIC_STRING, 0); }
		public TerminalNode LITERAL_STRING() { return getToken(TomlParser.LITERAL_STRING, 0); }
		public QuotedKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quotedKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterQuotedKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitQuotedKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitQuotedKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuotedKeyContext quotedKey() throws RecognitionException {
		QuotedKeyContext _localctx = new QuotedKeyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_quotedKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_la = _input.LA(1);
			if ( !(_la==BASIC_STRING || _la==LITERAL_STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DottedKeyContext extends ParserRuleContext {
		public List<SimpleKeyContext> simpleKey() {
			return getRuleContexts(SimpleKeyContext.class);
		}
		public SimpleKeyContext simpleKey(int i) {
			return getRuleContext(SimpleKeyContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(TomlParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(TomlParser.DOT, i);
		}
		public DottedKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dottedKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterDottedKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitDottedKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitDottedKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DottedKeyContext dottedKey() throws RecognitionException {
		DottedKeyContext _localctx = new DottedKeyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_dottedKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			simpleKey();
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(89);
				match(DOT);
				setState(90);
				simpleKey();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DOT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public FloatingPointContext floatingPoint() {
			return getRuleContext(FloatingPointContext.class,0);
		}
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public DateTimeContext dateTime() {
			return getRuleContext(DateTimeContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public InlineTableContext inlineTable() {
			return getRuleContext(InlineTableContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_value);
		try {
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BASIC_STRING:
			case LITERAL_STRING:
			case ML_BASIC_STRING:
			case ML_LITERAL_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				string();
				}
				break;
			case DEC_INT:
			case HEX_INT:
			case OCT_INT:
			case BIN_INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				integer();
				}
				break;
			case FLOAT:
			case INF:
			case NAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				floatingPoint();
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(98);
				bool();
				}
				break;
			case OFFSET_DATE_TIME:
			case LOCAL_DATE_TIME:
			case LOCAL_DATE:
			case LOCAL_TIME:
				enterOuterAlt(_localctx, 5);
				{
				setState(99);
				dateTime();
				}
				break;
			case L_BRACKET:
				enterOuterAlt(_localctx, 6);
				{
				setState(100);
				array();
				}
				break;
			case L_BRACE:
				enterOuterAlt(_localctx, 7);
				{
				setState(101);
				inlineTable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ParserRuleContext {
		public TerminalNode BASIC_STRING() { return getToken(TomlParser.BASIC_STRING, 0); }
		public TerminalNode ML_BASIC_STRING() { return getToken(TomlParser.ML_BASIC_STRING, 0); }
		public TerminalNode LITERAL_STRING() { return getToken(TomlParser.LITERAL_STRING, 0); }
		public TerminalNode ML_LITERAL_STRING() { return getToken(TomlParser.ML_LITERAL_STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 399360L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode DEC_INT() { return getToken(TomlParser.DEC_INT, 0); }
		public TerminalNode HEX_INT() { return getToken(TomlParser.HEX_INT, 0); }
		public TerminalNode OCT_INT() { return getToken(TomlParser.OCT_INT, 0); }
		public TerminalNode BIN_INT() { return getToken(TomlParser.BIN_INT, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 62914560L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FloatingPointContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(TomlParser.FLOAT, 0); }
		public TerminalNode INF() { return getToken(TomlParser.INF, 0); }
		public TerminalNode NAN() { return getToken(TomlParser.NAN, 0); }
		public FloatingPointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatingPoint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterFloatingPoint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitFloatingPoint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitFloatingPoint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloatingPointContext floatingPoint() throws RecognitionException {
		FloatingPointContext _localctx = new FloatingPointContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_floatingPoint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 3670016L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(TomlParser.BOOLEAN, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_bool);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(BOOLEAN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DateTimeContext extends ParserRuleContext {
		public TerminalNode OFFSET_DATE_TIME() { return getToken(TomlParser.OFFSET_DATE_TIME, 0); }
		public TerminalNode LOCAL_DATE_TIME() { return getToken(TomlParser.LOCAL_DATE_TIME, 0); }
		public TerminalNode LOCAL_DATE() { return getToken(TomlParser.LOCAL_DATE, 0); }
		public TerminalNode LOCAL_TIME() { return getToken(TomlParser.LOCAL_TIME, 0); }
		public DateTimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dateTime; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterDateTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitDateTime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitDateTime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateTimeContext dateTime() throws RecognitionException {
		DateTimeContext _localctx = new DateTimeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_dateTime);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 1006632960L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode L_BRACKET() { return getToken(TomlParser.L_BRACKET, 0); }
		public CommentOrNlContext commentOrNl() {
			return getRuleContext(CommentOrNlContext.class,0);
		}
		public TerminalNode R_BRACKET() { return getToken(TomlParser.R_BRACKET, 0); }
		public ArrayValuesContext arrayValues() {
			return getRuleContext(ArrayValuesContext.class,0);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(L_BRACKET);
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(115);
				arrayValues();
				}
				break;
			}
			setState(118);
			commentOrNl();
			setState(119);
			match(R_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayValuesContext extends ParserRuleContext {
		public List<CommentOrNlContext> commentOrNl() {
			return getRuleContexts(CommentOrNlContext.class);
		}
		public CommentOrNlContext commentOrNl(int i) {
			return getRuleContext(CommentOrNlContext.class,i);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public NlOrCommentContext nlOrComment() {
			return getRuleContext(NlOrCommentContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(TomlParser.COMMA, 0); }
		public ArrayValuesContext arrayValues() {
			return getRuleContext(ArrayValuesContext.class,0);
		}
		public ArrayValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayValues; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterArrayValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitArrayValues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitArrayValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayValuesContext arrayValues() throws RecognitionException {
		ArrayValuesContext _localctx = new ArrayValuesContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_arrayValues);
		int _la;
		try {
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(121);
				commentOrNl();
				setState(122);
				value();
				setState(123);
				nlOrComment();
				setState(124);
				match(COMMA);
				setState(125);
				arrayValues();
				setState(126);
				commentOrNl();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				commentOrNl();
				setState(129);
				value();
				setState(130);
				nlOrComment();
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(131);
					match(COMMA);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommentOrNlContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(TomlParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(TomlParser.NL, i);
		}
		public List<TerminalNode> COMMENT() { return getTokens(TomlParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(TomlParser.COMMENT, i);
		}
		public CommentOrNlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commentOrNl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterCommentOrNl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitCommentOrNl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitCommentOrNl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentOrNlContext commentOrNl() throws RecognitionException {
		CommentOrNlContext _localctx = new CommentOrNlContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_commentOrNl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMENT) {
						{
						setState(136);
						match(COMMENT);
						}
					}

					setState(139);
					match(NL);
					}
					}
				}
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NlOrCommentContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(TomlParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(TomlParser.NL, i);
		}
		public List<TerminalNode> COMMENT() { return getTokens(TomlParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(TomlParser.COMMENT, i);
		}
		public NlOrCommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nlOrComment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterNlOrComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitNlOrComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitNlOrComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NlOrCommentContext nlOrComment() throws RecognitionException {
		NlOrCommentContext _localctx = new NlOrCommentContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_nlOrComment);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(145);
					match(NL);
					setState(147);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						setState(146);
						match(COMMENT);
						}
						break;
					}
					}
					}
				}
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableContext extends ParserRuleContext {
		public StandardTableContext standardTable() {
			return getRuleContext(StandardTableContext.class,0);
		}
		public ArrayTableContext arrayTable() {
			return getRuleContext(ArrayTableContext.class,0);
		}
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_table);
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_BRACKET:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				standardTable();
				}
				break;
			case DOUBLE_L_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				arrayTable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StandardTableContext extends ParserRuleContext {
		public TerminalNode L_BRACKET() { return getToken(TomlParser.L_BRACKET, 0); }
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public TerminalNode R_BRACKET() { return getToken(TomlParser.R_BRACKET, 0); }
		public StandardTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_standardTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterStandardTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitStandardTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitStandardTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StandardTableContext standardTable() throws RecognitionException {
		StandardTableContext _localctx = new StandardTableContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_standardTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(L_BRACKET);
			setState(159);
			key();
			setState(160);
			match(R_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InlineTableContext extends ParserRuleContext {
		public TerminalNode L_BRACE() { return getToken(TomlParser.L_BRACE, 0); }
		public InlineTableKeyvalsContext inlineTableKeyvals() {
			return getRuleContext(InlineTableKeyvalsContext.class,0);
		}
		public TerminalNode R_BRACE() { return getToken(TomlParser.R_BRACE, 0); }
		public InlineTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterInlineTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitInlineTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitInlineTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlineTableContext inlineTable() throws RecognitionException {
		InlineTableContext _localctx = new InlineTableContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_inlineTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(L_BRACE);
			setState(163);
			inlineTableKeyvals();
			setState(164);
			match(R_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InlineTableKeyvalsContext extends ParserRuleContext {
		public InlineTableKeyvalsNonEmptyContext inlineTableKeyvalsNonEmpty() {
			return getRuleContext(InlineTableKeyvalsNonEmptyContext.class,0);
		}
		public InlineTableKeyvalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineTableKeyvals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterInlineTableKeyvals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitInlineTableKeyvals(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitInlineTableKeyvals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlineTableKeyvalsContext inlineTableKeyvals() throws RecognitionException {
		InlineTableKeyvalsContext _localctx = new InlineTableKeyvalsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_inlineTableKeyvals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 14336L) != 0) {
				{
				setState(166);
				inlineTableKeyvalsNonEmpty();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InlineTableKeyvalsNonEmptyContext extends ParserRuleContext {
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(TomlParser.EQUALS, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(TomlParser.COMMA, 0); }
		public InlineTableKeyvalsNonEmptyContext inlineTableKeyvalsNonEmpty() {
			return getRuleContext(InlineTableKeyvalsNonEmptyContext.class,0);
		}
		public InlineTableKeyvalsNonEmptyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineTableKeyvalsNonEmpty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterInlineTableKeyvalsNonEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitInlineTableKeyvalsNonEmpty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitInlineTableKeyvalsNonEmpty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlineTableKeyvalsNonEmptyContext inlineTableKeyvalsNonEmpty() throws RecognitionException {
		InlineTableKeyvalsNonEmptyContext _localctx = new InlineTableKeyvalsNonEmptyContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_inlineTableKeyvalsNonEmpty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			key();
			setState(170);
			match(EQUALS);
			setState(171);
			value();
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(172);
				match(COMMA);
				setState(173);
				inlineTableKeyvalsNonEmpty();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayTableContext extends ParserRuleContext {
		public TerminalNode DOUBLE_L_BRACKET() { return getToken(TomlParser.DOUBLE_L_BRACKET, 0); }
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public TerminalNode DOUBLE_R_BRACKET() { return getToken(TomlParser.DOUBLE_R_BRACKET, 0); }
		public ArrayTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).enterArrayTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TomlParserListener ) ((TomlParserListener)listener).exitArrayTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TomlParserVisitor ) return ((TomlParserVisitor<? extends T>)visitor).visitArrayTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTableContext arrayTable() throws RecognitionException {
		ArrayTableContext _localctx = new ArrayTableContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_arrayTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(DOUBLE_L_BRACKET);
			setState(177);
			key();
			setState(178);
			match(DOUBLE_R_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001 \u00b5\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u00006\b\u0000\n\u0000\f\u0000"+
		"9\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001D\b\u0001"+
		"\u0001\u0002\u0003\u0002G\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0003\u0004O\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0003\u0005S\b\u0005\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0004\b\\\b\b\u000b\b\f\b]\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\tg\b\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0003\u000fu\b\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u0085\b\u0010\u0003\u0010\u0087\b\u0010"+
		"\u0001\u0011\u0003\u0011\u008a\b\u0011\u0001\u0011\u0005\u0011\u008d\b"+
		"\u0011\n\u0011\f\u0011\u0090\t\u0011\u0001\u0012\u0001\u0012\u0003\u0012"+
		"\u0094\b\u0012\u0005\u0012\u0096\b\u0012\n\u0012\f\u0012\u0099\t\u0012"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u009d\b\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0003\u0016\u00a8\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0003\u0017\u00af\b\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0000\u0000\u0019\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.0\u0000\u0005\u0001\u0000\u000b\f\u0002\u0000\u000b\f\u0011\u0012"+
		"\u0001\u0000\u0016\u0019\u0001\u0000\u0013\u0015\u0001\u0000\u001a\u001d"+
		"\u00b2\u00002\u0001\u0000\u0000\u0000\u0002C\u0001\u0000\u0000\u0000\u0004"+
		"F\u0001\u0000\u0000\u0000\u0006H\u0001\u0000\u0000\u0000\bN\u0001\u0000"+
		"\u0000\u0000\nR\u0001\u0000\u0000\u0000\fT\u0001\u0000\u0000\u0000\u000e"+
		"V\u0001\u0000\u0000\u0000\u0010X\u0001\u0000\u0000\u0000\u0012f\u0001"+
		"\u0000\u0000\u0000\u0014h\u0001\u0000\u0000\u0000\u0016j\u0001\u0000\u0000"+
		"\u0000\u0018l\u0001\u0000\u0000\u0000\u001an\u0001\u0000\u0000\u0000\u001c"+
		"p\u0001\u0000\u0000\u0000\u001er\u0001\u0000\u0000\u0000 \u0086\u0001"+
		"\u0000\u0000\u0000\"\u008e\u0001\u0000\u0000\u0000$\u0097\u0001\u0000"+
		"\u0000\u0000&\u009c\u0001\u0000\u0000\u0000(\u009e\u0001\u0000\u0000\u0000"+
		"*\u00a2\u0001\u0000\u0000\u0000,\u00a7\u0001\u0000\u0000\u0000.\u00a9"+
		"\u0001\u0000\u0000\u00000\u00b0\u0001\u0000\u0000\u000027\u0003\u0002"+
		"\u0001\u000034\u0005\u0002\u0000\u000046\u0003\u0002\u0001\u000053\u0001"+
		"\u0000\u0000\u000069\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u0000"+
		"78\u0001\u0000\u0000\u00008:\u0001\u0000\u0000\u000097\u0001\u0000\u0000"+
		"\u0000:;\u0005\u0000\u0000\u0001;\u0001\u0001\u0000\u0000\u0000<=\u0003"+
		"\u0006\u0003\u0000=>\u0003\u0004\u0002\u0000>D\u0001\u0000\u0000\u0000"+
		"?@\u0003&\u0013\u0000@A\u0003\u0004\u0002\u0000AD\u0001\u0000\u0000\u0000"+
		"BD\u0003\u0004\u0002\u0000C<\u0001\u0000\u0000\u0000C?\u0001\u0000\u0000"+
		"\u0000CB\u0001\u0000\u0000\u0000D\u0003\u0001\u0000\u0000\u0000EG\u0005"+
		"\u0003\u0000\u0000FE\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000"+
		"G\u0005\u0001\u0000\u0000\u0000HI\u0003\b\u0004\u0000IJ\u0005\b\u0000"+
		"\u0000JK\u0003\u0012\t\u0000K\u0007\u0001\u0000\u0000\u0000LO\u0003\n"+
		"\u0005\u0000MO\u0003\u0010\b\u0000NL\u0001\u0000\u0000\u0000NM\u0001\u0000"+
		"\u0000\u0000O\t\u0001\u0000\u0000\u0000PS\u0003\u000e\u0007\u0000QS\u0003"+
		"\f\u0006\u0000RP\u0001\u0000\u0000\u0000RQ\u0001\u0000\u0000\u0000S\u000b"+
		"\u0001\u0000\u0000\u0000TU\u0005\r\u0000\u0000U\r\u0001\u0000\u0000\u0000"+
		"VW\u0007\u0000\u0000\u0000W\u000f\u0001\u0000\u0000\u0000X[\u0003\n\u0005"+
		"\u0000YZ\u0005\t\u0000\u0000Z\\\u0003\n\u0005\u0000[Y\u0001\u0000\u0000"+
		"\u0000\\]\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000"+
		"\u0000\u0000^\u0011\u0001\u0000\u0000\u0000_g\u0003\u0014\n\u0000`g\u0003"+
		"\u0016\u000b\u0000ag\u0003\u0018\f\u0000bg\u0003\u001a\r\u0000cg\u0003"+
		"\u001c\u000e\u0000dg\u0003\u001e\u000f\u0000eg\u0003*\u0015\u0000f_\u0001"+
		"\u0000\u0000\u0000f`\u0001\u0000\u0000\u0000fa\u0001\u0000\u0000\u0000"+
		"fb\u0001\u0000\u0000\u0000fc\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000"+
		"\u0000fe\u0001\u0000\u0000\u0000g\u0013\u0001\u0000\u0000\u0000hi\u0007"+
		"\u0001\u0000\u0000i\u0015\u0001\u0000\u0000\u0000jk\u0007\u0002\u0000"+
		"\u0000k\u0017\u0001\u0000\u0000\u0000lm\u0007\u0003\u0000\u0000m\u0019"+
		"\u0001\u0000\u0000\u0000no\u0005\u0010\u0000\u0000o\u001b\u0001\u0000"+
		"\u0000\u0000pq\u0007\u0004\u0000\u0000q\u001d\u0001\u0000\u0000\u0000"+
		"rt\u0005\u0004\u0000\u0000su\u0003 \u0010\u0000ts\u0001\u0000\u0000\u0000"+
		"tu\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0003\"\u0011\u0000"+
		"wx\u0005\u0006\u0000\u0000x\u001f\u0001\u0000\u0000\u0000yz\u0003\"\u0011"+
		"\u0000z{\u0003\u0012\t\u0000{|\u0003$\u0012\u0000|}\u0005\n\u0000\u0000"+
		"}~\u0003 \u0010\u0000~\u007f\u0003\"\u0011\u0000\u007f\u0087\u0001\u0000"+
		"\u0000\u0000\u0080\u0081\u0003\"\u0011\u0000\u0081\u0082\u0003\u0012\t"+
		"\u0000\u0082\u0084\u0003$\u0012\u0000\u0083\u0085\u0005\n\u0000\u0000"+
		"\u0084\u0083\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000"+
		"\u0085\u0087\u0001\u0000\u0000\u0000\u0086y\u0001\u0000\u0000\u0000\u0086"+
		"\u0080\u0001\u0000\u0000\u0000\u0087!\u0001\u0000\u0000\u0000\u0088\u008a"+
		"\u0005\u0003\u0000\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u0089\u008a"+
		"\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008d"+
		"\u0005\u0002\u0000\u0000\u008c\u0089\u0001\u0000\u0000\u0000\u008d\u0090"+
		"\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008e\u008f"+
		"\u0001\u0000\u0000\u0000\u008f#\u0001\u0000\u0000\u0000\u0090\u008e\u0001"+
		"\u0000\u0000\u0000\u0091\u0093\u0005\u0002\u0000\u0000\u0092\u0094\u0005"+
		"\u0003\u0000\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0093\u0094\u0001"+
		"\u0000\u0000\u0000\u0094\u0096\u0001\u0000\u0000\u0000\u0095\u0091\u0001"+
		"\u0000\u0000\u0000\u0096\u0099\u0001\u0000\u0000\u0000\u0097\u0095\u0001"+
		"\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098%\u0001\u0000"+
		"\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u009d\u0003(\u0014"+
		"\u0000\u009b\u009d\u00030\u0018\u0000\u009c\u009a\u0001\u0000\u0000\u0000"+
		"\u009c\u009b\u0001\u0000\u0000\u0000\u009d\'\u0001\u0000\u0000\u0000\u009e"+
		"\u009f\u0005\u0004\u0000\u0000\u009f\u00a0\u0003\b\u0004\u0000\u00a0\u00a1"+
		"\u0005\u0006\u0000\u0000\u00a1)\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005"+
		"\u000f\u0000\u0000\u00a3\u00a4\u0003,\u0016\u0000\u00a4\u00a5\u0005\u001f"+
		"\u0000\u0000\u00a5+\u0001\u0000\u0000\u0000\u00a6\u00a8\u0003.\u0017\u0000"+
		"\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a8-\u0001\u0000\u0000\u0000\u00a9\u00aa\u0003\b\u0004\u0000\u00aa"+
		"\u00ab\u0005\b\u0000\u0000\u00ab\u00ae\u0003\u0012\t\u0000\u00ac\u00ad"+
		"\u0005\n\u0000\u0000\u00ad\u00af\u0003.\u0017\u0000\u00ae\u00ac\u0001"+
		"\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af/\u0001\u0000"+
		"\u0000\u0000\u00b0\u00b1\u0005\u0005\u0000\u0000\u00b1\u00b2\u0003\b\u0004"+
		"\u0000\u00b2\u00b3\u0005\u0007\u0000\u0000\u00b31\u0001\u0000\u0000\u0000"+
		"\u00117CFNR]ft\u0084\u0086\u0089\u008e\u0093\u0097\u009c\u00a7\u00ae";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
