import java.util.ArrayList;

public class WorkshopModel implements iWorkshop{
  private int account;
  private ArrayList<Wood> inventory;
  private ArrayList<Tool> tools;
  private ArrayList<Jig> jigs;

  public WorkshopModel(){
    this.account = 0;
    this.inventory = new ArrayList<Wood>();
    this.tools = new ArrayList<Tool>();
    this.jigs = new ArrayList<Jig>();

  }

  /**
   * Go to work to get money for the account
   */
  @Override
  public void goToWork() {
    ;
  }

  private void changeBalance(int amount, boolean subtract) throws IllegalArgumentException{
    if (amount < 0){
      throw new IllegalArgumentException(Const.ERROR_NON_POSITIVE_VALUE);
    } else if (subtract) {
      this.account -= amount;
      return;
    } else {
      this.account += amount;
    }
  }

  /**
   * Adds money to the account.
   * @param amount the amount to add
   * @throws IllegalArgumentException if the amount provided is < 0
   */
  private void addMoney(int amount) throws IllegalArgumentException{
    if (amount < 0){
      throw new IllegalArgumentException(Const.ERROR_NON_POSITIVE_VALUE);
    } else {
      this.account += amount;
    }
  }

  private void subtractMoney(int amount) throws IllegalArgumentException{
    if (amount < 0) {
      throw new IllegalArgumentException(Const.ERROR_NON_POSITIVE_VALUE);
    } else {
      this.account -= amount;
    }
  }

  /**
   * Loads the workshop, initializes all the tools, jigs, and locks them so they can later be
   * unlocked. Initializes the inventories.
   */
  @Override
  public void loadWorkshop() {

  }

  /**
   * Buys a standard size wood of type Woodtype. Adds the purchased wood to our inventory
   *
   * @param type The type of wood being purchased
   */
  @Override
  public void buyWood(WoodType type) {

  }

  /**
   * Unlocks a tool to make it available for use.
   *
   * @param tool the tool to unlock
   * @throws IllegalStateException if you attempt to unlock a tool that is already unlocked.
   */
  @Override
  public void unlockTool(iUnlockable tool) throws IllegalStateException {

  }

  /**
   * Cuts a piece of wood using one of the tools in the shop. May use a jig
   *
   * @param wood    The piece of wood to cut
   * @param tool    The tool to do the cutting
   * @param newSize The size we want to cut it to
   * @return An ArrayList with 2 pieces of wood, one of the size and the other, the remaining
   */
  @Override
  public ArrayList<Wood> cutWood(Wood wood, iCuttingTool tool, double newSize) {
    return null;
  }

  /**
   * Cuts a piece of wood using one of the tools in the shop. May use a jig
   *
   * @param wood    The piece of wood to cut
   * @param tool    The tool to do the cutting
   * @param jig     A jig to help the cutting
   * @param newSize The size we want to cut it to
   * @return An ArrayList with 2 pieces of wood, one of the size and the other, the remaining
   */
  @Override
  public ArrayList<Wood> cutWood(Wood wood, iCuttingTool tool, Jig jig, double newSize) {
    return null;
  }

  /**
   * Attempts to build and sell a piece of furniture built from the available wood in the inventory
   *
   * @param furniture the desired piece of furniture
   * @return the value of the furniture sold
   * @throws IllegalStateException If there was insufficient or compatible wood to make the furniture
   */
  @Override
  public double makeFurniture(Furniture furniture) throws IllegalStateException {
    return 0;
  }

  /**
   * Returns an Arraylist of the wood inventory in the shop
   *
   * @return the wood inventory
   */
  @Override
  public ArrayList<Wood> getWoodInventory() {
    return null;
  }

  /**
   * Returns an Arraylist with the tool inventory of the shop, and their unlocked status.
   *
   * @return the tool inventory
   */
  @Override
  public ArrayList<Tool> getTools() {
    return null;
  }

  /**
   * Returns an ArrayList with the jig inventory of the shop, and their unlocked status.
   *
   * @return the jig inventory
   */
  @Override
  public ArrayList<Jig> getJigs() {
    return null;
  }
}
