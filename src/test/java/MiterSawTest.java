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
  Wood dim2;

  @Before
  public void setUp() {
    miterSaw = new MiterSaw();
    double[] param = {24, 4, 2};

    inventory = new ArrayList<>();
    ply1 = new Plywood();
    dim1 = new DimensionalWood();
    dim2 = new DimensionalWood(param);

    inventory.add(ply1);
    inventory.add(dim1);
    inventory.add(dim2);
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
    double[] param1 = {49, 4, 2};
    double[] param2 = {47, 4, 2};
    DimensionalWood expected1 = new DimensionalWood(param1);
    DimensionalWood expected2 = new DimensionalWood(param2);
    ArrayList<Wood> actual = new ArrayList<>(miterSaw.cut(inventory.get(1), 49.0));

    assertEquals(expected1, actual.get(0));
    assertEquals(expected2, actual.get(1));
  }

  @Test
  public void testCut2Wood(){
    double[] param1 = {24, 4, 2};
    double[] param2 = {72, 4, 2};
    DimensionalWood expected1 = new DimensionalWood(param1);
    DimensionalWood expected2 = new DimensionalWood(param2);
    ArrayList<Wood> actual = new ArrayList<>(miterSaw.cut(inventory.get(1), inventory.get(2)));
  }

  @Test (expected=IllegalArgumentException.class)
  public void testCutTooWide() {
    miterSaw.cut(inventory.get(0), 30);
  }
}
