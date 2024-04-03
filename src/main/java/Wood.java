import java.util.ArrayList;

/**
 * This class represents wood to be used for carpentry. It has a shape, which contains its
 * dimensions, and it also contains a type. In future expansion, the type of wood can have an impact
 * on how difficult it is to work with (soft vs hard woods) and what furniture can be made.
 */
public abstract class Wood implements iCuttable<Wood>{
  private Shape shape;
  private final WoodType type;
  private boolean smooth = false;

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
   * Adjusts the surface from rough to smooth
   */
  public void makeSmooth() {this.smooth = true;}

  public boolean isSmooth() {return this.smooth;}

  public ArrayList<Wood> cut(double size, boolean accurate){
    Wood piece1;
    Wood piece2;

    return null;
  }

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
    return "Type: %s, Dimensions: %s".formatted(this.getType(), this.getShape().toString());
  }
}
