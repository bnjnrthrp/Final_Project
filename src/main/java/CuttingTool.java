import java.util.List;

public interface CuttingTool {
  List<Wood> cut(Wood wood);
  List<Wood> cut(Wood wood, Jig jig);
}
