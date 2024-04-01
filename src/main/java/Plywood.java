public class Plywood extends Wood {

  /**
   * Constructor for a piece of plywood. Standard size is found in the Const class
   */
  public Plywood() {
    super(
        new Rectangle(Const.LENGTH_PLYWOOD, Const.WIDTH_PLYWOOD, Const.THICKNESS_PLYWOOD),
        WoodType.plywood);
  }

}
