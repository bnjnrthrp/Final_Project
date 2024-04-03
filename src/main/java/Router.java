/**
 * This class represents a router, which is a spinning blade that can cut round shapes. When
 * a circle cut jig is attached, has the ability to cut circles out of rectangular wood. If no
 * jig is used, it will simply smooth the edges of the wood
 */

import java.util.List;

public class Router extends Tool implements iCuttingTool {

  public Router(){
    super(Const.VALUE_TOOL_ROUTER);
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
