import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Plywood extends Wood implements iCuttable<Wood>, Cloneable{

  /**
   * Constructor for a piece of plywood. Standard size is found in the Const class
   */
  public Plywood() {
    super(
        new Rectangle(Const.LENGTH_PLYWOOD, Const.WIDTH_PLYWOOD, Const.THICKNESS_PLYWOOD),
        WoodType.plywood);
  }

  public Plywood(double[] dimensions){
    super(new Rectangle(dimensions[0], dimensions[1], dimensions[2]), WoodType.plywood);
  }

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

  // TODO: Move to saw and fix
  @Override
  public ArrayList<Wood> cut(int sideIndex, double newDimension, boolean accurate) {
    // For a rectangular piece
    if (this.getShape().getClass() == Rectangle.class) {
      return cutRectangle(sideIndex, newDimension, accurate);
    }
    //TODO: Implement cut circle
    return null;
    //
  }

}
