// Copyright 2016 John Hurst
// John Hurst (john.b.hurst@gmail.com)
// 2016-05-09

package nz.co.skepticalhumorist.turing.operation;

import nz.co.skepticalhumorist.turing.Tape;

public class NoOp implements Operation {
  @Override
  public Tape executeOn(Tape tape) {
    return tape;
  }
}
