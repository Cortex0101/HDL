package HDL;

/*
     | e1 = expr '->' e2 = expr   #Instantiate
     | IDENTIFIER '=' e1 = expr   #Assign
     | '(' e1 = expr ')'          #Parentheses
     | '.hardware' IDENTIFIER     #CMDHardware
     | '.inputs' IDENTIFIER       #CMDInputs
     | '.outputs' IDENTIFIER      #CMDOutputs
     | '.latch' e1 = expr         #CMDLatch
     | '.update'                  #CMDUpdate
     | '.simulate'                #CMDSimulate
 */

public abstract class AST{};

abstract class Expr extends AST {
  abstract public Integer eval();

  protected static boolean asBool(Integer integer) {
    return integer != 0;
  }

  protected static Integer asInt(Boolean bool) {
    return bool ? 1 : 0;
  }
}

class Assign extends Expr {


  @Override
  public Integer eval() {
    return null;
  }
}

class NOT extends Expr {
  Expr e1;

  public NOT(Expr e1) {
    this.e1 = e1;
  }

  @Override
  public Integer eval() {
    return asInt(!asBool(e1.eval()));
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
  public Integer eval() {
    return asInt(asBool(e1.eval()) && asBool(e2.eval()));
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
  public Integer eval() {
    return asInt(asBool(e1.eval()) || asBool(e2.eval()));
  }
}

class Constant extends Expr {
  public final Integer x;
  Constant(Integer x){ this.x = x; }
  public Integer eval(){
    return x;
  };
};

class Variable extends Expr {
  public String varname;
  Variable(String varname) {
    this.varname = varname;
  }
  public Integer eval(){
    System.out.println("Variable not implemented, assuming " + varname + " = 0");
    return 0;
  };
};
