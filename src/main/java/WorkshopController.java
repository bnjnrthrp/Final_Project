import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import java.io.InputStream;

public class WorkshopController implements IController, ActionListener {
  private final IView view;
  private final IModel model;

  public WorkshopController(IModel model, IView viewer) {
    this.model = model;
    this.view = viewer;
    view.setListener(this);
  }

  public void go() {
    model.loadWorkshop();

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
