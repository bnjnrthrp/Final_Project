import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Plywood extends Wood implements iCuttable<Wood> {

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
    // Create a copy and insert it into the second slot
    Plywood newPiece = new Plywood(dimensions);
    // Insert the original piece into the front
    ArrayList<Wood> pieces = new ArrayList<>();
    pieces.add(this);

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

    // Add to the ArrayList and return it.
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
  private ArrayList<Wood> cutRound(int sideIndex, double newDimension, boolean accurate) throws IllegalStateException{
    ArrayList<Wood> piece = new ArrayList<>();
    double[] dimensions = this.getShape().getDimensions();
    // If the shape was already round, just cut to new size
    if (this.getShape() instanceof Round){
      this.getShape().setSingleDimension(sideIndex, newDimension);
      piece.addFirst(this);
    } else {
      // else ensure the new Dimension (new diameter) won't exceed either the original width or length
      // of the first bit. You can't make a diameter of 4 if the original rectangle is 4x3
      // else change shape from rectangle to round
      if (newDimension > dimensions[0] || newDimension > dimensions[1]){
        throw new IllegalStateException(Const.ERROR_DIMENSION_OOB); // For now, change nothing and add to the list
      } else {
        double[] newDims = {newDimension, dimensions[2]}; // Make a new diameter, and take old thickness
        Plywood newPiece = new Plywood(newDims);
        piece.addFirst(newPiece);
      }
    }
    return piece;
  }

  /**
   * Resizes (or reshape) the wood into one with new dimensions. If cutting rectangle -> rectangle,
   * you'll get two pieces that together add up to the original size. If cutting rectangle -> round,
   * you'll only receive the round.
   * @param sideIndex the dimension index we are cutting
   * @param newDimension the new size
   * @param accurate true if the cut is accurate
   * @return an ArrayList with one or two pieces of wood in it.
   */
  @Override
  public ArrayList<Wood> cut(int sideIndex, double newDimension, boolean accurate, cutShape shape) {
    // For a rectangular piece
    if (shape == cutShape.rectToRect){
      return cutRectangle(sideIndex, newDimension, accurate);
    }
    return cutRound(sideIndex, newDimension, accurate); // Implied else
  }

}
