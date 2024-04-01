/** Benjamin Northrop Final Project Sp 2024 CS5004*/

/**
 * This class represents the generic shape of a rectangle. It has a length, width, and thickness
 * (from Shape)
 */

public abstract class Shape {
  protected double thickness;

  /**
   * Sets the thickness of the rectangle
   * @param thickness the thickness of the shape
   * @throws IllegalArgumentException for thickness <= 0
   */
  protected void setThickness(double thickness) throws IllegalArgumentException{
    if (thickness <= 0){
      throw new IllegalArgumentException(Const.ERROR_NON_POSITIVE_MEASUREMENT);
    } else {
      this.thickness = thickness;
    }
  }

  /**
   * Gets the thickness of this rectangle
   * @return the thickness
   */
  public double getThickness(){
    return this.thickness;
  }

}
