import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class WoodTest {
  Plywood plywood1;
  DimensionalWood dim1;

  double DELTA = .005;

  @Before
  public void setUp() throws Exception {
    plywood1 = new Plywood();
    dim1 = new DimensionalWood();
  }

  @Test
  public void cutPlywoodRectangle(){
    double[] param1 = {50, 48, .75};
    double[] param2 = {46, 48, .75};
    Plywood expected1 = new Plywood(param1);
    Plywood expected2 = new Plywood(param2);

    ArrayList<Wood> actual = plywood1.cut(0, 50, true, cutShape.rectToRect);
    assertEquals(expected1, actual.get(0));
    assertEquals(expected2, actual.get(1));
  }

  @Test (expected= IllegalStateException.class)
  public void cutPlywoodIllegalSize(){
    plywood1.cut(0, 100, true, cutShape.rectToRect);

  }

  @Test
  public void cutPlywoodRound(){
    double[] param1 = {38, .75};
    Plywood expected1 = new Plywood(param1);

    ArrayList<Wood> actual = plywood1.cut(0, 38, true, cutShape.rectToRound);
    assertEquals(expected1, actual.get(0));
  }

  @Test
  public void testToString() {
    assertEquals("Type: plywood, Dimensions: 96.0x48.0x0.8 (LxWxT)", plywood1.toString());
  }
}
