// Copyright 2016 John Hurst
// John Hurst (john.b.hurst@gmail.com)
// 2016-05-05

package nz.co.skepticalhumorist.turing;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
  public static void main(String[] args) throws IOException {
    Path path = Paths.get(args[0]);
    Machine machine = new MachineReader().read(path);
    MachineState machineState = MachineState.BEGIN_MACHINE;
    for (;;) {
      System.out.println(machineState.getState() + ":" + machineState.getTape());
      machineState = machine.applyTo(machineState);
    }
  }
}
