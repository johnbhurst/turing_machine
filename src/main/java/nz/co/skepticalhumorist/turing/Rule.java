// Copyright 2016 John Hurst
// John Hurst (john.b.hurst@gmail.com)
// 2016-05-05

package nz.co.skepticalhumorist.turing;

import javaslang.Tuple2;
import javaslang.collection.List;
import nz.co.skepticalhumorist.turing.operation.Operation;

public class Rule {

  private List<State> currentStates;
  private String currentSymbol;
  private List<Operation> operations;
  private State nextState;

  Rule(List<State> currentStates, String currentSymbol, List<Operation> operations, State nextState) {
    this.currentStates = currentStates;
    this.currentSymbol = currentSymbol;
    this.operations = operations;
    this.nextState = nextState;
  }

  public boolean matches(MachineState machineState) {
    return currentStates.contains(machineState.getState()) &&
      machineState.getTape().getCurrentSymbol().equals(currentSymbol);
  }

  private static Tape applyOp(Tape tape, Operation op) {
    return op.executeOn(tape);
  }

  public MachineState executeOn(MachineState machineState) {
    Tape currentTape = machineState.getTape();
    Tape resultTape = operations.foldLeft(currentTape, Rule::applyOp);
    return new MachineState(resultTape, nextState);
  }

}
