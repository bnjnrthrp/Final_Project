import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ToolTest {

  Tool tableSaw;
  Tool miterSaw;
  Tool router;
  Jig crossCutSled;
  Jig tapeMeasure;
  Jig circleCut;

  @Before
  public void setUp() {
    tableSaw = new TableSaw();
    miterSaw = new MiterSaw();
    router = new Router();

    crossCutSled = new CrossCutSled();
    tapeMeasure = new TapeMeasure();
    circleCut = new CircleCutJig();
    }

  @Test
  public void getValue() {
    }

  @Test
  public void isUnlocked() {
    }

  @Test
  public void unlock() {
    }
}