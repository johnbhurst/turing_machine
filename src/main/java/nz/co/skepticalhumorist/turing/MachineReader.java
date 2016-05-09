// Copyright 2016 John Hurst
// John Hurst (john.b.hurst@gmail.com)
// 2016-05-06

package nz.co.skepticalhumorist.turing;

import javaslang.collection.List;
import nz.co.skepticalhumorist.turing.operation.Operation;
import nz.co.skepticalhumorist.turing.operation.Print;

import java.io.IOException;
import java.nio.file.Path;
//import java.util.function.Predicate;

import static java.nio.file.Files.readAllLines;

public class MachineReader {

  private static List<State> parseStates(String s) {
//    Predicate<String> notEmpty = (s1 -> s1.isEmpty()).negate();
    return List.of(s.split(","))
      .filter(item -> !item.isEmpty())
      .map(State::new);
  }

  private static Operation parseOperation(String s) {
    if (s.equals("")) return Operation.N;
    if (s.equals("E")) return Operation.E;
    if (s.equals("L")) return Operation.L;
    if (s.equals("R")) return Operation.R;
    if (s.startsWith("P")) return new Print(s.substring(1));
    throw new IllegalArgumentException("Unknown operation [" + s + "]");
  }

  private static List<Operation> parseOperations(String s) {
    return List.of(s.split(","))
      .map(MachineReader::parseOperation);
  }

  private static Rule parseRule(String line) {
    String[] ruleParts = line.split(":"); // states : symbol : operations : state
    List<State> states = parseStates(ruleParts[0]);
    String currentSymbol = ruleParts[1];
    List<Operation> operations = parseOperations(ruleParts[2]);
    State nextState = new State(ruleParts[3]);
    return new Rule(states, currentSymbol, operations, nextState);
  }

  public Machine read(Path path) throws IOException {
    List<Rule> rules = List.ofAll(readAllLines(path))
      .map(MachineReader::parseRule);
    return new Machine(rules);
  }
}
