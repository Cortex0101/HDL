package HDL;

/*
     | e1 = Expr '->' e2 = Expr   #Instantiate
     | IDENTIFIER '=' e1 = Expr   #Assign
     | '(' e1 = Expr ')'          #Parentheses
     | '.hardware' IDENTIFIER     #CMDHardware
     | '.inputs' IDENTIFIER       #CMDInputs
     | '.outputs' IDENTIFIER      #CMDOutputs
     | '.latch' e1 = Expr         #CMDLatch
     | '.update'                  #CMDUpdate
     | '.simulate'                #CMDSimulate
 */

import java.awt.List;
import java.util.ArrayList;

public abstract class AST{};

abstract class Expr extends AST {
  public abstract Boolean eval(Environment env);
}

class Assign extends Expr {

  @Override
  public Boolean eval(Environment env) {
    return null;
  }
}

class NOT extends Expr {
  Expr e1;

  public NOT(Expr e1) {
    this.e1 = e1;
  }

  @Override
  public Boolean eval(Environment env) {
    return !e1.eval(env);
  }
}

class AND extends Expr {
  Expr e1;
  Expr e2;

  public AND(Expr e1, Expr e2) {
    this.e1 = e1;
    this.e2 = e2;
  }

  @Override
  public Boolean eval(Environment env) {
    return e1.eval(env) && e2.eval(env);
  }
}

class OR extends Expr {
  Expr e1;
  Expr e2;

  public OR(Expr e1, Expr e2) {
    this.e1 = e1;
    this.e2 = e2;
  }

  @Override
  public Boolean eval(Environment env) {
    return e1.eval(env) || e2.eval(env);
  }
}

class Constant extends Expr {
  public final Boolean x;
  Constant(Boolean x){ this.x = x; }
  public Boolean eval(Environment env){
    return x;
  };
};

class Variable extends Expr {
  public String varname;
  Variable(String varname) {
    this.varname = varname;
  }
  public Boolean eval(Environment env){
    System.out.println("Variable not implemented, assuming " + varname + " = 0");
    return false;
  };
};

class Latch extends Expr {
  Boolean value;
  String inputName;

  Latch(String inputName) {
    this.value = false;
    this.inputName = inputName;
  }

  @Override
  public Boolean eval(Environment env) {
    this.value = env.getVariable(inputName);
    return this.value;
  }
}

class Trace extends Expr {
  String signalName;
  ArrayList<Boolean> signalAtTimePoint;

  Trace(ArrayList<Boolean> values) {
    signalAtTimePoint = new ArrayList<>(values);
  }

  public int getSize() {
    return signalAtTimePoint.size();
  }

  @Override
  public String toString() {
    return "Trace{" +
        "signalName='" + signalName + '\'' +
        ", signalAtTimePoint=" + signalAtTimePoint +
        '}';
  }

  @Override
  public Boolean eval(Environment env) {
    return null;
  }
}

class Circuit extends AST {
  boolean value;

  ArrayList<Trace> inputs;
  ArrayList<Trace> outputs;
  ArrayList<Latch> latches;

  Circuit() {
    inputs = new ArrayList<Trace>();
    outputs = new ArrayList<Trace>();
    latches = new ArrayList<Latch>();
  }
  public void initialize() {
    this.value = false;
  }


  public void nextCycle(){

  }

  public void runSimulator() {
    final int N = inputs.get(0).getSize(); // all inputs should be same size, and there should be at least one input.
    initialize();
    for (int i = 0; i < N; i++) {
      nextCycle();
    }
  }
}