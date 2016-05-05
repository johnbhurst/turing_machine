// Copyright 2016 John Hurst
// John Hurst (john.b.hurst@gmail.com)
// 2016-05-05
package nz.co.skepticalhumorist.turing.operation;

import javaslang.collection.List;
import nz.co.skepticalhumorist.turing.Tape;

public class Right implements Operation {
  @Override
  public Tape executeOn(Tape tape) {
    List<String> newContents =
      tape.getPosition() == tape.getContents().length() - 1 ?
        tape.getContents().append("") :
        tape.getContents();
    return new Tape(tape.getPosition() + 1, newContents);
  }
}
