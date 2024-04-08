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
    model.loadWorkshop();
    // Initialize and create the menu
    Menu main = new Menu(MenuCategories.mainMenu);
    MenuTree menu = new MenuTree(main);
    createMenu(menu);

    view.showAll(model.getBalance(),
        model.getTools(),
        model.getJigs(),
        model.getWoodInventory(),
        model.getFurniture());
    view.showMenu(main);
    MenuTree current = menu;
    int choice = 0;
    int wood;
    int tool;
    int jig;
    double size;
    while (!exit){
      view.showOptions(main);
      view.showList(menu.getChildren());
      choice = in.nextInt();
      System.out.println("choice was : " + choice);





      exit = true;

    }

  }

  public static void createMenu(IMenuTree menu){
    Menu main = new Menu(MenuCategories.mainMenu);
    Menu work = new Menu(MenuCategories.work);
    Menu store = new Menu(MenuCategories.buy);
    Menu workshop = new Menu(MenuCategories.workshop);
    Menu tools = new Menu(MenuCategories.tools);
    Menu jigs  = new Menu(MenuCategories.jigs);
    Menu lumber = new Menu(MenuCategories.lumber);
    Menu cutWood = new Menu(MenuCategories.cutWood);
    Menu buildFurniture = new Menu(MenuCategories.buildFurniture);
    Menu displayInventory = new Menu(MenuCategories.displayInventory);
    Menu chooseWood = new Menu(MenuCategories.chooseWood);
    Menu chooseTool = new Menu(MenuCategories.chooseTool);
    Menu chooseJig = new Menu(MenuCategories.chooseJig);
    Menu chooseDimension = new Menu(MenuCategories.chooseDimension);



    menu.addMenu(work, main);
    menu.addMenu(store, main);
    menu.addMenu(workshop, main);

    menu.addMenu(tools, store);
    menu.addMenu(jigs, store);
    menu.addMenu(lumber, store);

    menu.addMenu(cutWood, workshop);
    menu.addMenu(buildFurniture, workshop);
    menu.addMenu(displayInventory, workshop);

    menu.addMenu(chooseWood, cutWood);
    menu.addMenu(chooseTool, chooseWood);
    menu.addMenu(chooseJig, chooseTool);
    menu.addMenu(chooseDimension, chooseJig);

  }
}
