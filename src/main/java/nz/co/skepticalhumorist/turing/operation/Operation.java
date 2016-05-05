// Copyright 2016 John Hurst
// John Hurst (john.b.hurst@gmail.com)
// 2016-05-05

package nz.co.skepticalhumorist.turing.operation;

import nz.co.skepticalhumorist.turing.Tape;

public interface Operation {
  Tape executeOn(Tape tape);
}
