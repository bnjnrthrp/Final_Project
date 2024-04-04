import java.util.ArrayList;

public class MiterSaw extends Tool implements iCuttingTool {
  public MiterSaw(){
    super(Const.VALUE_TOOL_MITER_SAW);
  }

  /**
   * Cuts a rectangular piece of wood into two pieces of wood
   * @param wood the piece to cut
   * @param size the measurement to cut it
   * @return an ArrayList with the two remaining pieces
   */
  @Override
  public ArrayList<Wood> cut(Wood wood, double size) throws IllegalArgumentException {
    if (!(wood.getShape() instanceof Rectangle)){
      // Throws error, since you can't cut non-retangles on a miter saw
      throw new IllegalArgumentException(Const.ERROR_INCOMPATIBLE_CUTTABLE_SHAPE);
    } else if (wood.getShape().getSingleDimension(1) > 12) {
      // Throws error if the width is >12, since it's too big to cut
      throw new IllegalArgumentException(Const.ERROR_INCOMPATIBLE_CUTTABLE_SHAPE);
    }
    return wood.cut(0, size, false, cutShape.rectToRect);
  }


  @Override
  public ArrayList<Wood> cut(Wood wood, double size, Jig jig) {
    if (!(wood.getShape() instanceof Rectangle)){
      // Throws error, since you can't cut non-retangles on a miter saw
      throw new IllegalArgumentException(Const.ERROR_INCOMPATIBLE_CUTTABLE_SHAPE);
    } else if (wood.getShape().getSingleDimension(1) > 12) {
      // Throws error if the width is >12, since it's too big to cut
      throw new IllegalArgumentException(Const.ERROR_INCOMPATIBLE_CUTTABLE_SHAPE);
    }
    return wood.cut(0, size, true, cutShape.rectToRect);
  }
}
