import java.util.ArrayList;

public class TableSaw extends Tool implements iCuttingTool {

  public TableSaw(){
    super(Const.VALUE_TOOL_TABLE_SAW);
  }

  private boolean isCompatible(Wood wood){
    return wood.getShape() instanceof Rectangle;
  }

  @Override
  public ArrayList<Wood> cut(Wood wood, double size) {
    if (!isCompatible(wood)){
      // Throws error if incompatible, since you can't cut non-retangles on a miter saw
      throw new IllegalArgumentException(Const.ERROR_INCOMPATIBLE_CUTTABLE_SHAPE);
    }
    return wood.cut(0, size, true, cutShape.rectToRect);
  }

  @Override
  public ArrayList<Wood> cut(Wood wood, double size, Jig jig) {
    // Throw error if not a rectangle
    if (!isCompatible(wood)){
      throw new IllegalArgumentException(Const.ERROR_INCOMPATIBLE_CUTTABLE_SHAPE);
    } else if (jig != Jig.crossCutSled){
      throw new IllegalStateException(Const.ERROR_INCOMPATIBLE_JIG);
    }
    // Throw error if incompatible jig
    return wood.cut(1, size, true, cutShape.rectToRect);
  }
}
