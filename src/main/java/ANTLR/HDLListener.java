// Generated from D:/Development/Projects/HDL/src/main/java/ANTLR\HDL.g4 by ANTLR 4.10.1
package ANTLR;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HDLParser}.
 */
public interface HDLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HDLParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(HDLParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDLParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(HDLParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDLParser#latch}.
	 * @param ctx the parse tree
	 */
	void enterLatch(HDLParser.LatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDLParser#latch}.
	 * @param ctx the parse tree
	 */
	void exitLatch(HDLParser.LatchContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NOT}
	 * labeled alternative in {@link HDLParser#boolexpr}.
	 * @param ctx the parse tree
	 */
	void enterNOT(HDLParser.NOTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NOT}
	 * labeled alternative in {@link HDLParser#boolexpr}.
	 * @param ctx the parse tree
	 */
	void exitNOT(HDLParser.NOTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link HDLParser#boolexpr}.
	 * @param ctx the parse tree
	 */
	void enterVariable(HDLParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link HDLParser#boolexpr}.
	 * @param ctx the parse tree
	 */
	void exitVariable(HDLParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OR}
	 * labeled alternative in {@link HDLParser#boolexpr}.
	 * @param ctx the parse tree
	 */
	void enterOR(HDLParser.ORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OR}
	 * labeled alternative in {@link HDLParser#boolexpr}.
	 * @param ctx the parse tree
	 */
	void exitOR(HDLParser.ORContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AND}
	 * labeled alternative in {@link HDLParser#boolexpr}.
	 * @param ctx the parse tree
	 */
	void enterAND(HDLParser.ANDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AND}
	 * labeled alternative in {@link HDLParser#boolexpr}.
	 * @param ctx the parse tree
	 */
	void exitAND(HDLParser.ANDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link HDLParser#boolexpr}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(HDLParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link HDLParser#boolexpr}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(HDLParser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(HDLParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDLParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(HDLParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDLParser#simulateArgs}.
	 * @param ctx the parse tree
	 */
	void enterSimulateArgs(HDLParser.SimulateArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDLParser#simulateArgs}.
	 * @param ctx the parse tree
	 */
	void exitSimulateArgs(HDLParser.SimulateArgsContext ctx);
}