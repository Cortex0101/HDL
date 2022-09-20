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
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariable(HDLParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariable(HDLParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OR}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOR(HDLParser.ORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OR}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOR(HDLParser.ORContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstant(HDLParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstant(HDLParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CMDSimulate}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCMDSimulate(HDLParser.CMDSimulateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CMDSimulate}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCMDSimulate(HDLParser.CMDSimulateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CMDOutputs}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCMDOutputs(HDLParser.CMDOutputsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CMDOutputs}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCMDOutputs(HDLParser.CMDOutputsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NOT}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNOT(HDLParser.NOTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NOT}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNOT(HDLParser.NOTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CMDHardware}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCMDHardware(HDLParser.CMDHardwareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CMDHardware}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCMDHardware(HDLParser.CMDHardwareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CMDUpdate}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCMDUpdate(HDLParser.CMDUpdateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CMDUpdate}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCMDUpdate(HDLParser.CMDUpdateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AND}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAND(HDLParser.ANDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AND}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAND(HDLParser.ANDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign(HDLParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign(HDLParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Instantiate}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInstantiate(HDLParser.InstantiateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Instantiate}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInstantiate(HDLParser.InstantiateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CMDInputs}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCMDInputs(HDLParser.CMDInputsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CMDInputs}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCMDInputs(HDLParser.CMDInputsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(HDLParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(HDLParser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CMDLatch}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCMDLatch(HDLParser.CMDLatchContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CMDLatch}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCMDLatch(HDLParser.CMDLatchContext ctx);
}