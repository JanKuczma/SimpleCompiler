package com;// Generated from C:/Users/jmuzy/OneDrive - University of Sussex/Year 2/Compilers&CA/215748/task1/src\MyGramm.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MyGrammParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MyGrammVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MyGrammParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(MyGrammParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunDecl}
	 * labeled alternative in {@link MyGrammParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDecl(MyGrammParser.FunDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammParser#vardec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardec(MyGrammParser.VardecContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammParser#vardecne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardecne(MyGrammParser.VardecneContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MyGrammParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Asgmt}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsgmt(MyGrammParser.AsgmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinOpExp}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinOpExp(MyGrammParser.BinOpExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunInvoc}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunInvoc(MyGrammParser.FunInvocContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockLabel}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockLabel(MyGrammParser.BlockLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(MyGrammParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(MyGrammParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RepeatLoop}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatLoop(MyGrammParser.RepeatLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SkipExp}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipExp(MyGrammParser.SkipExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Num}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(MyGrammParser.NumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(MyGrammParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(MyGrammParser.ArgsContext ctx);
}