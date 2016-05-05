// Copyright 2016 John Hurst
// John Hurst (john.b.hurst@gmail.com)
// 2016-05-05

package nz.co.skepticalhumorist.turing;

import javaslang.Tuple2;
import javaslang.collection.List;

public class Tape {

  private int position;
  private List<String> contents;

  public Tape(int position, String... contents) {
    this.position = position;
    this.contents = List.of(contents);
  }

  public Tape(int position, List<String> contents) {
    this.position = position;
    this.contents = contents;
  }

  private static boolean positionItem(String item) {
    return item.startsWith("(") && item.endsWith(")");
  }

  public static Tape fromString(String s) {
    List<String> markedContent = List.of(s.split(","));
    int position = markedContent
      .zipWithIndex()
      .find(item -> positionItem(item._1()))
      .map(Tuple2::_2)
      .getOrElseThrow(RuntimeException::new)
      .intValue();
    List<String> content = markedContent
      .map(item -> positionItem(item) ? item.substring(1, item.length()-1) : item);
    return new Tape(position, content);
  }

  public int getPosition() {
    return position;
  }

  public List<String> getContents() {
    return contents;
  }

  @Override
  public int hashCode() {
    return position + 5 * contents.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj instanceof Tape) {
      Tape other = (Tape) obj;
      return this.position == other.position &&
        this.contents.equals(other.contents);
    }
    return false;
  }

  @Override
  public String toString() {
    return contents.zipWithIndex()
      .map(pair -> pair._2() == position ? "(" + pair._1() + ")" : pair._1())
      .mkString(",");
  }
}
