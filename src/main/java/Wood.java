/**
 * This class represents wood to be used for carpentry. It has a shape, which contains its
 * dimensions, and it also contains a type. In future expansion, the type of wood can have an impact
 * on how difficult it is to work with (soft vs hard woods) and what furniture can be made.
 */
public abstract class Wood extends Shape {
  private Shape shape;
  private final WoodType type;

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

  /**
   * Getter for the Shape
   * @return this object's WoodType
   */
  public Shape getShape(){
    return this.shape;
  }


  /**
   * Returns the type and dimensions of this piece of wood.
   * @return the type and dimensions of this piece
   */
  @Override
  public String toString(){
    return "Type: %s, Dimensions: %s".formatted(this.getType(), this.getShape().toString());
  }
}