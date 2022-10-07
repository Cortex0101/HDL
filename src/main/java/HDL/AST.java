package HDL;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AST{};

abstract class Expr extends AST {
  public abstract Boolean eval(Environment env);
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

  @Override
  public String toString() {
    return "!" + e1;
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

  @Override
  public String toString() {
    return e1 + " && " + e2;
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

  @Override
  public String toString() {
    return e1 + " || " + e2;
  }
}

class Constant extends Expr {
  public final Boolean x;
  Constant(Boolean x){ this.x = x; }
  public Boolean eval(Environment env){
    return x;
  };

  @Override
  public String toString() {
    return String.valueOf(x);
  }
};

class Variable extends Expr {
  public String varname;
  Variable(String varname) {
    this.varname = varname;
  }
  public Boolean eval(Environment env){
    return env.getVariable(varname);
  };

  @Override
  public String toString() {
    return varname;
  }
};

abstract class Command extends AST {
  public abstract void eval(Environment env);
}


class Assignment extends Command {
  String varname;
  Expr e;

  Assignment(String varname, Expr e) {
    this.varname = varname;
    this.e = e;
  }

  @Override
  public void eval(Environment env) {
    env.setVariable(varname,e.eval(env));
  }

  @Override
  public String toString() {
    return varname + " = " + e;
  }
}

class Trace extends AST {
  String name;
  public ArrayList<Boolean> data;

  public Trace(String name, ArrayList<Boolean> data) {
    this.name = name;
    this.data = data;
  }

  public  Trace(String name) {
    this(name, new ArrayList<>());
  }

  @Override
  public String toString() {
    return "Trace{" +
        "name='" + name + '\'' +
        ", data=" + Arrays.toString(data.toArray()) +
        '}';
  }
}

class Latch extends AST {
  String inputName;
  String outputName;

  public Latch(String inputName, String outputName) {
    this.inputName = inputName;
    this.outputName = outputName;
  }

  public void initialize(Environment environment) {
    environment.setVariable(outputName, false);
  }

  public void nextCycle(Environment environment) {
    environment.setVariable(outputName, environment.getVariable(inputName));
  }

  @Override
  public String toString() {
    return "Latch{" +
        "inputName='" + inputName + '\'' +
        ", outputName='" + outputName + '\'' +
        '}';
  }
}

class SimulatorArg extends AST {
  public String argName;
  ArrayList<Boolean> value = new ArrayList<>();

  public SimulatorArg(String argName, ArrayList<Boolean> values) {
    this.argName = argName;
    this.value = values;
  }

  @Override
  public String toString() {
    return "SimulatorArg{" +
        "argName='" + argName + '\'' +
        ", value=" + Arrays.toString(value.toArray()) +
        '}';
  }
}


class Circuit extends AST {

  Environment environment;
  String hardwareName;

  ArrayList<Trace> inputs;
  ArrayList<Trace> outputs;
  ArrayList<Latch> latches;
  ArrayList<Assignment> updates;
  ArrayList<SimulatorArg> simArgs;

  public Circuit( ArrayList<Trace> inputs, ArrayList<Trace> outputs, ArrayList<Latch> latches, ArrayList<Assignment> assignments, ArrayList<SimulatorArg> simArgs, String name, Environment environment) {
    this.hardwareName = name;
    this.inputs = inputs;
    this.outputs = outputs;
    this.latches = latches;
    this.updates = assignments;
    this.simArgs = simArgs;
    this.environment = environment;
  }

  public void nextCycle(int i) {
    // Read current input values and store it in envirement
    for (SimulatorArg simArg : simArgs) {
      environment.setVariable(simArg.argName, simArg.value.get(i));
    }

    // Call initialize or nextCycle for each latch
    if (i == 0) {
      for (Latch latch : latches) {
        latch.initialize(environment);
      }
    } else {
      for (Latch latch : latches) {
        latch.nextCycle(environment);
      }
    }

    // Call eval of every update (ie. assignment)
    for (Assignment update : updates) {
      update.eval(environment);
    }

    // Store value of all output signals appropiately
    for (Trace output : outputs) {
      output.data.add(environment.getVariable(output.name));
    }
  }

  public void runSimulator() {
    final int inputSize = getInputSize();
    for (int i = 0; i < inputSize; i++) {
      nextCycle(i);
    }

    printOutputs();
  }

  public void printOutputs() {
    for (Trace output : outputs) {
      for (Boolean bool : output.data) {
        System.out.print(bool == false ? "0" : "1");
      }

      System.out.println(" " + output.name);
    }
  }

  private int getInputSize() {
    if (simArgs.isEmpty())
      throw new RuntimeException("No simulation arguments provided!");
    final int firstSize = simArgs.get(0).value.size();
    for (SimulatorArg s : simArgs) {
      if (s.value.size() != firstSize)
        throw new RuntimeException("Simulation arguments not of same size!");
    }
    return simArgs.get(0).value.size();
  }

  @Override
  public String toString() {
    return "Circuit{" +
        "hardwareName='" + hardwareName + '\n' +
        ", inputs=" + Arrays.toString(inputs.toArray()) + '\n' +
        ", outputs=" + Arrays.toString(outputs.toArray()) + '\n'  +
        ", latches=" + Arrays.toString(latches.toArray()) + '\n'  +
        ", updates=" + Arrays.toString(updates.toArray()) + '\n'  +
        ", simArgs=" + Arrays.toString(simArgs.toArray()) +
        '}';
  }
}