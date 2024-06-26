import static org.junit.Assert.*;

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

    ADTList<Wood> actual = new ADTList<>();
    actual.add(plywood1);
    actual.addAll(plywood1.cut(0, 50));
    assertEquals(expected1, actual.get(0));
    assertEquals(expected2, actual.get(1));
  }

  @Test (expected= IllegalStateException.class)
  public void cutPlywoodIllegalSize(){
    plywood1.cut(0, 100);

  }

  @Test
  public void testToString() {
    assertEquals("Type: plywood, Length: 96.0, Width: 48.0, Thickness: 0.8\n", plywood1.toString());
  }
}
