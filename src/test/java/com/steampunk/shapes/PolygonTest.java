package com.steampunk.shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

/** Tests for Polygon. */
public class PolygonTest {

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

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              new Polygon(lengths, angles);
            });

    assertTrue(
        exception
            .getMessage()
            .contains("This polygon must have 6 vertices. You supplied 7 angles."));
  }

  /** Test an invalid octogon with too few angles. */
  @Test
  public void invalidOctogon() {
    final List<Double> lengths = Arrays.asList(8.0d, 8.0d, 8.0d, 8.0d, 8.0d, 8.0d, 8.0d, 8.0d);
    final List<Double> angles =
        Arrays.asList(135.0d, 135.0d, 135.0d, 135.0d, 135.0d, 135.0d, 135.0d);

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              new Polygon("octogon", lengths, angles);
            });

    assertTrue(
        exception
            .getMessage()
            .contains("This octogon must have 8 vertices. You supplied 7 angles."));
  }
}
