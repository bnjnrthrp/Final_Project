import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TableSawTest {
  TableSaw tableSaw;
  List<Wood> inventory;
  Wood ply1;
  Wood dim1;

  @Before
  public void setUp() {
    tableSaw = new TableSaw();
    inventory = new ArrayList<>();
    ply1 = new Plywood();
    dim1 = new DimensionalWood();

    inventory.add(ply1);
    inventory.add(dim1);
  }

  @Test
  public void getValue() {
    assertEquals(Const.VALUE_TOOL_TABLE_SAW, tableSaw.getValue());
    assertEquals(Const.VALUE_JIG_CROSSCUT_SLED, Jig.crossCutSled.getValue());
  }

  @Test
  public void isUnlocked() {
    assertFalse(tableSaw.isUnlocked());
    tableSaw.unlock();
    assertTrue(tableSaw.isUnlocked());
  }

  @Test
  public void testCut() {
    double[] param1 = {49, 48, .75};
    double[] param2 = {47, 48, .75};
    Plywood expected1 = new Plywood(param1);
    Plywood expected2 = new Plywood(param2);
    ArrayList<Wood> actual =
        new ArrayList<>(tableSaw.cut(inventory.getFirst(), 49.0));

    assertEquals(expected1, actual.get(0));
    assertEquals(expected2, actual.get(1));
  }

  @Test
  public void testCutWithJig() {
    double[] param1 = {96, 30, .75};
    double[] param2 = {96, 18, .75};
    Plywood expected1 = new Plywood(param1);
    Plywood expected2 = new Plywood(param2);
    ArrayList<Wood> actual =
        new ArrayList<>(tableSaw.cut(inventory.getFirst(), 30.0, Jig.crossCutSled));

    assertEquals(expected1, actual.get(0));
    assertEquals(expected2, actual.get(1));
  }
}
