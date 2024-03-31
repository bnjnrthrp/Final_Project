public abstract class Unlockable {
  protected int value;
  protected boolean unlocked = false;

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
