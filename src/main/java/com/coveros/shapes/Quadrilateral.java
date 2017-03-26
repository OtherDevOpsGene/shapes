package com.coveros.shapes;

import java.util.List;

/**
 * A quadrilateral, i.e., a polygon with 4 sides.
 */
public class Quadrilateral extends Polygon {

    public Quadrilateral(final String shape, final List<Double> lengths, final List<Double> angles) {
        super(shape, lengths, angles);
    }

    public Quadrilateral(final List<Double> lengths, final List<Double> angles) {
        this("quadrilateral", lengths, angles);
    }

}
