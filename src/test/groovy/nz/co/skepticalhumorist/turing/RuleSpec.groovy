// Copyright 2016 John Hurst
// John Hurst (john.b.hurst@gmail.com)
// 2016-05-05

package nz.co.skepticalhumorist.turing

import nz.co.skepticalhumorist.turing.operation.Operation
import spock.lang.Specification

import static javaslang.collection.List.of as list

import static Operation.E
import static Operation.L
import static Operation.R
import static Operation.P0
import static Operation.P1

class RuleSpec extends Specification {

  static javaslang.Tuple2<Tape, String> machineState(String tape, String state) {
    return new javaslang.Tuple2(Tape.fromString(tape), state)
  }

  def "A Rule matches the appropriate current tape and state"() {
    given: "A Rule"
    Rule rule = new Rule(list("BEGIN"), "", list(P0, R), "C")

    expect: "Rule matches appropriate tape and state"
    rule.matches(machineState("()", "BEGIN"))
    !rule.matches(machineState("(1)", "BEGIN"))
    !rule.matches(machineState("()", "END"))
  }

  def "A Rule executed on a tape results in the correct tape and new state"() {
    given: "A Rule"
    Rule rule = new Rule(list("BEGIN"), "", list(P1, R), "C")

    when: "Rule is applied to machien state"
    def nextMachineState = rule.executeOn(machineState("()", "BEGIN"))

    then: "Produces correct result"
    nextMachineState._1().toString() == "1,()"
    nextMachineState._2() == "C"
  }

}
