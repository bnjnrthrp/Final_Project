import java.util.ArrayList;

public interface iCuttingTool {
  ArrayList<Wood> cut(Wood wood, double size);
  ArrayList<Wood> cut(Wood wood, Jig jig, double size);
}
