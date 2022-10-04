// Generated from D:/Development/Projects/HDL/src/main/java/ANTLR\HDL.g4 by ANTLR 4.10.1
package ANTLR;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HDLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HDLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HDLParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(HDLParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link HDLParser#latch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLatch(HDLParser.LatchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NOT}
	 * labeled alternative in {@link HDLParser#boolexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNOT(HDLParser.NOTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link HDLParser#boolexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(HDLParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OR}
	 * labeled alternative in {@link HDLParser#boolexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOR(HDLParser.ORContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AND}
	 * labeled alternative in {@link HDLParser#boolexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAND(HDLParser.ANDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link HDLParser#boolexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentheses(HDLParser.ParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by {@link HDLParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(HDLParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link HDLParser#simulateArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimulateArgs(HDLParser.SimulateArgsContext ctx);
}