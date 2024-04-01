/** Benjamin Northrop Final Project Sp 2024 CS5004*/

/**
 * This class represents the generic shape of a rectangle. It has a length, width, and thickness
 * (from Shape)
 */
public class Rectangle extends Shape {
  private double length;
  private double width;

  /**
   * Constructor for a rectangle. Takes a length, width, and thickness
   * @param length the length of the shape
   * @param width the width of the shape
   * @param thickness the thickness of the shape
   */
  public Rectangle (double length, double width, double thickness){
    super(thickness);
    this.setLength(length);
    this.setWidth(width);
  }

  /**
   * Sets the length of the rectangle
   * @param length the length of the shape
   * @throws IllegalArgumentException for length <= 0
   */
  private void setLength(double length) throws IllegalArgumentException{
    if (length <= 0) {
      throw new IllegalArgumentException(Const.ERROR_NON_POSITIVE_MEASUREMENT);
    } else {
      this.length = length;
    }
  }

  /**
   * Sets the width of the rectangle
   * @param width the width of the shape
   * @throws IllegalArgumentException for width <= 0
   */
  private void setWidth(double width) throws IllegalArgumentException{
    if (width <= 0) {
      throw new IllegalArgumentException(Const.ERROR_NON_POSITIVE_MEASUREMENT);
    } else {
      this.width = width;
    }
  }

  /**
   * Gets the length of this object
   * @return the length
   */
  public double getLength(){
    return this.length;
  }

  /**
   * Gets the width of this rectangle
   * @return the width
   */
  public double getWidth(){
    return this.width;
  }

  /**
   * Prints the dimensions of the rectangle, in the format LxWxT
   * @return the dimensions
   */
  @Override
  public String toString(){
    return "%.1fx%.1fx%.1f (LxWxT)".formatted(this.getLength(), this.getWidth(), this.getThickness());
  }

}
