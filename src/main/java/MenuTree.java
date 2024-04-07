import java.util.function.Predicate;

public class MenuTree implements IMenuTree{
  private ITreeNode<Menu> root;

  public MenuTree(Menu menu){
    root = new LeafNode<>(menu);
  }

  /**
   * Add a submenu to another menu.
   *
   * @param menu     the established menu
   * @param prevMenu the submenu to add
   */
  @Override
  public void addMenu(Menu menu, Menu prevMenu) {
    ITreeNode<Menu> newMenu = new LeafNode<>(menu);
    root = root.addChild(m -> m.getTitle().equals(prevMenu.getTitle()), newMenu);
  }

  /**
   * Print the contents of the menu based on the Predicate
   *
   * @param tester the test to identify the menu
   */
  @Override
  public void printMenu(Predicate<Menu> tester) {

  }
}
