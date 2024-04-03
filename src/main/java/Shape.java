/** Benjamin Northrop Final Project Sp 2024 CS5004*/

/**
 * This class represents the generic shape of a rectangle. It has a length, width, and thickness
 * (from Shape)
 */

public abstract class Shape {
  protected double[] dimensions;

  /**
   * Sets the dimensions of the shape
   * @param dimensions the dimensions of the shape
   * @throws IllegalArgumentException for any dimension <= 0
   */
  private void setDimensions(double[] dimensions) throws IllegalArgumentException{
    // Check if any of the dimensions are invalid
    for (double dim : dimensions) {
      if (dim <= 0){
        throw new IllegalArgumentException(Const.ERROR_INVALID_SIZE);
      }
    }
    // Otherwise set the dimensions.
    this.dimensions = dimensions;

  }

  /**
   * Gets the thickness of this rectangle
   * @return the thickness
   */
  public double[] getDimensions(){
    return this.dimensions;
  }

}
