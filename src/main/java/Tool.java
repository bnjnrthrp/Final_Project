/**
 * Benjamin Northrop
 * CS5004
 * Final Project
 * SP2024
 */

/**
 * This class groups together all tools under one umbrella. Currently contains just cutting tools,
 * it can later be expanded to include sanding tools, painting tools, etc.
 */
public abstract class Tool extends Unlockable implements ICuttingTool, IUnlockable {
  public Tool(int value){
    super(value);
  };

  /**
   * Prints the name, value, and unlocked status of a tool.
   * @return the info on the tool.
   */
  @Override
  public String toString(){
    return "%s, Value: %d, Unlocked: %b\n".formatted(this.getClass().getSimpleName(), this.getValue(), this.isUnlocked());
  }
}
