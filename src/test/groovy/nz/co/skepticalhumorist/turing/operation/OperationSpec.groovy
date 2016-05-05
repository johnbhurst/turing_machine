// Copyright 2016 John Hurst
// John Hurst (john.b.hurst@gmail.com)
// 2016-05-05

package nz.co.skepticalhumorist.turing.operation

import nz.co.skepticalhumorist.turing.Tape
import spock.lang.Specification

import static Operation.E
import static Operation.P1
import static Operation.L
import static Operation.R

class OperationSpec extends Specification {

  String operation(Operation op, String original) {
    return op.executeOn(Tape.fromString(original)).toString()
  }

  def "Erase erases current symbol"() {
    expect: "Operation erases the current position"
    operation(E, original) == result

    where: "Original and result tapes are"
    original || result
    "(1),1,1"|| "(),1,1"
  }

  def "Print prints a symbol"() {
    expect: "Operation sets the current position with the printed symbol"
    operation(P1, original) == result

    where: "Original and result tapes are"
    original || result
    "(),1,1"   || "(1),1,1"
  }

  def "Left moves position left"() {
    expect: "Operation moves the position left without changing the content of the tape"
    operation(L, original) == result

    where: "Original and result tapes are"
    original  || result
    "1,(1),1" || "(1),1,1"
  }

  def "Right moves position right, lengthening tape if necessary"() {
    expect: "Operation moves the position right without changing the content of the tape"
    operation(R, original) == result

    where: "Original and result tapes are"
    original  || result
    "1,(1),1" || "1,1,(1)"
    "()"      || ",()"
  }

}
