import java.util.ArrayList;

public class WorkshopModel implements iWorkshop{
  private int balance;
  private ArrayList<Wood> woodInventory;
  private ArrayList<Tool> tools;
  private ArrayList<Jig> jigs;

  public WorkshopModel(){
    this.balance = 0;
    this.woodInventory = new ArrayList<Wood>();
    this.tools = new ArrayList<Tool>();
    this.jigs = new ArrayList<Jig>();

  }

  /**
   * Go to work to get money for the account
   */
  @Override
  public void goToWork() {
    this.addMoney(100);
  }

  @Override
  public int getBalance(){
    return this.balance;
  }

  private void changeBalance(int amount, boolean subtract) throws IllegalArgumentException{
    if (amount < 0){
      throw new IllegalArgumentException(Const.ERROR_NON_POSITIVE_VALUE);
    } else if (subtract) {
      this.balance -= amount;
      return;
    } else {
      this.balance += amount;
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
      this.balance += amount;
    }
  }

  private void subtractMoney(int amount) throws IllegalArgumentException{
    if (amount < 0) {
      throw new IllegalArgumentException(Const.ERROR_NON_POSITIVE_VALUE);
    } else {
      this.balance -= amount;
    }
  }

  /**
   * Loads the workshop, initializes all the tools, jigs, and locks them so they can later be
   * unlocked. Initializes the inventories.
   */
  @Override
  public void loadWorkshop() {
    this.tools.add(new TableSaw());
    this.tools.add(new MiterSaw());
    this.tools.add(new Router());

    this.jigs.add(Jig.crossCutSled);
    this.jigs.add(Jig.tapeMeasure);
    this.jigs.add(Jig.circleCut);
  }

  /**
   * Buys a standard size wood of type Woodtype. Adds the purchased wood to our inventory
   *
   * @param type The type of wood being purchased
   */
  @Override
  public void buyWood(WoodType type) {
    if (type == WoodType.plywood){
      this.woodInventory.add(new Plywood());
    } else if (type == WoodType.dimensional){
      this.woodInventory.add(new DimensionalWood());
    }
  }

  public Wood getWood(int index){
    return this.woodInventory.get(index);
  }

  /**
   * Unlocks a tool to make it available for use.
   *
   * @param tool the tool to unlock
   * @throws IllegalStateException if you attempt to unlock a tool that is already unlocked.
   */
  @Override
  public void unlockTool(iUnlockable tool) throws IllegalStateException {
    tool.unlock();
  }

  /**
   * Cuts a piece of wood using one of the tools in the shop. May use a jig
   *
   * @param woodIndex    The piece of wood to cut
   * @param toolIndex    The tool to do the cutting
   * @param newSize The size we want to cut it to
   * @return An ArrayList with 2 pieces of wood, one of the size and the other, the remaining
   */
  @Override
  public void cutWood(int woodIndex, int toolIndex, double newSize) {
    // Get the specified wood and tool
    Wood wood = this.woodInventory.remove(woodIndex);
    iCuttingTool tool = this.getTools(toolIndex);
    try {
      // Try to cut the wood and add the two pieces back into the inventory
      this.woodInventory.addAll(woodIndex, tool.cut(wood, newSize));
    } catch (IllegalArgumentException | IllegalStateException e){
      // If an error, return the wood back to its original spot
      this.woodInventory.add(woodIndex, wood);
      // Pass the error back to the controller.
      throw e;
    }
  }

  /**
   * Cuts a piece of wood using one of the tools in the shop. May use a jig
   *
   * @param woodIndex    The piece of wood to cut
   * @param toolIndex    The tool to do the cutting
   * @param jigIndex     A jig to help the cutting
   * @param newSize The size we want to cut it to
   * @return An ArrayList with 2 pieces of wood, one of the size and the other, the remaining
   */
  @Override
  public void cutWood(int woodIndex, int toolIndex, int jigIndex, double newSize) {
    // Get the wood, tool and jig
    Wood wood = this.woodInventory.remove(woodIndex);
    iCuttingTool tool = this.getTools(toolIndex);
    Jig jig = this.getJigs(jigIndex);
    // Try to cut the wood and add it back to the inventory
    try {
      // Try to cut the wood and add the two pieces back into the inventory
      this.woodInventory.addAll(woodIndex, tool.cut(wood, newSize));
    } catch (IllegalArgumentException | IllegalStateException e){
      // Otherwise, return the wood
      // If an error, return the wood back to its original spot
      this.woodInventory.add(woodIndex, wood);
      // Pass the error back to the controller.
      throw e;
    }
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
    return this.woodInventory;
  }

  /**
   * Returns an Arraylist with the tool inventory of the shop, and their unlocked status.
   *
   * @return the tool inventory
   */
  @Override
  public ArrayList<Tool> getTools() {
    return this.tools;
  }

  /**
   * Gets a tool from a desired index
   * @param index the index of the desired tool
   * @return the desired tool.
   */
  public Tool getTools(int index){
    return this.tools.get(index);
  }

  /**
   * Returns an ArrayList with the jig inventory of the shop, and their unlocked status.
   *
   * @return the jig inventory
   */
  @Override
  public ArrayList<Jig> getJigs() {
    return this.jigs;
  }

  /**
   * Returns the jig in question
   * @param index the index of the desired jig
   * @return the jig desired
   */
  @Override
  public Jig getJigs(int index){
    return this.jigs.get(index);
  }
}
