// Copyright 2016 John Hurst
// John Hurst (john.b.hurst@gmail.com)
// 2016-05-06

package nz.co.skepticalhumorist.turing;

public class MachineState {

  private Tape tape;
  private State state;

  public MachineState(Tape tape, State state) {
    this.tape = tape;
    this.state = state;
  }

  public Tape getTape() {
    return tape;
  }

  public State getState() {
    return state;
  }

}
