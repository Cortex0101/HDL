package HDL;

import ANTLR.HDLLexer;
import ANTLR.HDLParser;
import ANTLR.HDLParser.ANDContext;
import ANTLR.HDLParser.AssignmentContext;
import ANTLR.HDLParser.ConstantContext;
import ANTLR.HDLParser.HardwareContext;
import ANTLR.HDLParser.InputsContext;
import ANTLR.HDLParser.LatchContext;
import ANTLR.HDLParser.NOTContext;
import ANTLR.HDLParser.ORContext;
import ANTLR.HDLParser.OutputsContext;
import ANTLR.HDLParser.ParenthesesContext;
import ANTLR.HDLParser.SimulateContext;
import ANTLR.HDLParser.StartContext;
import ANTLR.HDLParser.UpdateContext;
import ANTLR.HDLParser.VariableContext;
import ANTLR.HDLVisitor;
import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
  public static void main(String[] args) throws IOException {
    // we expect exactly one argument: the name of the input file
    if (args.length!=1) {
      System.err.println("\n");
      System.err.println("Impl Interpreter\n");
      System.err.println("=================\n\n");
      System.err.println("Please give as input argument a filename\n");
      System.exit(-1);
    }
    String filename=args[0];

    // open the input file
    CharStream input = CharStreams.fromFileName("D:\\Development\\Projects\\HDL\\src\\main\\resources\\" + filename);

    // create a lexer/scanner
    HDLLexer lex = new HDLLexer(input);

    // get the stream of tokens from the scanner
    CommonTokenStream tokens = new CommonTokenStream(lex);

    // create a parser
    HDLParser parser = new HDLParser(tokens);

    // and parse anything from the grammar for "start"
    ParseTree parseTree = parser.start();

    System.out.println(parseTree.toStringTree());

    // Construct an interpreter and run it on the parse tree
    Interpreter interpreter = new Interpreter();
    AST result = interpreter.visit(parseTree);
    if (result instanceof Command) {
      ((Command) result).eval(new Environment());
    } else {
      System.out.println(((Expr) result).eval(new Environment()));
    }
  }
}

// We write an interpreter that implements interface
// "implVisitor<T>" that is automatically generated by ANTLR
// This is parameterized over a return type "<T>" which is in our case
// simply a Double.

class Interpreter extends AbstractParseTreeVisitor<AST> implements HDLVisitor<AST> {
  public AST visitStart(StartContext ctx) {
    return visit(ctx.e1);
  }

  @Override
  public AST visitOR(ORContext ctx) {
    return new OR((Expr) visit(ctx.e1), (Expr) visit(ctx.e2));
  }

  @Override
  public AST visitNOT(NOTContext ctx) {
    return new NOT((Expr) visit(ctx.e1));
  }

  @Override
  public AST visitAND(ANDContext ctx) {
    return new AND((Expr) visit(ctx.e1), (Expr) visit(ctx.e2));
  }

  @Override
  public AST visitParentheses(ParenthesesContext ctx) {
    return visit(ctx.e1);
  }


  @Override
  public AST visitConstant(ConstantContext ctx) {
    return new Constant(Boolean.parseBoolean(ctx.c.getText()));
  }


  @Override
  public AST visitVariable(VariableContext ctx) {
    return new Variable(ctx.x.getText());
  }

  @Override
  public AST visitAssignment(AssignmentContext ctx) {
    return new Assignment(ctx.e1.getText(), (Expr) visit(ctx.e2));
  }

  @Override
  public AST visitLatch(LatchContext ctx) {
    return ctx.
  }

  @Override
  public AST visitHardware(HardwareContext ctx) {
    return null;
  }

  @Override
  public AST visitSimulate(SimulateContext ctx) {
    return null;
  }

  @Override
  public AST visitOutputs(OutputsContext ctx) {
    return null;
  }

  @Override
  public AST visitUpdate(UpdateContext ctx) {
    return null;
  }

  @Override
  public AST visitInputs(InputsContext ctx) {
    return null;
  }
}

