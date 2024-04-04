/** Benjamin Northrop Final Project Sp 2024 CS5004*/
/**
 * This class represents the generic shape of a rectangle. It has a length, width, and thickness
 * (from Shape)
 */
public class Rectangle extends Shape {

  /**
   * Constructor for a rectangle. Takes a length, width, and thickness
   * @param length the length of the shape
   * @param width the width of the shape
   * @param thickness the thickness of the shape
   */
  public Rectangle (double length, double width, double thickness){
    double[] dimensions = {length, width, thickness};
    setDimensions(dimensions);
  }

  /**
   * Sets the length of the rectangle
   * @param length the length of the shape
   * @throws IllegalArgumentException for length <= 0
   */
  public void setLength(double length) throws IllegalArgumentException, IndexOutOfBoundsException, IllegalStateException{
    setSingleDimension(0, length);
  }

  /**
   * Sets the width of the rectangle
   * @param width the width of the shape
   * @throws IllegalArgumentException for width <= 0
   */
  public void setWidth(double width) throws IllegalArgumentException, IndexOutOfBoundsException, IllegalStateException{
    setSingleDimension(1, width);
  }

  /**
   * Sets the thickness of the rectangle
   * @param thickness the width of the shape
   * @throws IllegalArgumentException for thickness <= 0
   */
  public void setThickness(double thickness) throws IllegalArgumentException, IndexOutOfBoundsException, IllegalStateException {
    setSingleDimension(2, thickness);
  }

  /**
   * Gets the length of this object
   * @return the length
   */
  public double getLength(){
    return this.getSingleDimension(0);
  }

  /**
   * Gets the width of this rectangle
   * @return the width
   */
  public double getWidth(){
    return this.getSingleDimension(1);
  }

  /**
   * Gets the thickness of this rectangle
   * @return the thickness
   */
  public double getThickness(){
    return this.getSingleDimension(2);
  }


  /**
   * Prints the dimensions of the rectangle, in the format LxWxT
   * @return the dimensions
   */
  @Override
  public String toString(){
    return "Length: %.1f, Width: %.1f, Thickness: %.1f".formatted(this.getLength(), this.getWidth(), this.getThickness());
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
