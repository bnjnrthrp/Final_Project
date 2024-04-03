import java.util.List;

public class MiterSaw extends Tool implements iCuttingTool {
  public MiterSaw(){
    super(Const.VALUE_TOOL_MITER_SAW);
  }

  @Override
  public List<Wood> cut(Wood wood, double size) {
    return null;
  }

  @Override
  public List<Wood> cut(Wood wood, double size, Jig jig) {
    return null;
  }
}
