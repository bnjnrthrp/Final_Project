/**
 * This class represents a tablesaw, which can cut rectangular pieces.
 * If used without a jig, it will always cut the side that has the longer dimension.
 * If used with a crosscut jig, it will always cut the side that has the shorter dimension
 */
public class TableSaw extends Tool implements iCuttingTool {

  /**
   * Basic constructor for table saw
   */
  public TableSaw(){
    super(Const.VALUE_TOOL_TABLE_SAW);
  }

  /**
   * Ensures the wood being cut is compatible with a table saw.
   * @param wood the wood in question
   * @return true if the wood is rectangular. False for any other shape.
   */
  private boolean isCompatible(Wood wood){
    return wood.getShape() instanceof Rectangle;
  }

  /**
   * Cuts a piece of wood along the long side.
   * @param wood the wood to cut
   * @param size the new size (the long side doesn't change)
   * @return two pieces of wood in an ADTList, the cut piece first, then the remaining piece second.
   */
  @Override
  public ADTList<Wood> cut(Wood wood, double size) throws IllegalStateException, IllegalArgumentException{
    if (!this.isUnlocked()){
      throw new IllegalStateException(Const.ERROR_TOOL_LOCKED);
    }
    if (!isCompatible(wood)){
      // Throws error if incompatible, since you can't cut non-retangles on a miter saw
      throw new IllegalArgumentException(Const.ERROR_INCOMPATIBLE_CUTTABLE_SHAPE);
    }
    double[] dims = wood.getShape().getDimensions();
    int sideToCut = 1; // Assumes the length is the longest side, so it rides the fence; Width is cut
    if (dims[1] > dims[0]){ // If the width is longer, then we cut the length down.
      sideToCut = 0;
    }
    return wood.cut(sideToCut, size, true);
  }

  /**
   * Cuts a piece of wood using the crossCutSled, allowing us to cut along the short end
   * @param wood the piece to cut
   * @param size the new size (the short end doesn't change)
   * @param jig must be a cross-cut sled
   * @return two pieces of wood in an ADTList, the cut piece first, then the remaining piece.
   */
  @Override
  public ADTList<Wood> cut(Wood wood, Jig jig, double size) throws IllegalStateException, IllegalArgumentException {
    if (!this.isUnlocked() || !jig.isUnlocked()){
      throw new IllegalStateException(Const.ERROR_TOOL_LOCKED);
    }
    // Throw error if not a rectangle
    if (!isCompatible(wood)){
      throw new IllegalArgumentException(Const.ERROR_INCOMPATIBLE_CUTTABLE_SHAPE);
    } else if (jig != Jig.crossCutSled){
      throw new IllegalStateException(Const.ERROR_INCOMPATIBLE_JIG);
    }

    double[] dims = wood.getShape().getDimensions();
    int sideToCut = 0; // Assumes the length is the longest side, so it cuts it
    if (dims[1] > dims[0]){ // If the width is longer, then we cut the width down.
      sideToCut = 1;
    }
    // Throw error if incompatible jig
    return wood.cut(sideToCut, size, true);
  }
}
