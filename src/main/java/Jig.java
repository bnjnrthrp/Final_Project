/**
 * Benjamin Northrop
 * CS5004
 * Final Project
 * SP2024
 *
 * This abstract class represents a generic jig, which is a tool that must be used in harmony with
 * another tool to make a job easier.
 */

public enum Jig implements IUnlockable {
  crossCutSled(Const.VALUE_JIG_CROSSCUT_SLED),
  tapeMeasure(Const.VALUE_JIG_TAPE_MEASURE);

  private int value;
  private boolean unlocked = false;
  Jig(int value){
    this.setValue(value);
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

  /**
   * Returns the value of an unlockable object
   * @return the value
   */
  public int getValue(){
    return this.value;
  }

  /**
   * Returns if an object is unlocked
   * @return boolean, true if unlocked
   */
  public boolean isUnlocked(){
    return this.unlocked;
  }

  /**
   * Changes the jig's status from locked to unlocked.
   */
  public void unlock(){
    this.unlocked = true;
  }

  /**
   * Changes the jig's status from locked to unlocked.
   */
  public void lock(){
    this.unlocked = false;
  }

  /**
   * @return the info of the jig, its value, and unlocked status
   */
  @Override
  public String toString(){
    return "%s, Value: %d, Unlocked: %b\n".formatted(this.name(), this.getValue(), this.isUnlocked());
  }
}
