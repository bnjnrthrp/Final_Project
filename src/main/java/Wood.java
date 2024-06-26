/**
 * Benjamin Northrop
 * CS5004
 * Final Project
 * SP2024
 *
 * This class represents wood to be used for carpentry. It has a shape, which contains its
 * dimensions, and it also contains a type. In future expansion, the type of wood can have an impact
 * on how difficult it is to work with (soft vs hard woods) and what furniture can be made.
 */
public abstract class Wood implements ICuttable<Wood> {
  protected Shape shape;
  protected final WoodType type;

  /**
   * Basic constructor for a piece of wood.
   * @param type The type of wood from the WoodType enum.
   */
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

  /**
   * Getter for the Shape
   * @return this object's WoodType
   */
  public Shape getShape(){
    return this.shape;
  }

  /**
   * Abstract function to give functionality of cutting a piece of wood. Behavior will vary depending on the
   * type of wood being cut.
   * @param sideIndex the side (dimension) of the wood to cut
   * @param newDimension the new dimension
   * @return an ADTList with the remaining piece of wood.
   */
  public abstract ADTList<Wood> cut(int sideIndex, double newDimension);

  /**
   * Determines equality between two pieces of wood.
   * To be equal, it must be of the same type, and exact same dimensions (to ensure equal grain direction).
   * @param obj the object to compare
   * @return true if the wood is the same.
   */
  @Override
  public boolean equals(Object obj){
    if (obj == null || this.getClass() != obj.getClass()) return false;
    if (this == obj) return true;
    if (!(obj instanceof Wood)) return false;
    Wood test = (Wood) obj;
    return this.getShape().equals(test.getShape()) && this.getType() == test.getType();
  }

  /**
   * Returns the type and dimensions of this piece of wood.
   * @return the type and dimensions of this piece
   */
  @Override
  public String toString(){
    return "Type: %s, %s\n".formatted(this.getType(), this.getShape().toString());
  }
}
