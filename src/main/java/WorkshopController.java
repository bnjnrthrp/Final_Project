import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import java.io.InputStream;

public class WorkshopController implements IController, ActionListener {
  private final Scanner in;
  private final IView view;
  private final IModel model;

  public WorkshopController(IModel model, InputStream in, IView viewer) {
    this.model = model;
    this.view = viewer;
    this.in = new Scanner(in);
    view.setListener(this);
  }

  public void go() {
    boolean exit = false;
    model.loadWorkshop();
    // Initialize and create the menu
//    Menu main = new Menu(MenuCategories.mainMenu);
//    MenuTree menu = new MenuTree(main);
//    createMenu(menu);

    view.showAll(
        model.getBalance(),
        model.getTools(),
        model.getJigs(),
        model.getWoodInventory(),
        model.getFurniture());

//    // Enter the main loop - keeps the program running
//    while (!exit) {
//      // Show the menu
//      view.showMenu(main);
//      // Keep track of the current location within the menu hierarchy, set to main menu
//      MenuTree current = menu;
//      // Initialize the arguments
//      int choice = 0;
//      int wood;
//      int tool;
//      int jig;
//      double size;
//
//      // Enter the second loop - this will navigate the submenus and allow a return back to the main
//      // menu
//      while (!exit) {
//        view.showOptions(main);
//        view.showList(menu.getChildren());
//        view.cueInput();
//        choice = in.nextInt();
//
//        //// Entering the main menu - options are to work, go to the store, or go to the workshop
//        try {
//          switch (choice) {
//            case -2: exit = true;
//              // cascades into the next case.
//            case -1: break;
//
//            case 0:
//              model.goToWork();
//              view.showInt(model.getBalance());
//              break;
//
//            case 1:
//              current = current.getChild(1);
//              /** Go to the store - have the option to buy tools, jigs, or wood */
//              view.showMenu(current.getMenu());
//              view.showOptions(current.getMenu());
//              view.showList(current.getChildren());
//              view.cueInput();
//              choice = in.nextInt();
//
//              try {
//                switch (choice){
//                  // buy tools
//                  case 0:
//                  // Buy jigs
//                  case 1:
//                  // Buy lumber
//                  case 2:
//
//                  default: throw new IndexOutOfBoundsException(Const.ERROR_INVALID_INDEX);
//                }
//              } catch (IndexOutOfBoundsException e) {
//                view.showError(e);
//              }
//
//
//              System.out.println("chose 1");
//              break;
//
//            case 2:
//              current = current.getChild(2);
//              System.out.println("chose 2");
//              break;
//
//            default:
//              throw new IndexOutOfBoundsException(Const.ERROR_INVALID_INDEX);
//
//          }
//        } catch (IndexOutOfBoundsException e) {
//          view.showError(e);
//        }
//        if (choice == -1) {
//          break;
//        }
//      }
//    }
//  }
//
//  public static void createMenu(IMenuTree menu) {
//    Menu main = new Menu(MenuCategories.mainMenu);
//    Menu work = new Menu(MenuCategories.work);
//    Menu store = new Menu(MenuCategories.buy);
//    Menu workshop = new Menu(MenuCategories.workshop);
//    Menu tools = new Menu(MenuCategories.tools);
//    Menu jigs = new Menu(MenuCategories.jigs);
//    Menu lumber = new Menu(MenuCategories.lumber);
//    Menu cutWood = new Menu(MenuCategories.cutWood);
//    Menu buildFurniture = new Menu(MenuCategories.buildFurniture);
//    Menu displayInventory = new Menu(MenuCategories.displayInventory);
//    Menu chooseWood = new Menu(MenuCategories.chooseWood);
//    Menu chooseTool = new Menu(MenuCategories.chooseTool);
//    Menu chooseJig = new Menu(MenuCategories.chooseJig);
//    Menu chooseDimension = new Menu(MenuCategories.chooseDimension);
//
//    menu.addMenu(work, main);
//    menu.addMenu(store, main);
//    menu.addMenu(workshop, main);
//
//    menu.addMenu(tools, store);
//    menu.addMenu(jigs, store);
//    menu.addMenu(lumber, store);
//
//    menu.addMenu(cutWood, workshop);
//    menu.addMenu(buildFurniture, workshop);
//    menu.addMenu(displayInventory, workshop);
//
//    menu.addMenu(chooseWood, cutWood);
//    menu.addMenu(chooseTool, chooseWood);
//    menu.addMenu(chooseJig, chooseTool);
//    menu.addMenu(chooseDimension, chooseJig);
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
        try {
          int jigIndex = view.getJigField();
          model.cutWood(woodIndex, toolIndex, jigIndex, dim);
        } catch (NullPointerException n){
          model.cutWood(woodIndex, toolIndex, dim);
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
          model.getFurniture());


  }

}
