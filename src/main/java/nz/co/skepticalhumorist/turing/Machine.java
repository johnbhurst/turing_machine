// Copyright 2016 John Hurst
// John Hurst (john.b.hurst@gmail.com)
// 2016-05-05

package nz.co.skepticalhumorist.turing;

import javaslang.collection.List;

public class Machine {

  private List<Rule> rules;

  public Machine(List<Rule> rules) {
    this.rules = rules;
  }

  public MachineState applyTo(MachineState machineState) {
    Rule rule = rules.find(it -> it.matches(machineState)).getOrElseThrow(RuntimeException::new);
    return rule.executeOn(machineState);
  }

}
