public class MiterSaw extends Tool implements iCuttingTool {
  public MiterSaw(){
    super(Const.VALUE_TOOL_MITER_SAW);
  }

  /**
   * Cuts a rectangular piece of wood into two pieces of wood
   * @param wood the piece to cut
   * @param size the measurement to cut it
   * @return an ADTList with the two remaining pieces
   */
  @Override
  public ADTList<Wood> cut(Wood wood, double size) throws IllegalArgumentException {
    if (!compatible(wood)){
      throw new IllegalArgumentException(Const.ERROR_INCOMPATIBLE_WOOD);
    }
    return wood.cut(0, size, false, cutShape.rectToRect);
  }

  /**
   * Cuts a rectangular piece of wood into two pieces using a tape measure to ensure accuracy
   *
   * @param wood the piece to cut
   * @param size the measurement to cut it
   * @param jig a measuretape is required, otherwise could cause problems
   * @return
   */
  @Override
  public ADTList<Wood> cut(Wood wood, Jig jig, double size) {
    if (!compatible(wood, jig)){
      throw new IllegalArgumentException(Const.ERROR_INCOMPATIBLE_WOOD);
    }
    return wood.cut(0, size, true, cutShape.rectToRect);
  }

  /**
   * Cuts a piece of wood to match the length of a template piece of wood.
   * @param wood the original piece of wood
   * @param template the template to match
   * @return an array with the one piece cut to match the template, and the remaining
   */
  public ADTList<Wood> cut(Wood wood, Wood template){
    if (!compatible(wood) || !compatible(template)){
      throw new IllegalArgumentException(Const.ERROR_INCOMPATIBLE_WOOD);
    }
    double[] params = template.getShape().getDimensions();
    return wood.cut(0, params[0], true, cutShape.rectToRect);
  }

  /**
   * Helper function to ensure that the provided wood is compatible with this saw
   * Criteria: Width <= 12, Rectangular shape
   * @param wood the wood in question
   * @return true if totally compatible
   */
  private boolean compatible(Wood wood){
    if (!(wood.getShape() instanceof Rectangle)){
      return false;
    }
    if (wood.getShape().getSingleDimension(1) > 12){
      return false;
    }
    return true;
  }

  private boolean compatible(Wood wood, Jig jig){
    if (jig != Jig.tapeMeasure){
      return false;
    }
    return compatible(wood);
  }
}
