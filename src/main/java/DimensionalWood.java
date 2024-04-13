/**
 * Benjamin Northrop
 * CS5004
 * Final Project
 * SP2024
 *
 * This class represents a piece of dimensional wood, which is what we imagine as a 2x4.
 */
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
   * Resizes the wood into two pieces with new dimensions.
   * @param sideIndex the dimension index we are adjusting
   * @param newDimension the new size of that dimension
   * @return the completed piece of wood
   * @throws IllegalStateException if the new dimension exceeds the original piece of wood
   */
  public ADTList<Wood> cut(int sideIndex, double newDimension){
    // Get data from original and store as temp
    double[] dimensions = this.getShape().getDimensions();
    // Create a copy of the original board
    DimensionalWood newPiece = new DimensionalWood(dimensions);
    // Create the return list
    ADTList<Wood> pieces = new ADTList<>();

    // Try to cut the first board to size.
    try {
      this.getShape().setSingleDimension(sideIndex, newDimension);
    } catch (IllegalArgumentException e){
      // Return an empty list if the original cannot be cut.
      return pieces;
    }

    // Temp hold the original size of the side to be cut
    double originalSize = newPiece.getShape().getSingleDimension(sideIndex);
    // Adjust the size of the newPiece to complement the original
    newPiece.getShape().setSingleDimension(sideIndex, originalSize - newDimension);
    // Add the cutoff piece to the ADTList and return it.
    pieces.add(newPiece);
    return pieces;
  }

}
