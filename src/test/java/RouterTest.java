import static org.junit.Assert.*;

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

    router.cut(ply1, 40);
    assertTrue(ply1.isSmooth());
  }

  @Test
  public void testCutWithJig() {
    // Initialize the expected
    double[] dims = {36, .75};
    double[] dims2 = {3.5, 2};

    // Test plywood
    Plywood expected = new Plywood(dims);
    expected.makeSmooth();
    ArrayList<Wood> actual = new ArrayList<>(router.cut(ply1, 36, Jig.circleCut));
    assertEquals(expected, actual.getFirst());

    // Test dimensional wood
    DimensionalWood expected2 = new DimensionalWood(dims2);
    expected2.makeSmooth();
    ArrayList<Wood> actual2 = new ArrayList<>(router.cut(dim1, 3.5, Jig.circleCut));
    assertEquals(expected2, actual2.getFirst());


  }

  @Test(expected = IllegalStateException.class)
  public void testCutWithJigIllegalSize(){
    router.cut(ply1, 72, Jig.circleCut);
  }

}