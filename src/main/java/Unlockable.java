public abstract class Unlockable {
  protected int value;
  protected boolean unlocked = false;

  public Unlockable(int value){
    this.setValue(value);
  }

  private void setValue(int value){
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

  protected void unlock(){
    this.unlocked = true;
  }
}
