import java.util.ArrayList;
import java.util.function.Predicate;

public interface IMenuTree {

  /**
   * Add a submenu to another menu.
   * @param menu the established menu
   * @param prevMenu the submenu to add
   */
  void addMenu(Menu menu, Menu prevMenu);

  ArrayList<Menu> getChildren();
}
