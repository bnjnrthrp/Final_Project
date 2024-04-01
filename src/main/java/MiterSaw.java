import java.util.List;

public class MiterSaw extends Tool implements CuttingTool {
  public MiterSaw(){
    super(Const.VALUE_TOOL_MITER_SAW);
  }

  @Override
  public List<Wood> cut(Wood wood) {
    return null;
  }

  @Override
  public List<Wood> cut(Wood wood, Jig jig) {
    return null;
  }
}
