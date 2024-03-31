public class Round extends Shape {
  private double diameter;

  /**
   * This class represents a round shape, like a circle. It has a diameter and thickness
   * (from Shape)
   */
  public Round(double diameter, double thickness){
    this.setDiameter(diameter);
    this.setThickness(thickness);
  }

  /**
   * Sets the diameter of the round
   * @param diameter the diameter
   * @throws IllegalArgumentException for diameters <= 0
   */
  private void setDiameter(double diameter) throws IllegalArgumentException {
    if (diameter <= 0) {
      throw new IllegalArgumentException(Const.ERROR_NON_POSITIVE_MEASUREMENT);
    } else {
      this.diameter = diameter;
    }
  }

  public double getDiameter(){
    return this.diameter;
  }
}
