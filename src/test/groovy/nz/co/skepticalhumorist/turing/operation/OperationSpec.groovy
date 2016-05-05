// Copyright 2016 John Hurst
// John Hurst (john.b.hurst@gmail.com)
// 2016-05-05

package nz.co.skepticalhumorist.turing.operation

import nz.co.skepticalhumorist.turing.Tape
import spock.lang.Specification

class OperationSpec extends Specification {

  void operation(Operation op, String original, String result) {
    assert op.executeOn(Tape.fromString(original)) == Tape.fromString(result)
  }

  def "Erase erases current symbol"() {
    given: "An Erase operation"
    def op = new Erase()

    expect: "Operation erases the current position"
    operation(op, original, result)

    where: "Original and result tapes are"
    original || result
    "(1),1,1"|| "(),1,1"
  }

  def "Print prints a symbol"() {
    given: "A Print operation"
    def op = new Print("1")

    expect: "Operation sets the current position with the printed symbol"
    operation(op, original, result)

    where: "Original and result tapes are"
    original || result
    "(),1,1"   || "(1),1,1"
  }

  def "Left moves position left"() {
    given: "A Left operation"
    def op = new Left()

    expect: "Operation moves the position left without changing the content of the tape"
    operation(op, original, result)

    where: "Original and result tapes are"
    original  || result
    "1,(1),1" || "(1),1,1"
  }

  def "Right moves position right"() {
    given: "A Right operation"
    def op = new Right()

    expect: "Operation moves the position right without changing the content of the tape"
    operation(op, original, result)

    where: "Original and result tapes are"
    original  || result
    "1,(1),1" || "1,1,(1)"
  }

}
