import java.util.List;

public class TableSaw extends Tool implements iCuttingTool {

  public TableSaw(){
    super(Const.VALUE_TOOL_TABLE_SAW);
  }

  @Override
  public List<Wood> cut(Wood wood, double size) {
    if (!(wood.getShape() instanceof Rectangle)){
      // Throws error, since you can't cut non-retangles on a miter saw
      throw new IllegalArgumentException(Const.ERROR_INCOMPATIBLE_CUTTABLE_SHAPE);
    }
    return wood.cut(0, size, true, cutShape.rectToRect);
  }

  @Override
  public List<Wood> cut(Wood wood, double size, Jig jig) {
    // Throw error if not a rectangle
    if (!(wood.getShape() instanceof Rectangle)){
      throw new IllegalArgumentException(Const.ERROR_INCOMPATIBLE_CUTTABLE_SHAPE);
    } else if (jig != Jig.crossCutSled){
      throw new IllegalStateException(Const.ERROR_INCOMPATIBLE_JIG);
    }
    // Throw error if incompatible jig
    return wood.cut(1, size, true, cutShape.rectToRect);
  }
}
