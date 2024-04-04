public class Round extends Shape {


  /**
   * This class represents a round shape, like a circle. It has a diameter and thickness
   * (from Shape)
   */
  public Round(double diameter, double thickness){
    double[] dimensions = {diameter, thickness};
    this.setDimensions(dimensions);
  }

  /**
   * Sets the diameter of the round
   * @param diameter the diameter
   * @throws IllegalArgumentException for diameters <= 0
   */
  public void setDiameter(double diameter) throws IllegalArgumentException, IndexOutOfBoundsException, IllegalStateException {
    setSingleDimension(0, diameter);
  }

  /**
   * Sets the thickness of the round
   * @param thickness the width of the shape
   * @throws IllegalArgumentException for thickness <= 0
   */
  public void setThickness(double thickness) throws IllegalArgumentException, IndexOutOfBoundsException, IllegalStateException {
    setSingleDimension(1, thickness);
  }

  /**
   * Gets the diameter of the round
   * @return the diameter of this object
   */
  public double getDiameter(){
    return this.getSingleDimension(0);
  }

  /**
   * Gets the thickness of the round
   * @return the thickness of this object
   */
  public double getThickness() {return this.getSingleDimension(1);}

  //TODO: getHash override

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
