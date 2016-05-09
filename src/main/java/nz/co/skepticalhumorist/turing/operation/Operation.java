// Copyright 2016 John Hurst
// John Hurst (john.b.hurst@gmail.com)
// 2016-05-05

package nz.co.skepticalhumorist.turing.operation;

import nz.co.skepticalhumorist.turing.Tape;

public interface Operation {
  public static final Operation R = new Right();
  public static final Operation L = new Left();
  public static final Operation E = new Erase();
  public static final Operation P0 = new Print("0");
  public static final Operation P1 = new Print("1");
  public static final Operation N = new NoOp();

  Tape executeOn(Tape tape);
}
