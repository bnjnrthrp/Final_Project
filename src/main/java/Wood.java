public class Wood extends Shape{
  private Shape shape;
  private final WoodType type;

  public Wood(Shape shape, WoodType type){
    this.shape = shape;
    this.type = type;
  }
}
