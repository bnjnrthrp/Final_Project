import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ToolTest {

  Tool tableSaw;

  Tool router;
  Jig crossCutSled;
  Jig circleCut;


  List<Wood> inventory;
  Wood ply1;
  Wood dim1;

  @Before
  public void setUp() {
    tableSaw = new TableSaw();
    router = new Router();

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



}