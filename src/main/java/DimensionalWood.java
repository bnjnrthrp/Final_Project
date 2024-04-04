import java.awt.Dimension;
import java.security.DigestException;
import java.util.ArrayList;

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
    if (dimensions.length != 3) {
      throw new IllegalArgumentException(Const.ERROR_INSUFFICIENT_ARGS);
    }
    this.shape = new Rectangle(dimensions[0], dimensions[1], dimensions[2]); // implied else
  }

  /**
   * Helper function to cut a Rectangle piece of Wood out of the original wood
   * @param sideIndex the dimension index we are adjusting
   * @param newDimension the new size of that dimension
   * @param accurate determines if accurate cut or not
   * @return the completed piece of wood
   * @throws IllegalStateException if the new dimension exceeds the original piece of wood
   */
  private ArrayList<Wood> cutRectangle(int sideIndex, double newDimension, boolean accurate){
    // Get data from original and store as temp
    double[] dimensions = this.getShape().getDimensions();
    // Create a copy of the original board
    DimensionalWood newPiece = new DimensionalWood(dimensions);
    // Insert the original piece into the front
    ArrayList<Wood> pieces = new ArrayList<>();
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

    // Add to the ArrayList and return it.
    pieces.add(newPiece);
    return pieces;
  }

  /**
   * Resizes the wood into two pieces with new dimensions. If cutting rectangle -> rectangle,
   * you'll get two pieces that together add up to the original size. Cannot cut dimensional wood
   * into round yet
   * @param sideIndex the dimension index we are cutting
   * @param newDimension the new size
   * @param accurate true if the cut is accurate
   * @return an ArrayList with one or two pieces of wood in it.
   */
  @Override
  public ArrayList<Wood> cut(int sideIndex, double newDimension, boolean accurate, cutShape cutType) {
    return cutRectangle(sideIndex, newDimension, accurate);
  }
}
