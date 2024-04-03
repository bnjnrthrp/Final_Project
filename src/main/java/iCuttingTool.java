import java.util.List;

public interface iCuttingTool {
  List<Wood> cut(Wood wood, double size);
  List<Wood> cut(Wood wood, double size, Jig jig);
}
