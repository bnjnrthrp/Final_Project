import java.io.PrintStream;

public class WorkshopView<T> implements IView<T> {
  private PrintStream out;
  private IMenuTree menu;

  public WorkshopView(PrintStream out) {this.out = out;}

  private void loadMenus(){
    Menu main = new Menu(MenuCategories.mainMenu);
    menu = new MenuTree(main);
    menu.addMenu(new Menu(MenuCategories.work), main);
    System.out.println(menu);
  }

  @Override
  public void showADTList(ADTList<T> list) {
    out.println(list.getClass().getSimpleName() + "\n" + list);
  }

  @Override
  public void showString(String str) {
    out.println(str);
  }

  @Override
  public void showOptions() {

  }

  @Override
  public void showInt(int number){
    out.println("Balance: " + number);
  }
}
