public class DimensionalWood extends Wood {

  /**
   * Constructor for a piece of dimensional wood. Standard size is found in the Const class
   */
  public DimensionalWood() {
    super(
        new Rectangle(Const.LENGTH_DIMENSIONAL, Const.WIDTH_DIMENSIONAL, Const.THICKNESS_DIMENSIONAL),
        WoodType.dimensional);
  }

  /**
   * Constructor for a piece of dimensional wood with provided arguments.
   * @param dimensions the dimensions of the wood
   * @throws IllegalArgumentException if there are an incorrect number of dimensions
   */
  public DimensionalWood(double[] dimensions) throws IllegalArgumentException {
    super(WoodType.dimensional);
    if (dimensions.length == 3){
      this.shape = new Rectangle(dimensions[0], dimensions[1], dimensions[2]);
    } else {
      this.shape = new Round(dimensions[0], dimensions[1]);
    }
  }

  /**
   * Helper function to cut a Rectangle piece of Wood out of the original wood
   * @param sideIndex the dimension index we are adjusting
   * @param newDimension the new size of that dimension
   * @param accurate determines if accurate cut or not
   * @return the completed piece of wood
   * @throws IllegalStateException if the new dimension exceeds the original piece of wood
   */
  private ADTList<Wood> cutRectangle(int sideIndex, double newDimension, boolean accurate){
    // Get data from original and store as temp
    double[] dimensions = this.getShape().getDimensions();
    // Create a copy of the original board
    DimensionalWood newPiece = new DimensionalWood(dimensions);
    // Insert the original piece into the front
    ADTList<Wood> pieces = new ADTList<>();
    pieces.add(this);

    // Try to cut the first board to size.
    try {
      this.getShape().setSingleDimension(sideIndex, newDimension);
    } catch (IllegalArgumentException e){
      // Return the original piece with no change if the cut fails
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

  /**
   * Helper function to cut a round Wood out of the original wood
   * @param sideIndex the dimension index we are adjusting
   * @param newDimension the new size of that dimension
   * @param accurate determines if accurate cut or not
   * @return the completed piece of wood
   * @throws IllegalStateException if the diameter of the round exceeds either length or width of
   * the original piece of wood
   */
  private ADTList<Wood> cutRound(int sideIndex, double newDimension, boolean accurate) throws IllegalStateException{
    ADTList<Wood> piece = new ADTList<>();
    double[] dimensions = this.getShape().getDimensions();
    // If the shape was already round, just cut to new size
    if (this.getShape() instanceof Round){
      this.getShape().setSingleDimension(sideIndex, newDimension);
      piece.add(this, 0);
    } else {
      // else ensure the new Dimension (new diameter) won't exceed either the original width or length
      // of the first bit. You can't make a diameter of 4 if the original rectangle is 4x3
      // else change shape from rectangle to round
      if (newDimension > dimensions[0] || newDimension > dimensions[1]){
        throw new IllegalStateException(Const.ERROR_DIMENSION_OOB); // For now, change nothing and add to the list
      } else {
        double[] newDims = {newDimension, dimensions[2]}; // Make a new diameter, and take old thickness
        this.setShape(new Round(newDimension, dimensions[2]));
        piece.add(this, 0);
      }
    }
    return piece;
  }

  /**
   * Resizes the wood into two pieces with new dimensions. If cutting rectangle -> rectangle,
   * you'll get two pieces that together add up to the original size. Cannot cut dimensional wood
   * into round yet
   * @param sideIndex the dimension index we are cutting
   * @param newDimension the new size
   * @param accurate true if the cut is accurate
   * @return an ADTList with one or two pieces of wood in it.
   */
  @Override
  public ADTList<Wood> cut(int sideIndex, double newDimension, boolean accurate, cutShape shape) {
    // For a rectangular piece
    if (shape == cutShape.rectToRect){
      return cutRectangle(sideIndex, newDimension, accurate);
    }
    return cutRound(sideIndex, newDimension, accurate); // Implied else
  }
}
