package com.steampunk.shapes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.Arrays;
import java.util.List;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/** Tests for Polygon. */
public class PolygonTest {

  @Rule public ExpectedException thrown = ExpectedException.none();

  /** Verify whether the contract for the equals and hashCode methods is met. */
  @Test
  public void equalsContract() {
    EqualsVerifier.forClass(Polygon.class).verify();
  }

  /** Test a right triangle. */
  @Test
  public void validTriangle() {
    final List<Double> lengths = Arrays.asList(3.0d, 4.0d, 5.0d);
    final List<Double> angles = Arrays.asList(90.0d, 36.87d, 53.13d);

    final Polygon triangle = new Polygon("triangle", lengths, angles);

    assertEquals("triangle", triangle.getShape());

    assertEquals(lengths, triangle.getLengths());
    assertNotSame(lengths, triangle.getLengths());

    assertEquals(angles, triangle.getAngles());
    assertNotSame(angles, triangle.getAngles());
  }

  /** Test an invalid hexagon with too many angles. */
  @Test
  public void invalidHexagon() {
    final List<Double> lengths = Arrays.asList(6.0d, 6.0d, 6.0d, 6.0d, 6.0d, 6.0d);
    final List<Double> angles =
        Arrays.asList(120.0d, 120.0d, 120.0d, 120.0d, 120.0d, 120.0d, 120.0d);

    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("This polygon must have 6 vertices. You supplied 7 angles.");

    new Polygon(lengths, angles);
  }

  /** Test an invalid octogon with too few angles. */
  @Test
  public void invalidOctogon() {
    final List<Double> lengths = Arrays.asList(8.0d, 8.0d, 8.0d, 8.0d, 8.0d, 8.0d, 8.0d, 8.0d);
    final List<Double> angles =
        Arrays.asList(135.0d, 135.0d, 135.0d, 135.0d, 135.0d, 135.0d, 135.0d);

    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("This octogon must have 8 vertices. You supplied 7 angles.");

    new Polygon("octogon", lengths, angles);
  }
}
