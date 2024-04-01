/** This class groups together all tools under one umbrella. Currently contains just cutting tools,
 * it can later be expanded to include sanding tools, painting tools, etc.
 */


public abstract class Tool extends Unlockable{
  public Tool(int value){
    super(value);
  };
}
