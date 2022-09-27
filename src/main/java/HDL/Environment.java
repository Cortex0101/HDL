package HDL;

import java.util.HashMap;
import java.util.Map.Entry;

class Environment {
  private final HashMap<String, Boolean> variableValues = new HashMap<>();

  public Environment() { }

  public void setVariable(String name, Boolean value) {
    variableValues.put(name, value);
  }

  public Boolean getVariable(String name){
    Boolean value = variableValues.get(name);
    if (value == null) {
      System.err.println("Variable not defined: " + name);
      System.exit(-1);
    }
    return value;
  }

  public String toString() {
    StringBuilder table = new StringBuilder();
    for (Entry<String, Boolean> entry : variableValues.entrySet()) {
      table.append(entry.getKey()).append("\t-> ").append(entry.getValue()).append("\n");
    }
    return table.toString();
  }
}

