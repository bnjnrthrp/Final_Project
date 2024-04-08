import java.io.PrintStream;
import java.util.List;

public class WorkshopView<T> implements IView<T> {
  private PrintStream out;
  private IMenuTree menu;

  public WorkshopView(PrintStream out) {this.out = out;}



  @Override
  public void showADTList(ADTList<T> list) {
    out.println(list);
    out.println();
  }

  @Override
  public void showString(String str) {
    out.println(str);
    out.println();
  }

  @Override
  public void showMenu(Menu menu){
    out.println(menu.getTitle());
    out.println();
  }

  @Override
  public void showList(List<T> list) {
    for (int i = 0; i < list.size(); i++){
      out.println("%d: %s".formatted(i, list.get(i).toString()));
    }
    out.println();
  }

  @Override
  public void showOptions(Menu menu) {
    out.println(menu.getSubMenu());
    out.println();
  }

  @Override
  public void showError(Exception e){
    out.println(Const.ERROR_TRY_AGAIN + ". Error: " + e.getMessage());
    out.println();
  }

  @Override
  public void showInt(int num){
    out.println("Current balance: %d".formatted(num));
    out.println();
  }

  @Override
  public void cueInput(){
    out.println("-1: back to main menu\n-2: exit the program\n"
        + "Enter input: ");
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
    out.println();
  }

}
