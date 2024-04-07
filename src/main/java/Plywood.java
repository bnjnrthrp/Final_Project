public class Plywood extends Wood implements ICuttable<Wood> {

  /**
   * Constructor for a piece of plywood. Standard size is found in the Const class
   */
  public Plywood() {
    super(
        new Rectangle(Const.LENGTH_PLYWOOD, Const.WIDTH_PLYWOOD, Const.THICKNESS_PLYWOOD),
        WoodType.plywood);
  }

  /**
   * Constructor for a piece of plywood using provided dimensions.
   * @param dimensions the dimensions to apply
   */
  public Plywood(double[] dimensions){
    super(WoodType.plywood);

    if (dimensions.length == 3){
    this.shape = new Rectangle(dimensions[0], dimensions[1], dimensions[2]);
    } else {
    this.shape = new Round(dimensions[0], dimensions[1]);

    }
  }

  /**
   * Resizes (or reshape) the wood into one with new dimensions.
   * @param sideIndex the dimension index we are adjusting
   * @param newDimension the new size of that dimension
   * @param accurate determines if accurate cut or not
   * @return the completed piece of wood
   * @throws IllegalStateException if the new dimension exceeds the original piece of wood
   */
  public ADTList<Wood> cut(int sideIndex, double newDimension, boolean accurate){
    // Get data from original and store as temp
    double[] dimensions = this.getShape().getDimensions();
    // Create a copy and insert it into the second slot
    Plywood newPiece = new Plywood(dimensions);
    // Insert the original piece into the front
    ADTList<Wood> pieces = new ADTList<>();
//    pieces.add(this);

    try {
      this.getShape().setSingleDimension(sideIndex, newDimension);
    } catch (IllegalArgumentException e){
      // Return the original piece with no change
      return pieces;
    }

    // Temp hold the original size of the side to be cut
    double originalSize = newPiece.getShape().getSingleDimension(sideIndex);
    // Adjust the size of the newPiece to complement the original
    newPiece.getShape().setSingleDimension(sideIndex, originalSize - newDimension);

    // Add to the ADTList and return it.
    pieces.add(newPiece);
    return pieces;
  }

}
