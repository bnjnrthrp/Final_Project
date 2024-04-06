/** This class groups together all tools under one umbrella. Currently contains just cutting tools,
 * it can later be expanded to include sanding tools, painting tools, etc.
 */


public abstract class Tool extends Unlockable implements iCuttingTool, iUnlockable{
  public Tool(int value){
    super(value);
  };
  @Override
  public String toString(){
    return "Tool: %s, Value: %d, Unlocked: %b".formatted(this.getClass().getSimpleName(), this.getValue(), this.isUnlocked());
  }
}
