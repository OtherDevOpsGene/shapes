package com.coveros.shapes;

import java.util.Arrays;
import java.util.List;

/** A rectangle, i.e., a 4-sided polygon with right angles and opposite sides equal length. */
public class Rectangle extends Quadrilateral {

  private static final List<Double> RIGHT_ANGLES = Arrays.asList(90.0d, 90.0d, 90.0d, 90.0d);

  public Rectangle(final String shape, final List<Double> lengths) {
    super(shape, lengths, RIGHT_ANGLES);
  }

  public Rectangle(final List<Double> lengths) {
    this("rectangle", lengths);
  }
}
