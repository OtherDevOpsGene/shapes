package com.steampunk.shapes;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A polygon with n sides.
 */
public class Polygon {

    private final String shape;
    private final List<Double> lengths;
    private final List<Double> angles;

    public Polygon(final String shape, final List<Double> lengths, final List<Double> angles) {
        this.shape = shape;
        this.lengths = new ArrayList<>(lengths);

        if (this.lengths.size() != angles.size()) {
            throw new IllegalArgumentException("This " + shape + " must have " + this.lengths.size()
                    + " vertices. You supplied " + angles.size() + " angles.");
        }

        this.angles = new ArrayList<>(angles);
    }

    public Polygon(final List<Double> lengths, final List<Double> angles) {
        this("polygon", lengths, angles);
    }

    public String getShape() {
        return shape;
    }

    public List<Double> getLengths() {
        return Collections.unmodifiableList(lengths);
    }

    public List<Double> getAngles() {
        return Collections.unmodifiableList(angles);
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument;
     *         {@code false} otherwise.
     * @see #hashCode()
     */
    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Polygon)) {
            return false;
        }
        final Polygon other = (Polygon) obj;
        return new EqualsBuilder().append(shape, other.shape).append(lengths, other.lengths)
                .append(angles, other.angles).isEquals();
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     * @see #equals(java.lang.Object)
     */
    @Override
    public final int hashCode() {
        return new HashCodeBuilder(-1009, -1013).append(shape).append(lengths).append(angles).toHashCode();
    }

}
