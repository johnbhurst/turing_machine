// Copyright 2016 John Hurst
// John Hurst (john.b.hurst@gmail.com)
// 2016-05-05

package nz.co.skepticalhumorist.turing

import javaslang.collection.List as SList
import spock.lang.Specification

class TapeSpec extends Specification {

  def "Tape toString() prints the tape and position"() {
    given: "Tape content and position"
    Tape tape = new Tape(2, "1", "", "0", "", "1")
    expect:
    tape.toString() == "1,,(0),,1"
  }

  def "Tape fromString() constructs tape from string"() {
    given: "String representation of tape"
    Tape tape = Tape.fromString("1,,(0),,1")
    expect:
    tape.position == 2
    tape.contents == SList.of("1", "", "0", "", "1")
  }

  def "Tapes with same content and position are equal"() {
    expect:
    new Tape(2, "1", "", "0", "", "1") == new Tape(2, "1", "", "0", "", "1")
  }

  def "Tapes with different position are not equal"() {
    expect:
    new Tape(2, "1", "", "0", "", "1") != new Tape(1, "1", "", "0", "", "1")
  }

  def "Tapes with different content are not equal"() {
    expect:
    new Tape(2, "1", "", "0", "", "1") != new Tape(2, "1", "", "0", "", "0")
  }

}
