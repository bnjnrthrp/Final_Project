import java.util.Scanner;
import java.io.InputStream;

public class Controller implements IController {
  private Scanner in;
  private IView view;
  private IModel model;

  public Controller(IModel model, InputStream in, IView viewer){
    this.model = model;
    this.view = viewer;
    this.in = new Scanner(in);
  }

  public void go(){
    boolean exit = false;

    while (!exit){

    }

  }
}
