package com;// Generated from C:/Users/jmuzy/OneDrive - University of Sussex/Year 2/Compilers&CA/215748/task1/src\MyGramm.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyGrammParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LParen=1, RParen=2, LBrace=3, RBrace=4, Comma=5, Colon=6, Semicolon=7, 
		While=8, Do=9, Repeat=10, Until=11, If=12, Then=13, Else=14, Assign=15, 
		Eq=16, Less=17, LessEq=18, Gtr=19, GtrEq=20, Plus=21, Minus=22, Times=23, 
		Div=24, And=25, Or=26, Xor=27, IntType=28, BoolType=29, UnitType=30, Skip=31, 
		Idfr=32, IntLit=33, WL=34;
	public static final int
		RULE_prog = 0, RULE_dec = 1, RULE_vardec = 2, RULE_vardecne = 3, RULE_block = 4, 
		RULE_exp = 5, RULE_args = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dec", "vardec", "vardecne", "block", "exp", "args"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "','", "':'", "';'", "'while'", "'do'", 
			"'repeat'", "'until'", "'if'", "'then'", "'else'", "':='", "'=='", "'<'", 
			"'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'/'", "'&&'", "'||'", "'^^'", 
			"'int'", "'bool'", "'unit'", "'skip'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LParen", "RParen", "LBrace", "RBrace", "Comma", "Colon", "Semicolon", 
			"While", "Do", "Repeat", "Until", "If", "Then", "Else", "Assign", "Eq", 
			"Less", "LessEq", "Gtr", "GtrEq", "Plus", "Minus", "Times", "Div", "And", 
			"Or", "Xor", "IntType", "BoolType", "UnitType", "Skip", "Idfr", "IntLit", 
			"WL"
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
	public String getGrammarFileName() { return "MyGramm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MyGrammParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyGrammVisitor ) return ((MyGrammVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14);
				dec();
				}
				}
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntType) | (1L << BoolType) | (1L << UnitType))) != 0) );
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

	public static class DecContext extends ParserRuleContext {
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
	 
		public DecContext() { }
		public void copyFrom(DecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunDeclContext extends DecContext {
		public Token type;
		public TerminalNode Idfr() { return getToken(MyGrammParser.Idfr, 0); }
		public TerminalNode LParen() { return getToken(MyGrammParser.LParen, 0); }
		public VardecContext vardec() {
			return getRuleContext(VardecContext.class,0);
		}
		public TerminalNode RParen() { return getToken(MyGrammParser.RParen, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode IntType() { return getToken(MyGrammParser.IntType, 0); }
		public TerminalNode BoolType() { return getToken(MyGrammParser.BoolType, 0); }
		public TerminalNode UnitType() { return getToken(MyGrammParser.UnitType, 0); }
		public FunDeclContext(DecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).enterFunDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).exitFunDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyGrammVisitor ) return ((MyGrammVisitor<? extends T>)visitor).visitFunDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dec);
		int _la;
		try {
			_localctx = new FunDeclContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			((FunDeclContext)_localctx).type = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntType) | (1L << BoolType) | (1L << UnitType))) != 0)) ) {
				((FunDeclContext)_localctx).type = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(20);
			match(Idfr);
			setState(21);
			match(LParen);
			setState(22);
			vardec();
			setState(23);
			match(RParen);
			setState(24);
			block();
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

	public static class VardecContext extends ParserRuleContext {
		public List<VardecneContext> vardecne() {
			return getRuleContexts(VardecneContext.class);
		}
		public VardecneContext vardecne(int i) {
			return getRuleContext(VardecneContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MyGrammParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MyGrammParser.Comma, i);
		}
		public VardecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).enterVardec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).exitVardec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyGrammVisitor ) return ((MyGrammVisitor<? extends T>)visitor).visitVardec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardecContext vardec() throws RecognitionException {
		VardecContext _localctx = new VardecContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_vardec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntType) | (1L << BoolType) | (1L << UnitType))) != 0)) {
				{
				setState(26);
				vardecne();
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(27);
					match(Comma);
					setState(28);
					vardecne();
					}
					}
					setState(33);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class VardecneContext extends ParserRuleContext {
		public Token type;
		public TerminalNode Idfr() { return getToken(MyGrammParser.Idfr, 0); }
		public TerminalNode IntType() { return getToken(MyGrammParser.IntType, 0); }
		public TerminalNode BoolType() { return getToken(MyGrammParser.BoolType, 0); }
		public TerminalNode UnitType() { return getToken(MyGrammParser.UnitType, 0); }
		public VardecneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardecne; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).enterVardecne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).exitVardecne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyGrammVisitor ) return ((MyGrammVisitor<? extends T>)visitor).visitVardecne(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardecneContext vardecne() throws RecognitionException {
		VardecneContext _localctx = new VardecneContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_vardecne);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			((VardecneContext)_localctx).type = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntType) | (1L << BoolType) | (1L << UnitType))) != 0)) ) {
				((VardecneContext)_localctx).type = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(37);
			match(Idfr);
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBrace() { return getToken(MyGrammParser.LBrace, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode RBrace() { return getToken(MyGrammParser.RBrace, 0); }
		public List<TerminalNode> Semicolon() { return getTokens(MyGrammParser.Semicolon); }
		public TerminalNode Semicolon(int i) {
			return getToken(MyGrammParser.Semicolon, i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyGrammVisitor ) return ((MyGrammVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(LBrace);
			setState(40);
			exp();
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Semicolon) {
				{
				{
				setState(41);
				match(Semicolon);
				setState(42);
				exp();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
			match(RBrace);
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

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStmtContext extends ExpContext {
		public TerminalNode If() { return getToken(MyGrammParser.If, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Then() { return getToken(MyGrammParser.Then, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode Else() { return getToken(MyGrammParser.Else, 0); }
		public IfStmtContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyGrammVisitor ) return ((MyGrammVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RepeatLoopContext extends ExpContext {
		public TerminalNode Repeat() { return getToken(MyGrammParser.Repeat, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode Until() { return getToken(MyGrammParser.Until, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public RepeatLoopContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).enterRepeatLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).exitRepeatLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyGrammVisitor ) return ((MyGrammVisitor<? extends T>)visitor).visitRepeatLoop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AsgmtContext extends ExpContext {
		public TerminalNode Idfr() { return getToken(MyGrammParser.Idfr, 0); }
		public TerminalNode Assign() { return getToken(MyGrammParser.Assign, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AsgmtContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).enterAsgmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).exitAsgmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyGrammVisitor ) return ((MyGrammVisitor<? extends T>)visitor).visitAsgmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarContext extends ExpContext {
		public TerminalNode Idfr() { return getToken(MyGrammParser.Idfr, 0); }
		public VarContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyGrammVisitor ) return ((MyGrammVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumContext extends ExpContext {
		public TerminalNode IntLit() { return getToken(MyGrammParser.IntLit, 0); }
		public NumContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).exitNum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyGrammVisitor ) return ((MyGrammVisitor<? extends T>)visitor).visitNum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SkipExpContext extends ExpContext {
		public TerminalNode Skip() { return getToken(MyGrammParser.Skip, 0); }
		public SkipExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).enterSkipExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).exitSkipExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyGrammVisitor ) return ((MyGrammVisitor<? extends T>)visitor).visitSkipExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinOpExpContext extends ExpContext {
		public Token binop;
		public TerminalNode LParen() { return getToken(MyGrammParser.LParen, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode RParen() { return getToken(MyGrammParser.RParen, 0); }
		public TerminalNode Eq() { return getToken(MyGrammParser.Eq, 0); }
		public TerminalNode Less() { return getToken(MyGrammParser.Less, 0); }
		public TerminalNode LessEq() { return getToken(MyGrammParser.LessEq, 0); }
		public TerminalNode Gtr() { return getToken(MyGrammParser.Gtr, 0); }
		public TerminalNode GtrEq() { return getToken(MyGrammParser.GtrEq, 0); }
		public TerminalNode Plus() { return getToken(MyGrammParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(MyGrammParser.Minus, 0); }
		public TerminalNode Times() { return getToken(MyGrammParser.Times, 0); }
		public TerminalNode Div() { return getToken(MyGrammParser.Div, 0); }
		public TerminalNode And() { return getToken(MyGrammParser.And, 0); }
		public TerminalNode Or() { return getToken(MyGrammParser.Or, 0); }
		public TerminalNode Xor() { return getToken(MyGrammParser.Xor, 0); }
		public BinOpExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).enterBinOpExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).exitBinOpExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyGrammVisitor ) return ((MyGrammVisitor<? extends T>)visitor).visitBinOpExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockLabelContext extends ExpContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockLabelContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).enterBlockLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).exitBlockLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyGrammVisitor ) return ((MyGrammVisitor<? extends T>)visitor).visitBlockLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileLoopContext extends ExpContext {
		public TerminalNode While() { return getToken(MyGrammParser.While, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Do() { return getToken(MyGrammParser.Do, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileLoopContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).enterWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).exitWhileLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyGrammVisitor ) return ((MyGrammVisitor<? extends T>)visitor).visitWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunInvocContext extends ExpContext {
		public TerminalNode Idfr() { return getToken(MyGrammParser.Idfr, 0); }
		public TerminalNode LParen() { return getToken(MyGrammParser.LParen, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode RParen() { return getToken(MyGrammParser.RParen, 0); }
		public FunInvocContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).enterFunInvoc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).exitFunInvoc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyGrammVisitor ) return ((MyGrammVisitor<? extends T>)visitor).visitFunInvoc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_exp);
		int _la;
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new AsgmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(Idfr);
				setState(51);
				match(Assign);
				setState(52);
				exp();
				}
				break;
			case 2:
				_localctx = new BinOpExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				match(LParen);
				setState(54);
				exp();
				setState(55);
				((BinOpExpContext)_localctx).binop = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Eq) | (1L << Less) | (1L << LessEq) | (1L << Gtr) | (1L << GtrEq) | (1L << Plus) | (1L << Minus) | (1L << Times) | (1L << Div) | (1L << And) | (1L << Or) | (1L << Xor))) != 0)) ) {
					((BinOpExpContext)_localctx).binop = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(56);
				exp();
				setState(57);
				match(RParen);
				}
				break;
			case 3:
				_localctx = new FunInvocContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				match(Idfr);
				setState(60);
				match(LParen);
				setState(61);
				args();
				setState(62);
				match(RParen);
				}
				break;
			case 4:
				_localctx = new BlockLabelContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(64);
				block();
				}
				break;
			case 5:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(65);
				match(If);
				setState(66);
				exp();
				setState(67);
				match(Then);
				setState(68);
				block();
				setState(69);
				match(Else);
				setState(70);
				block();
				}
				break;
			case 6:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(72);
				match(While);
				setState(73);
				exp();
				setState(74);
				match(Do);
				setState(75);
				block();
				}
				break;
			case 7:
				_localctx = new RepeatLoopContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(77);
				match(Repeat);
				setState(78);
				block();
				setState(79);
				match(Until);
				setState(80);
				exp();
				}
				break;
			case 8:
				_localctx = new SkipExpContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(82);
				match(Skip);
				}
				break;
			case 9:
				_localctx = new NumContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(83);
				match(IntLit);
				}
				break;
			case 10:
				_localctx = new VarContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(84);
				match(Idfr);
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

	public static class ArgsContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MyGrammParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MyGrammParser.Comma, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammListener ) ((MyGrammListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyGrammVisitor ) return ((MyGrammVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LParen) | (1L << LBrace) | (1L << While) | (1L << Repeat) | (1L << If) | (1L << Skip) | (1L << Idfr) | (1L << IntLit))) != 0)) {
				{
				setState(87);
				exp();
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(88);
					match(Comma);
					setState(89);
					exp();
					}
					}
					setState(94);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$d\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\22\n\2\r\2\16\2\23\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4 \n\4\f\4\16\4#\13\4\5\4%\n"+
		"\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6.\n\6\f\6\16\6\61\13\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7X"+
		"\n\7\3\b\3\b\3\b\7\b]\n\b\f\b\16\b`\13\b\5\bb\n\b\3\b\2\2\t\2\4\6\b\n"+
		"\f\16\2\4\3\2\36 \3\2\22\35\2k\2\21\3\2\2\2\4\25\3\2\2\2\6$\3\2\2\2\b"+
		"&\3\2\2\2\n)\3\2\2\2\fW\3\2\2\2\16a\3\2\2\2\20\22\5\4\3\2\21\20\3\2\2"+
		"\2\22\23\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\3\3\2\2\2\25\26\t\2\2"+
		"\2\26\27\7\"\2\2\27\30\7\3\2\2\30\31\5\6\4\2\31\32\7\4\2\2\32\33\5\n\6"+
		"\2\33\5\3\2\2\2\34!\5\b\5\2\35\36\7\7\2\2\36 \5\b\5\2\37\35\3\2\2\2 #"+
		"\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"%\3\2\2\2#!\3\2\2\2$\34\3\2\2\2$%\3\2"+
		"\2\2%\7\3\2\2\2&\'\t\2\2\2\'(\7\"\2\2(\t\3\2\2\2)*\7\5\2\2*/\5\f\7\2+"+
		",\7\t\2\2,.\5\f\7\2-+\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\62"+
		"\3\2\2\2\61/\3\2\2\2\62\63\7\6\2\2\63\13\3\2\2\2\64\65\7\"\2\2\65\66\7"+
		"\21\2\2\66X\5\f\7\2\678\7\3\2\289\5\f\7\29:\t\3\2\2:;\5\f\7\2;<\7\4\2"+
		"\2<X\3\2\2\2=>\7\"\2\2>?\7\3\2\2?@\5\16\b\2@A\7\4\2\2AX\3\2\2\2BX\5\n"+
		"\6\2CD\7\16\2\2DE\5\f\7\2EF\7\17\2\2FG\5\n\6\2GH\7\20\2\2HI\5\n\6\2IX"+
		"\3\2\2\2JK\7\n\2\2KL\5\f\7\2LM\7\13\2\2MN\5\n\6\2NX\3\2\2\2OP\7\f\2\2"+
		"PQ\5\n\6\2QR\7\r\2\2RS\5\f\7\2SX\3\2\2\2TX\7!\2\2UX\7#\2\2VX\7\"\2\2W"+
		"\64\3\2\2\2W\67\3\2\2\2W=\3\2\2\2WB\3\2\2\2WC\3\2\2\2WJ\3\2\2\2WO\3\2"+
		"\2\2WT\3\2\2\2WU\3\2\2\2WV\3\2\2\2X\r\3\2\2\2Y^\5\f\7\2Z[\7\7\2\2[]\5"+
		"\f\7\2\\Z\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_b\3\2\2\2`^\3\2\2\2a"+
		"Y\3\2\2\2ab\3\2\2\2b\17\3\2\2\2\t\23!$/W^a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}