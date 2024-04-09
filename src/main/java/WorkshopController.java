/**
 * Benjamin Northrop
 * CS5004
 * Final Project
 * SP2024
 * This class is the controller for the MVC workshop model. It sets up the model, then listens for
 * inputs from the view to interact with the model.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WorkshopController implements IController, ActionListener {
  private final IView view;
  private final IModel model;

  /**
   * Constructor for a Workshop controller. Takes in a model and view object, then sets the listeners
   * @param model
   * @param viewer
   */
  public WorkshopController(IModel model, IView viewer) {
    this.model = model;
    this.view = viewer;
    view.setListener(this);
  }

  /**
   * Starts the program by having the model load everything up then displaying the data to the user.
   */
  public void go() {
    // Initialize all of the items/tools/jigs
    model.loadWorkshop();

    // Get the current status of the instance variables and display them.
    view.showAll(
        model.getBalance(),
        model.getTools(),
        model.getJigs(),
        model.getWoodInventory(),
        model.getFurniture(),
        model.getBlueprints());
  }

  /**
   * Invoked when an action occurs.
   *
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {

    try{
      view.displayMessage("Message: \n");
      switch (e.getActionCommand()){
        case "goToWork": model.goToWork(); break;
        case "buyPlywood": model.buyWood(WoodType.plywood); break;
        case "buyDimensional": model.buyWood(WoodType.dimensional); break;
        case "buyTool": {
          int index = view.getToolField();
          model.unlockTool(model.getTools(index));
          break;
        }
        case "buyJig": {
          int index = view.getJigField();
          model.unlockTool(model.getJigs(index));
          break;
        }
        case "cutWood": {
          int woodIndex = view.getWoodField();
          int toolIndex = view.getToolField();
          double dim = view.getDimensionField();
          int jigIndex = view.getJigField();
          if (jigIndex == -1){
            model.cutWood(woodIndex, toolIndex, dim);
          } else{
            model.cutWood(woodIndex, toolIndex, jigIndex, dim);
          }
          break;
        }
        case "makeFurniture": {
          int index = view.getFurnitureField();
          model.makeFurniture(Furniture.values()[index]);
          break;
        }
        case "exit": System.exit(0); break;
      }
    } catch (Exception exception) {
      view.displayMessage("Message: \n" + exception.getMessage());
    }
      view.clearInputFields();
      view.showAll(
          model.getBalance(),
          model.getTools(),
          model.getJigs(),
          model.getWoodInventory(),
          model.getFurniture(),
          model.getBlueprints());


  }

}
