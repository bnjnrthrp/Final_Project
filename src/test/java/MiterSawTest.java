import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class MiterSawTest {
  MiterSaw miterSaw;

  List<Wood> inventory;
  Wood ply1;
  Wood dim1;

  @Before
  public void setUp() {
    miterSaw = new MiterSaw();


    inventory = new ArrayList<>();
    ply1 = new Plywood();
    dim1 = new DimensionalWood();

    inventory.add(ply1);
    inventory.add(dim1);
  }

  @Test
  public void getValue() {
    assertEquals(Const.VALUE_TOOL_MITER_SAW, miterSaw.getValue());
    assertEquals(Const.VALUE_JIG_TAPE_MEASURE, Jig.tapeMeasure.getValue());
  }

  @Test
  public void isUnlocked() {
    assertFalse(miterSaw.isUnlocked());
    miterSaw.unlock();
    assertTrue(miterSaw.isUnlocked());
  }

  @Test
  public void testCut() {
    ArrayList<Wood> actual = new ArrayList<>();
    double[] param1 = {49, 4, 2};
    double[] param2 = {47, 4, 2};
    DimensionalWood expected1 = new DimensionalWood(param1);
    DimensionalWood expected2 = new DimensionalWood(param2);
    actual.addAll(miterSaw.cut(inventory.get(1), 49.0));

    assertEquals(expected1, actual.get(0));
    assertEquals(expected2, actual.get(1));
  }

  @Test (expected=IllegalArgumentException.class)
  public void testCutTooWide() {
    miterSaw.cut(inventory.get(0), 30);
  }
}
