import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShapeTest {
  Round s1;
  Rectangle s2;
  double DELTA = .005; // for comparing doubles

  @Before
  public void setUp() {
    s1 = new Round(15, .75);
    s2 = new Rectangle(96, 4, 2);
  }

  @Test
  public void settersAndGetters() {
    s1.setDiameter(10);
    s1.setThickness(0.5);

    s2.setLength(80);
    s2.setWidth(3);
    s2.setThickness(1.5);

    assertEquals(10.0, s1.getDiameter(), DELTA);
    assertEquals(0.5, s1.getThickness(), DELTA);
    assertEquals(80.0, s2.getLength(), DELTA);
    assertEquals(3.0, s2.getWidth(), DELTA);
    assertEquals(1.5, s2.getThickness(), DELTA);
  }

  @Test(expected=IllegalArgumentException.class)
  public void testIllegalDimensions() {
    // Negative input
    s1.setThickness(-1.5);
  }

  @Test(expected= IllegalStateException.class)
  public void testIllegalState(){
    // New size greater than original size (can't grow a board)
    s2.setLength(100);
  }

  @Test(expected=IndexOutOfBoundsException.class)
  public void testIndexOOB(){
    s1.setSingleDimension(4, 15);
  }

  @Test
  public void testEquals(){
  Round s3 = new Round(15, .75);
  assertEquals(s1, s3);

  // Check rectangle
  Rectangle s4 = new Rectangle(96, 4,2);
  assertEquals(s2, s4);

  // Dimensions not equal
  s3.setThickness(0.5);
  assertNotEquals(s1, s3);
  s4.setThickness(1.5);
  assertNotEquals(s2, s4);
  }

  @Test
  public void testToString() {
    assertEquals("Diameter: 15.0, Thickness: 0.8", s1.toString());
    assertEquals("Length: 96.0, Width: 4.0, Thickness: 2.0", s2.toString());
    }
}