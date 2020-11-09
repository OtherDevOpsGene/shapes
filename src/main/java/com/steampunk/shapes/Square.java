package com.coveros.shapes;

import java.util.Arrays;
import java.util.List;

/** A square, i.e., a rectangle with all sides equal lengths. */
public class Square extends Rectangle {

  public Square(final String shape, final List<Double> length) {
    super(shape, Arrays.asList(length.get(0), length.get(0), length.get(0), length.get(0)));
  }

  public Square(final List<Double> length) {
    this("square", length);
  }
}
