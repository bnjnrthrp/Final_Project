/**
 * This class represents a router, which is a spinning blade that can cut round shapes. When
 * a circle cut jig is attached, has the ability to cut circles out of rectangular wood. If no
 * jig is used, it will simply smooth the edges of the wood
 */


/**
 * This class represents a Router, which will smooth the edges if used by itself, or can cut
 * plywood into circles using a circle cut jig.
 */
public class Router extends Tool implements iCuttingTool{

  /**
   * Constructor for a router.
   */
  public Router(){
    super(Const.VALUE_TOOL_ROUTER);
  }

  /**
   * Smooths the edges of a piece of wood.
   * @param wood the wood to be smoothed
   * @return an ADTList of size 1, with the piece of wood.
   */
  @Override
  public ADTList<Wood> cut(Wood wood, double size) {
    ADTList<Wood> piece = new ADTList<>();
    wood.makeSmooth();
    piece.add(wood);
    return piece;
  }

  /**
   * Cuts a piece of plywood into a circle
   * @param wood the plywood to be cut
   * @param size the diameter of the circle desired
   * @param jig the jig to use (must be circleCut)
   * @return an ADTList of size 1 with the new Round.
   * @throws IllegalStateException if the diameter is larger than the length or width of the original
   * piece of wood
   */
  @Override
  public ADTList<Wood> cut(Wood wood, Jig jig, double size) throws IllegalStateException{
    if (jig != Jig.circleCut){
      throw new IllegalStateException(Const.ERROR_INCOMPATIBLE_JIG);
    }
    ADTList<Wood> piece = wood.cut(0, size, true, cutShape.rectToRound);
    piece.get(0).makeSmooth();
    return ;
  }
}
