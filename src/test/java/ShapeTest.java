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
    assertEquals(.75, s1.getThickness(), DELTA);
    assertEquals(2, s2.getThickness(), DELTA);
    }

  @Test
  public void getLength() {
    }

  @Test
  public void getWidth() {
    }

  @Test
  public void testToString() {
    }
}