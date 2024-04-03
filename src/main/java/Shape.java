/** Benjamin Northrop Final Project Sp 2024 CS5004 */

/**
 * This class represents the generic shape of a rectangle. It has a length, width, and thickness
 * (from Shape)
 */
public abstract class Shape {
  protected double[] dimensions;

  /**
   * Sets the dimensions of the shape
   *
   * @param dimensions the dimensions of the shape
   * @throws IllegalArgumentException for any dimension <= 0
   */
  protected void setDimensions(double[] dimensions) throws IllegalArgumentException {
    // Check if any of the dimensions are invalid
    for (double dim : dimensions) {
      if (dim <= 0) {
        throw new IllegalArgumentException(Const.ERROR_INVALID_SIZE);
      }
    }
    // Otherwise set the dimensions.
    this.dimensions = dimensions;
  }

  /**
   * Sets a single dimension of the shape, leaving the others unchanged.
   *
   * @param index the index of the dimension to change
   * @param newDimension the new value
   * @throws IllegalArgumentException
   */
  protected void setSingleDimension(int index, double newDimension)
      throws IllegalArgumentException, IndexOutOfBoundsException, IllegalStateException {
    // Checks for negative measurements
    if (newDimension <= 0) {
      throw new IllegalArgumentException(Const.ERROR_NON_POSITIVE_MEASUREMENT);
    }
    // Checks for index out of bounds
    else if (index < 0 || index > dimensions.length - 1) {
      throw new IndexOutOfBoundsException(Const.ERROR_INVALID_INDEX);
    }
    // Checks for new dimension exceeding original
    else if (newDimension >= getSingleDimension(index)) {
      throw new IllegalStateException(Const.ERROR_DIMENSION_OOB);
    } else {
      this.dimensions[index] = newDimension;
    }
  }

  /**
   * Gets all the dimensions of this shape as an array of doubles.
   *
   * @return dimensions of the shape
   */
  public double[] getDimensions() {
    return this.dimensions;
  }

  /**
   * Gets the dimension at a specified index
   *
   * @param index the index of dimension to return
   * @return the value of the dimension
   */
  public double getSingleDimension(int index) {
    return dimensions[index];
  }
}
