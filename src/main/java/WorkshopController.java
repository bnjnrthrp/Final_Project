import java.util.Scanner;
import java.io.InputStream;

public class WorkshopController implements IController {
  private Scanner in;
  private IView view;
  private IModel model;

  public WorkshopController(IModel model, InputStream in, IView viewer){
    this.model = model;
    this.view = viewer;
    this.in = new Scanner(in);
  }

  public void go(){
    boolean exit = false;

    while (!exit){
      view.showInt(this.model.getBalance());
      view.showADTList(this.model.getTools());
      view.showADTList(this.model.getJigs());
      view.showADTList(this.model.getWoodInventory());
      view.showADTList(this.model.getFurniture());

      exit = true;

    }

  }
}
