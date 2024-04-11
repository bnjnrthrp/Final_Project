/**
 * Benjamin Northrop
 * CS5004
 * Final Project
 * SP2024
 */

import java.util.Arrays;

/**
 * This class is the Model of the MVC workshop. It holds all the data and provides all the functionality
 * to be called by the controller based on user inputs.
 */
public class WorkshopModel implements IModel {
  private int balance;
  private IADT<Wood> woodInventory;
  private IADT<Tool> tools;
  private IADT<Jig> jigs;
  private IADT<Furniture> furniture;
  private IADT<Furniture> blueprints;

  /**
   * Constructor for a workshop model. It will hold the instance variables which contain the various
   * bits of data that the user interacts with. *
   */
  public WorkshopModel(){
    this.balance = 0;
    this.woodInventory = new ADTList<Wood>();
    this.tools = new ADTList<Tool>();
    this.jigs = new ADTList<Jig>();
    this.furniture = new ADTList<Furniture>();
    this.blueprints = new ADTList<Furniture>();

  }

  /**
   * Go to work to get money for the account
   */
  @Override
  public void goToWork() {
    this.addMoney(100);
  }

  /**
   * gets the account balance of the model
   * @return the account balance.
   */
  @Override
  public int getBalance(){
    return this.balance;
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

  /**
   * Subtracts money from the account
   * @param amount the amount to remove
   * @throws IllegalArgumentException if the amount is negative.
   */
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

    this.jigs.add(Jig.crossCutSled);
    this.jigs.add(Jig.tapeMeasure);

    this.blueprints = Furniture.getBlueprints();
  }

  /**
   * Buys a standard size wood of type Woodtype. Adds the purchased wood to our inventory
   *
   * @param type The type of wood being purchased
   */
  @Override
  public void buyWood(WoodType type) {
    if (type == WoodType.plywood && this.balance > Const.VALUE_WOOD_STANDARD_PLY){
      this.woodInventory.add(new Plywood());
      this.subtractMoney(Const.VALUE_WOOD_STANDARD_PLY);
    } else if (type == WoodType.dimensional && this.balance > Const.VALUE_WOOD_STANDARD_2X4){
      this.woodInventory.add(new DimensionalWood());
      this.subtractMoney(Const.VALUE_WOOD_STANDARD_2X4);
    } else {
      throw new IllegalStateException(Const.ERROR_INSUFFICIENT_FUNDS);
    }
  }

  /**
   * Gets the piece of wood at a given index from the wood inventory.
   * @param index the index within the inventory of the desired item
   * @return the desired piece of wood.
   */
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
  public void unlockTool(IUnlockable tool) throws IllegalStateException {
    if (this.balance < tool.getValue()){
      throw new IllegalStateException(Const.ERROR_INSUFFICIENT_FUNDS);
    }
    tool.unlock();
    this.subtractMoney(tool.getValue());
  }

  /**
   * Cuts a piece of wood using one of the tools in the shop. May use a jig
   *
   * @param woodIndex    The piece of wood to cut
   * @param toolIndex    The tool to do the cutting
   * @param newSize The size we want to cut it to
   * @return An ADTList with 2 pieces of wood, one of the size and the other, the remaining
   */
  @Override
  public void cutWood(int woodIndex, int toolIndex, double newSize) {
        ICuttingTool tool = (ICuttingTool) this.getTools(toolIndex);
    try {
      woodInventory.addAll(tool.cut(woodInventory.get(woodIndex), newSize));
    } catch (IllegalArgumentException | IllegalStateException e) {
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
   * @return An ADTList with 2 pieces of wood, one of the size and the other, the remaining
   */
  @Override
  public void cutWood(int woodIndex, int toolIndex, int jigIndex, double newSize) {
    // Get the indices for the tools and jig
    // Type conversion to ICuttingTool to ensure we grabbed a saw of some sort.
    ICuttingTool tool = (ICuttingTool) this.getTools(toolIndex);
    Jig jig = this.getJigs(jigIndex);

    // Attempt to cut the wood and add the remainder to the inventory.
    try {
      woodInventory.addAll(tool.cut(woodInventory.get(woodIndex), jig, newSize));
    } catch (IllegalArgumentException | IllegalStateException e) {
      // If an error, send it back to the controller.
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
  public void makeFurniture(Furniture furniture) throws IllegalStateException {
    // Fold the inventory to ensure there are sufficient components
    int legCount;
    int topCount;

    switch (furniture){
      case SmallStool:
        // Compares the dimensions of each component to the standard template via Arrays.equals
        legCount = woodInventory.count(w-> Arrays.equals(w.getShape().getDimensions(), Const.STOOL_LEGS));
        topCount = woodInventory.count(w-> Arrays.equals(w.getShape().getDimensions(), Const.STOOL_SEAT));
        // If successful, loop through each component in the enum, remove it from the list
        if (legCount >= Const.STOOL_NUM_LEGS && topCount >= Const.STOOL_NUM_SEATS){
          for (int i = 0; i < furniture.getNumComponents(); i++){
            woodInventory.remove(furniture.getComponents().get(i)); // Gets the corresponding component from the enum
          }
        } else {
          throw new IllegalStateException(Const.ERROR_INSUFFICIENT_WOOD);
        }
        break;
        // Looks at the case of a chair. Has a separate counter for back/front legs.
      case Chair:
        // Compares the dimensions of each component to the standard template via Arrays.equals
        legCount = woodInventory.count(w-> Arrays.equals(w.getShape().getDimensions(), Const.CHAIR_BACK_LEGS));
        int frontLegCount = woodInventory.count(w-> Arrays.equals(w.getShape().getDimensions(), Const.CHAIR_FRONT_LEGS));
        topCount = woodInventory.count(w->Arrays.equals(w.getShape().getDimensions(), Const.CHAIR_SEAT));

        if (legCount >= Const.CHAIR_NUM_BACK_LEGS
            && frontLegCount >= Const.CHAIR_NUM_FRONT_LEGS
            && topCount >= Const.STOOL_NUM_SEATS){
          for (int i = 0; i < furniture.getNumComponents(); i++){
            woodInventory.remove(furniture.getComponents().get(i)); // Gets the corresponding component from the enum
          }
        } else {
          throw new IllegalStateException(Const.ERROR_INSUFFICIENT_WOOD);
        }
        break;
      case Table:
        // Compares the dimensions of each component to the standard template via Arrays.equals
        legCount = woodInventory.count(w->Arrays.equals(w.getShape().getDimensions(), Const.TABLE_LEGS));
        topCount = woodInventory.count(w->Arrays.equals(w.getShape().getDimensions(), Const.TABLE_TOP));

        if (legCount >= Const.TABLE_NUM_LEGS && topCount >= Const.TABLE_NUM_TOPS){
          for (int i = 0; i < furniture.getNumComponents(); i++){
            woodInventory.remove(furniture.getComponents().get(i)); // Gets the corresponding component from the enum
          }
        } else {
          throw new IllegalStateException(Const.ERROR_INSUFFICIENT_WOOD);
        }
        break;
    }
    // if all successful, then add the furniture piece to the collection.
    this.furniture.add(furniture);
  }

  /**
   * Gets a list of the inventory of furniture in the workshop.
   * @return an ADTList of furniture
   */
  @Override
  public IADT<Furniture> getFurniture(){return this.furniture;}

  /**
   * Returns an Arraylist of the wood inventory in the shop
   *
   * @return the wood inventory
   */
  @Override
  public IADT<Wood> getWoodInventory() {
    return this.woodInventory;
  }

  /**
   * Returns an Arraylist with the tool inventory of the shop, and their unlocked status.
   *
   * @return the tool inventory
   */
  @Override
  public IADT<Tool> getTools() {
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
   * Returns an ADTList with the jig inventory of the shop, and their unlocked status.
   *
   * @return the jig inventory
   */
  @Override
  public IADT<Jig> getJigs() {
    return this.jigs;
  }

  /**
   * Gets the list of blueprints that are available to the user.
   * @return an ADTList of all the blueprints in the Furniture enum.
   */
  @Override
  public IADT<Furniture> getBlueprints(){
    return this.blueprints;
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
