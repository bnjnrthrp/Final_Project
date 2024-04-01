public class DimensionalWood extends Wood {
  /**
   * Constructor for a piece of plywood. Standard size is found in the Const class
   */
  public DimensionalWood() {
    super(
        new Rectangle(Const.LENGTH_DIMENSIONAL, Const.WIDTH_DIMENSIONAL, Const.THICKNESS_DIMENSIONAL),
        WoodType.dimensional);
  }
}
