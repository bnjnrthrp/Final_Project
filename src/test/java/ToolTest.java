import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ToolTest {

  TableSaw tableSaw;
  MiterSaw miterSaw;
  Router router;
  ArrayList<Tool> toolInventory;


  List<Wood> inventory;
  Wood ply1;
  Wood dim1;

  @Before
  public void setUp() {
    tableSaw = new TableSaw();
    miterSaw = new MiterSaw();
    router = new Router();

    toolInventory = new ArrayList<>();
    toolInventory.add(tableSaw);
    toolInventory.add(miterSaw);
    toolInventory.add(router);

    inventory = new ArrayList<>();
    ply1 = new Plywood();
    dim1 = new DimensionalWood();

    inventory.add(ply1);
    inventory.add(dim1);
    }

  @Test
  public void getValue() {
      // Test tools
      assertEquals(Const.VALUE_TOOL_TABLE_SAW, tableSaw.getValue());

      assertEquals(Const.VALUE_TOOL_ROUTER, router.getValue());

      // Test jigs
      assertEquals(Const.VALUE_JIG_CROSSCUT_SLED, Jig.crossCutSled.getValue());

      assertEquals(Const.VALUE_JIG_CIRCLECUT, Jig.circleCut.getValue());
    }

  @Test
  public void isUnlocked() {
    assertFalse(tableSaw.isUnlocked());

    tableSaw.unlock();
    assertTrue(tableSaw.isUnlocked());
    }

  @Test
  public void testToString(){
    String expected = "Tool: TableSaw, Value: 250, Unlocked: false";

    assertEquals(expected, toolInventory.getFirst().toString());
  }

}