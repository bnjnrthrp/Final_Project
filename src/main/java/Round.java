public class Round extends Shape {
  private double diameter;

  /**
   * This class represents a round shape, like a circle. It has a diameter and thickness
   * (from Shape)
   */
  public Round(double diameter, double thickness){
    super(thickness);
    this.setDiameter(diameter);
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

  /**
   * Gets the diameter of the round
   * @return the diameter of this object
   */
  public double getDiameter(){
    return this.diameter;
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
    if (!(obj instanceof Round)) return false;
    Round test = (Round) obj;
    return this.getDiameter() == test.getDiameter() && this.getThickness() == test.getThickness();
  }


    /**
     * Gets the dimensions of this object, in the format diameter x thickness
     * @return The dimensions of this round shape
     */
  public String toString(){
    return "Diameter: %.1f, Thickness: %.1f".formatted(this.getDiameter(), this.getThickness());
  }
}
