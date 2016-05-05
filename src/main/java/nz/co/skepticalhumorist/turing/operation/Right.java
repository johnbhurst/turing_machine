// Copyright 2016 John Hurst
// John Hurst (john.b.hurst@gmail.com)
// 2016-05-05
package nz.co.skepticalhumorist.turing.operation;

import nz.co.skepticalhumorist.turing.Tape;

public class Right implements Operation {
  @Override
  public Tape executeOn(Tape tape) {
    return new Tape(tape.getPosition() + 1, tape.getContents());
  }
}
