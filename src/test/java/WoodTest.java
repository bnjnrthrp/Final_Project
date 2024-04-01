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
  public void settersAndGetters() {
    plywood1.setThickness(.5);
    assertEquals(.5, plywood1.getThickness(), DELTA);

    assertEquals(WoodType.plywood, plywood1.getType());
    assertEquals(WoodType.dimensional, dim1.getType());
  }

  @Test
  public void getShape() {return;}

  @Test
  public void testToString() {
    assertEquals("Type: plywood, Dimensions: 96.0x48.0x0.8 (LxWxT)", plywood1.toString());
  }
}
