public interface ICuttingTool {
  ADTList<Wood> cut(Wood wood, double size);
  ADTList<Wood> cut(Wood wood, Jig jig, double size);
}