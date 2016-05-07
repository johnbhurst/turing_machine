// Copyright 2016 John Hurst
// John Hurst (john.b.hurst@gmail.com)
// 2016-05-06

package nz.co.skepticalhumorist.turing;

import java.util.Objects;

public class MachineState {

  public static final MachineState BEGIN_MACHINE = new MachineState(new Tape(0, ""), State.BEGIN);

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

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    MachineState that = (MachineState) obj;
    return Objects.equals(tape, that.tape) &&
      Objects.equals(state, that.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tape, state);
  }

  @Override
  public String toString() {
    return state + ":" + tape;
  }
}
