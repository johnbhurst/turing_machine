// Copyright 2016 John Hurst
// John Hurst (john.b.hurst@gmail.com)
// 2016-05-05

package nz.co.skepticalhumorist.turing;

import javaslang.Tuple2;
import javaslang.collection.List;
import nz.co.skepticalhumorist.turing.operation.Operation;

public class Rule {

  private List<String> currentStates;
  private String currentSymbol;
  private List<Operation> operations;
  private String nextState;

  Rule(List<String> currentStates, String currentSymbol, List<Operation> operations, String nextState) {
    this.currentStates = currentStates;
    this.currentSymbol = currentSymbol;
    this.operations = operations;
    this.nextState = nextState;
  }

  public boolean matches(Tuple2<Tape, String> current) {
    Tape currentTape = current._1();
    String currentState = current._2();
    return currentStates.contains(currentState) &&
      currentTape.getCurrentSymbol().equals(currentSymbol);
  }

  private static Tape applyOp(Tape tape, Operation op) {
    return op.executeOn(tape);
  }

  public Tuple2<Tape, String> executeOn(Tuple2<Tape, String> current) {
    Tape currentTape = current._1();
    Tape resultTape = operations.foldLeft(currentTape, Rule::applyOp);
    return new Tuple2<>(resultTape, nextState);
  }

}
