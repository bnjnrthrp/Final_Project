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
  public void cut() {
    miterSaw.cut(inventory.get(1), 48.0);

  }

  @Test
  public void testCut() {}
}
