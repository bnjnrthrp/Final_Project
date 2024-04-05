/**
 * This class represents a router, which is a spinning blade that can cut round shapes. When
 * a circle cut jig is attached, has the ability to cut circles out of rectangular wood. If no
 * jig is used, it will simply smooth the edges of the wood
 */

import java.util.ArrayList;


public class Router extends Tool {

  public Router(){
    super(Const.VALUE_TOOL_ROUTER);
  }

  public ArrayList<Wood> smooth(Wood wood) {
    ArrayList<Wood> piece = new ArrayList<>();
    wood.makeSmooth();
    piece.add(wood);
    return piece;
  }


  public ArrayList<Wood> cut(Plywood wood, double size, Jig jig) {
    return wood.cut(0, size, true, cutShape.rectToRound);


  }
}
