import static org.junit.Assert.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class RouterTest {

  Router router;
  List<Wood> inventory;
  Plywood ply1;
  DimensionalWood dim1;
  @Before
  public void setUp() throws Exception {
    router = new Router();
    inventory = new ArrayList<>();
    ply1 = new Plywood();
    dim1 = new DimensionalWood();

    inventory.add(ply1);
    inventory.add(dim1);
  }

  @Test
  public void getValue(){
    assertEquals(Const.VALUE_TOOL_ROUTER, router.getValue());
    assertEquals(Const.VALUE_JIG_CIRCLECUT, Jig.circleCut.getValue());
  }

  @Test
  public void isUnlocked(){
    assertFalse(router.isUnlocked());
    router.unlock();
    assertTrue(router.isUnlocked());
  }

  @Test
  public void testSmooth() {
    // wood starts rough
    assertFalse(ply1.isSmooth());

    router.smooth(ply1);
    assertTrue(ply1.isSmooth());
  }

  @Test
  public void testCutWithJig() {
    // Initialize the expected
    double[] dims = {36, .75};
    Plywood expected = new Plywood(dims);
    ArrayList<Wood> actual = new ArrayList<>(router.cut(ply1, 36, Jig.circleCut));

    assertEquals(expected, actual.getFirst());
  }

  @Test(expected = IllegalStateException.class)
  public void testCutWithJigIllegalSize(){
    router.cut(ply1, 72, Jig.circleCut);
  }

}