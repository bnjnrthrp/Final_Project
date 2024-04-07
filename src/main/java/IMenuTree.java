import java.util.function.Predicate;

public interface IMenuTree {

  /**
   * Add a submenu to another menu.
   * @param menu the established menu
   * @param prevMenu the submenu to add
   */
  void addMenu(Menu menu, Menu prevMenu);

  /**
   * Print the contents of the menu based on the Predicate
   * @param tester the test to identify the menu
   */
  void printMenu(Predicate<Menu> tester);
}
