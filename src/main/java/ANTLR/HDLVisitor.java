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
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(HDLParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OR}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOR(HDLParser.ORContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(HDLParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CMDSimulate}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCMDSimulate(HDLParser.CMDSimulateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CMDOutputs}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCMDOutputs(HDLParser.CMDOutputsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NOT}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNOT(HDLParser.NOTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CMDHardware}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCMDHardware(HDLParser.CMDHardwareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CMDUpdate}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCMDUpdate(HDLParser.CMDUpdateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AND}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAND(HDLParser.ANDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(HDLParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Instantiate}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstantiate(HDLParser.InstantiateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CMDInputs}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCMDInputs(HDLParser.CMDInputsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentheses(HDLParser.ParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CMDLatch}
	 * labeled alternative in {@link HDLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCMDLatch(HDLParser.CMDLatchContext ctx);
}