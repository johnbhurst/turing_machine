// Copyright 2016 John Hurst
// John Hurst (john.b.hurst@gmail.com)
// 2016-05-05

package nz.co.skepticalhumorist.turing.operation;

import javaslang.collection.List;
import nz.co.skepticalhumorist.turing.Tape;

public class Print implements Operation {
  private String symbol;

  public Print(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public Tape executeOn(Tape tape) {
    List<String> contents = tape.getContents()
      .zipWithIndex()
      .map(item -> item._2() == tape.getPosition() ? symbol : item._1());
    return new Tape(tape.getPosition(), contents);
  }
}
