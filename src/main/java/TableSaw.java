import java.util.List;

public class TableSaw extends Tool implements iCuttingTool {

  public TableSaw(){
    super(Const.VALUE_TOOL_TABLE_SAW);
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
