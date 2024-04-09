import java.util.ArrayList;

/** This enum contains the various names of furniture that may be built */
public enum Furniture {
  SmallStool(50, 1),
  Chair(75, 2),
  Table(300, 3);

  private int value;
  private ADTList<Wood> components;
  private int numComponents;

  Furniture(int value, int composition){
    this.setValue(value);
    this.setComponents(composition);
  }

  /**
   * Sets the value of the object.
   * @param value the value to set the object to
   * @throws IllegalArgumentException if the value <= 0
   */
  private void setValue(int value) throws IllegalArgumentException{
    if (value <= 0) {
      throw new IllegalArgumentException(Const.ERROR_NON_POSITIVE_VALUE);
    } else {
      this.value = value;
    }
  }

  private void setComponents(int input){
    this.components = new ADTList<>();
    switch (input){
      case 1:
        components.add(new DimensionalWood(Const.STOOL_LEGS));
        components.add(new DimensionalWood(Const.STOOL_LEGS));
        components.add(new DimensionalWood(Const.STOOL_LEGS));
        components.add(new Plywood(Const.STOOL_SEAT));
        break;
      case 2:
        components.add(new DimensionalWood(Const.CHAIR_FRONT_LEGS));
        components.add(new DimensionalWood(Const.CHAIR_FRONT_LEGS));
        components.add(new DimensionalWood(Const.CHAIR_BACK_LEGS));
        components.add(new DimensionalWood(Const.CHAIR_BACK_LEGS));
        components.add(new Plywood(Const.CHAIR_SEAT));
        break;
      case 3:
        components.add(new DimensionalWood(Const.TABLE_LEGS));
        components.add(new DimensionalWood(Const.TABLE_LEGS));
        components.add(new DimensionalWood(Const.TABLE_LEGS));
        components.add(new DimensionalWood(Const.TABLE_LEGS));
        components.add(new Plywood(Const.TABLE_TOP));
    }
    this.numComponents = components.count();
  }

  public int getNumComponents(){
    return this.numComponents;
  }

  public ADTList<Wood> getComponents(){
    return this.components;
  }

}
