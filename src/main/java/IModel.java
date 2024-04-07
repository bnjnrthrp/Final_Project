/**
 * The workshop interface is interface that governs the use of the workshop. This represents the
 * main activities of the game - we can go to work, unlock tools, cut wood, and assemble furniture
 */
public interface IModel {

  /** Go to work to get money for the account */
  public void goToWork();

  /** Get the account balance */
  public int getBalance();

  /**
   * Loads the workshop, initializes all the tools, jigs, and locks them so they can later be
   * unlocked. Initializes the inventories.
   */
  public void loadWorkshop();

  /**
   * Buys a standard size wood of type Woodtype. Adds the purchased wood to our inventory
   *
   * @param type The type of wood being purchased
   */
  public void buyWood(WoodType type);

  /**
   * Gets an item from the chosen inventory
   * @param index the index within the inventory of the desired item
   * @return the item chosen.
   */
  public Wood getWood(int index);

  /**
   * Unlocks a tool to make it available for use.
   *
   * @param tool the tool to unlock
   * @throws IllegalStateException if you attempt to unlock a tool that is already unlocked.
   */
  public void unlockTool(IUnlockable tool) throws IllegalStateException;

  /**
   * Cuts a piece of wood using one of the tools in the shop. May use a jig
   *
   * @param woodIndex The piece of wood to cut
   * @param toolIndex The tool to do the cutting
   * @param newSize The size we want to cut it to
   */
  public void cutWood(int woodIndex, int toolIndex, double newSize);

  /**
   * Cuts a piece of wood using one of the tools in the shop. May use a jig
   *
   * @param woodIndex The piece of wood to cut
   * @param toolIndex The tool to do the cutting
   * @param jigIndex A jig to help the cutting
   * @param newSize The size we want to cut it to
   */
  public void cutWood(int woodIndex, int toolIndex, int jigIndex, double newSize);

  /**
   * Attempts to build and sell a piece of furniture built from the available wood in the inventory
   *
   * @param furniture the desired piece of furniture
   * @return the value of the furniture sold
   * @throws IllegalStateException If there was insufficient or compatible wood to make the
   *     furniture
   */
  public void makeFurniture(Furniture furniture) throws IllegalStateException;

  public ADTList<Furniture> getFurniture();

  /**
   * Returns an Arraylist of the wood inventory in the shop
   *
   * @return the wood inventory
   */
  public ADTList<Wood> getWoodInventory();

  /**
   * Returns an Arraylist with the tool inventory of the shop, and their unlocked status.
   *
   * @return the tool inventory
   */
  public ADTList<Tool> getTools();

  /**
   * Gets the specified tool via an index
   * @param index the index of the desired tool
   * @return the tool
   */
  public Tool getTools(int index);

  /**
   * Returns an ADTList with the jig inventory of the shop, and their unlocked status.
   *
   * @return the jig inventory
   */
  public ADTList<Jig> getJigs();

  /**
   * Returns a specific jig from an index
   * @param index the index of the desired jig
   * @return the jig
   */
  public Jig getJigs(int index);
}
