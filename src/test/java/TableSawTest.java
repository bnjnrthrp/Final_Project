import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

public class TableSawTest {
  TableSaw tableSaw;
  ADTList<Wood> inventory;
  Plywood ply1;
  DimensionalWood dim1;

  @Before
  public void setUp() {
    tableSaw = new TableSaw();
    inventory = new ADTList<>();
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
    double[] param1 = {96, 30, .75};
    double[] param2 = {96, 18, .75};
    Plywood expected1 = new Plywood(param1);
    Plywood expected2 = new Plywood(param2);
    tableSaw.unlock();
    inventory.addAll(tableSaw.cut(inventory.get(0), 30.0));

    assertEquals(expected1, inventory.get(0));
    assertEquals(expected2, inventory.get(2));
  }

  @Test
  public void testCutWithJig() {
    double[] param1 = {49, 48, .75};
    double[] param2 = {47, 48, .75};
    tableSaw.unlock();
    Jig.crossCutSled.unlock();
    Plywood expected1 = new Plywood(param1);
    Plywood expected2 = new Plywood(param2);
    inventory.addAll(tableSaw.cut(inventory.get(0), Jig.crossCutSled, 49.0));

    assertEquals(expected1, inventory.get(0));
    assertEquals(expected2, inventory.get(2));
  }

  @Test
  public void testCutOppositeShort(){
    double[] dims = {24, 48, .75};
    double[] dims2 = {16, 48, .75};
    double[] dims3 = {8, 48, .75};

    Plywood ply3 = new Plywood(dims);
    inventory.add(ply3);
    Plywood expected = new Plywood(dims2);
    Plywood expected2 = new Plywood(dims3);
    tableSaw.unlock();
    inventory.addAll(tableSaw.cut(ply3, 16));

    assertEquals(expected, inventory.get(2));
    assertEquals(expected2, inventory.get(3));
  }


}
