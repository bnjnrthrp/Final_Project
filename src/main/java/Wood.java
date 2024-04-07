/**
 * This class represents wood to be used for carpentry. It has a shape, which contains its
 * dimensions, and it also contains a type. In future expansion, the type of wood can have an impact
 * on how difficult it is to work with (soft vs hard woods) and what furniture can be made.
 */
public abstract class Wood implements ICuttable<Wood> {
  protected Shape shape;
  protected final WoodType type;
  protected boolean smooth = false;

  public Wood(WoodType type){
    this.type = type;
  }

  /**
   * Constructor for a piece of wood.
   *
   * @param shape the shape of the wood, this contains its dimensions
   * @param type the type of wood (plywood or dimensional wood, such as 2x4)
   */
  public Wood(Shape shape, WoodType type) {
    this.shape = shape;
    this.type = type;
  }

  /**
   * Getter for the WoodType
   * @return this object's WoodType
   */
  public WoodType getType() {
    return this.type;
  }

  public void setShape(Shape shape){
    this.shape = shape;
  }

  /**
   * Getter for the Shape
   * @return this object's WoodType
   */
  public Shape getShape(){
    return this.shape;
  }

  /**
   * Adjusts the surface from rough to smooth
   */
  public void makeSmooth() {this.smooth = true;}

  /**
   * getter for is smooth instance variable
   * @return boolean, true if the edge is smooth
   */
  public boolean isSmooth() {return this.smooth;}

  public abstract ADTList<Wood> cut(int sideIndex, double newDimension, boolean accurate);

  @Override
  public boolean equals(Object obj){
    if (obj == null || this.getClass() != obj.getClass()) return false;
    if (this == obj) return true;
    if (!(obj instanceof Wood)) return false;
    Wood test = (Wood) obj;
    return this.getShape().equals(test.getShape()) && this.getType() == test.getType() && this.isSmooth() == test.isSmooth();
  }

  /**
   * Returns the type and dimensions of this piece of wood.
   * @return the type and dimensions of this piece
   */
  @Override
  public String toString(){
    return "Type: %s, %s".formatted(this.getType(), this.getShape().toString());
  }
}
