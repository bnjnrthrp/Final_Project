import java.io.PrintStream;
import java.util.List;

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
    out.println(list);
  }

  @Override
  public void showString(String str) {
    out.println(str);
  }

  @Override
  public void showMenu(Menu menu){
    out.println(menu.getTitle());
  }

  @Override
  public void showList(List<T> list) {
    for (int i = 0; i < list.size(); i++){
      out.println("%d: %s".formatted(i, list.get(i).toString()));
    }
  }

  @Override
  public void showOptions(Menu menu) {
    out.println(menu.getSubMenu());
  }

  @Override
  public void showInt(int number){
    out.println("Balance: " + number);
  }

  @Override
  public void showAll(int number, ADTList<Tool> tools, ADTList<Jig> jigs, ADTList<Wood> wood,
      ADTList<Furniture> furniture) {
    out.println("Account Balance: " + number);
    out.println();
    out.println("Tools:\n" + tools);
    out.println();
    out.println("Jigs:\n" + jigs);
    out.println();
    out.println("Wood:\n" + wood);
    out.println();
    out.println("Furniture:\n" + furniture);
  }

}
