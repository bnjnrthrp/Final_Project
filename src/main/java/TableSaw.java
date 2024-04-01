import java.util.List;

public class TableSaw extends Tool implements CuttingTool {

  public TableSaw(){
    super(Const.VALUE_TOOL_TABLE_SAW);
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
