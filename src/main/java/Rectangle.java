/** Benjamin Northrop Final Project Sp 2024 CS5004*/
/**
 * This class represents the generic shape of a rectangle. It has a length, width, and thickness
 * (from Shape)
 */
public class Rectangle extends Shape {
  private double length;
  private double width;

private enum Side {length, width}

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
   * Helper function to adjust the size of a rectangle
   * @param newSize the new measurement desired
   * @param side the side to adjust
   * @return 1 if the resize was successful, 0 if the original size was the same as the new size
   * @throws IllegalArgumentException if the new size exceeds the length of the shape or is less than 0
   */
  private int adjustSize(double newSize, Side side) throws IllegalArgumentException{
    double current;
    if (side == Side.length){
      current = this.getLength();
      if (newSize > current || newSize <= 0){
        throw new IllegalArgumentException(Const.ERROR_INVALID_SIZE);
      } else if (newSize == current){
        return 0;
      } else {
        setLength(newSize);
        return 1;
      }
    } else {
      current = this.getWidth();
      if (newSize > current || newSize <= 0){
        throw new IllegalArgumentException(Const.ERROR_INVALID_SIZE);
      } else if (newSize == current){
        return 0;
      } else {
        setWidth(newSize);
        return 1;
      }
    }
  }

  /**
   * Adjusts the length of a rectangle to a new desired length
   * @param newLength the new desired length
   * @return 1 if successful, 0 if the same
   * @throws IllegalArgumentException if the new size exceeds the length of the shape or is less than 0
   */
  public int adjustLength(double newLength) throws IllegalArgumentException{
    return adjustSize(newLength, Side.length);
  }

  /**
   * Adjusts the width of a rectangle to a new desired width
   * @param newWidth the new desired width
   * @return 1 if successful, 0 if there was no change
   * @throws IllegalArgumentException if the new size exceeds the length of the shape or is less than 0
   */
  public int adjustWidth(double newWidth) throws IllegalArgumentException{
    return adjustSize(newWidth, Side.width);
  }

  /**
   * Prints the dimensions of the rectangle, in the format LxWxT
   * @return the dimensions
   */
  @Override
  public String toString(){
    return "%.1fx%.1fx%.1f (LxWxT)".formatted(this.getLength(), this.getWidth(), this.getThickness());
  }

  /**
   * Tests for equality
   * @param obj the object to test
   * @return true if two objects are equal
   */
  @Override
  public boolean equals(Object obj){
    if (obj == null) return false;
    if (this == obj) return true;
    if (!(obj instanceof Rectangle)) return false;
    Rectangle test = (Rectangle) obj;
    return this.getWidth() == test.getWidth() && this.getLength() == test.getLength() && this.getThickness() == test.getThickness();

  }


}
