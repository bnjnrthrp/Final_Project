import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class iWorkshopTest {
  WorkshopModel ws;

  TableSaw tableSaw;
  MiterSaw miterSaw;
  Router router;

  ArrayList<Wood> woodInventory;
  ArrayList<Tool> tools;
  ArrayList<Jig> jigs;

  @Before
  public void setUp(){
    ws = new WorkshopModel();
    ws.loadWorkshop();
    ws.buyWood(WoodType.plywood);
    ws.buyWood(WoodType.dimensional);

    }

  @Test
  public void goToWork() {
    ws.goToWork();
    assertEquals(100, ws.getBalance());
    }

  @Test
  public void loadWorkshop() {
    assertEquals(0, ws.getBalance());
    TableSaw ts = new TableSaw();
    MiterSaw ms = new MiterSaw();
    Router rt = new Router();

    ArrayList<Tool> toolShed = new ArrayList<>();
    toolShed.add(ts);
    toolShed.add(ms);
    toolShed.add(rt);

    // Uses to string as the two arrays will be different, but contents equal
    assertEquals(toolShed.toString(), ws.getTools().toString());
    }

  @Test
  public void getItem(){
    ws.buyWood(WoodType.plywood);
    Object actual = ws.getWood( 0);
    Plywood expected = new Plywood();

    assertEquals(expected, actual);
  }

  @Test
  public void buyWood() {
    ArrayList<Wood> expected = new ArrayList<>();
    expected.add(new Plywood());
    expected.add(new DimensionalWood());

    assertEquals(expected.toString(), ws.getWoodInventory().toString());

    }

  @Test
  public void unlockTool() {
    assertFalse(ws.getTools().get(0).isUnlocked());
    ws.getTools().get(0).unlock();
    assertTrue(ws.getTools().get(0).isUnlocked());
    }

  @Test
  public void cutWood() {
    ws.unlockTool(ws.getTools().get(0));
    ws.unlockTool(ws.getJigs().get(0));

    double[] expected1 = {96, 30, .75};
    double[] expected2 = {48, 30, .75};

    ws.cutWood(0,0, 30);

    //TODO: Running into error where it tries to cut the wrong side in the crosscut.
    ws.cutWood(0, 0, 0, 48);

    ArrayList<Wood> expected = new ArrayList<>();
    expected.add(new Plywood(expected2));
    expected.add(new Plywood(expected2));

    assertEquals(expected.toString(), ws.getWoodInventory().toString());
  }

  @Test
  public void testCutWood() {
    }

  @Test (expected=IllegalStateException.class)
  public void testCutWoodLockedTool(){
    ws.cutWood(0, 0, 48);
  }

  @Test (expected= IllegalStateException.class)
  public void testCutWoodLockedJig(){
    ws.cutWood(0, 0, 0, 48);
  }

  @Test
  public void makeFurniture() {
    }

  @Test
  public void getWoodInventory() {
    }

  @Test
  public void getTools() {
    }

  @Test
  public void getJigs() {
    }
}