package HDL;

import ANTLR.HDLLexer;
import ANTLR.HDLParser;
import ANTLR.HDLParser.ANDContext;
import ANTLR.HDLParser.AssignmentContext;
import ANTLR.HDLParser.LatchContext;
import ANTLR.HDLParser.NOTContext;
import ANTLR.HDLParser.ORContext;
import ANTLR.HDLParser.ParenthesesContext;
import ANTLR.HDLParser.SimulateArgsContext;
import ANTLR.HDLParser.StartContext;
import ANTLR.HDLParser.UpdateContext;
import ANTLR.HDLParser.VariableContext;
import ANTLR.HDLVisitor;
import java.io.IOException;
import java.util.ArrayList;
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
    ((Circuit)result).runSimulator();
  }
}

// We write an interpreter that implements interface
// "implVisitor<T>" that is automatically generated by ANTLR
// This is parameterized over a return type "<T>" which is in our case
// simply a Double.

class Interpreter extends AbstractParseTreeVisitor<AST> implements HDLVisitor<AST> {

  public AST visitStart(StartContext ctx) {
    String name = ctx.name.getText();

    ArrayList<String> inNames = new ArrayList<>();
    ArrayList<String> outNames = new ArrayList<>();
    for (var c : ctx.ins) {
      inNames.add(c.getText());
    }

    for (var c : ctx.outs) {
      outNames.add(c.getText());
    }

    ArrayList<Latch> latches = new ArrayList<>();
    for (var c : ctx.larg) {
      latches.add((Latch) visit(c));
    }

    ArrayList<Trace> inTraces = new ArrayList<>();
    ArrayList<Trace> outTraces = new ArrayList<>();

    for (int i = 0; i < inNames.size(); ++i) {
      inTraces.add(new Trace(inNames.get(i)));
    }

    for (int i = 0; i < outNames.size(); ++i) {
      outTraces.add(new Trace(outNames.get(i)));
    }

    ArrayList<Assignment> assignments = new ArrayList<>();
    for (var c : ctx.aarg) {
      assignments.add((Assignment) visit(c));
    }

    ArrayList<SimulatorArg> simArgs = new ArrayList<>();

    for (var c : ctx.sarg) {
      simArgs.add((SimulatorArg) visit(c));
    }

    return new Circuit(inTraces, outTraces, latches, assignments, simArgs, name, new Environment());
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
  public AST visitVariable(VariableContext ctx) {
    return new Variable(ctx.x.getText());
  }

  @Override
  public AST visitAssignment(AssignmentContext ctx) {

    return new Assignment(ctx.e1.getText(), (Expr) visit(ctx.e2.get(0))); //PROBOBLY DOES NOT WORK
  }

  @Override
  public AST visitSimulateArgs(SimulateArgsContext ctx) {
    ArrayList<Boolean> values = new ArrayList<>();
    for (char c : ctx.e2.getText().toCharArray()) {
      if (c == '0')
        values.add(false);
      if (c == '1')
        values.add(true);
    }
    return new SimulatorArg(ctx.e1.getText(), values);
  }

  @Override
  public AST visitLatch(LatchContext ctx) {
    return new Latch(ctx.e1.getText(), ctx.e2.getText());
  }
}

