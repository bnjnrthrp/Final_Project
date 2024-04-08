import java.util.ArrayList;

public class MenuTree implements IMenuTree{
  private ITreeNode<Menu> root;

  public MenuTree(Menu menu){
    root = new LeafNode<>(menu);
  }

  public MenuTree(ITreeNode<Menu> menu){
    root = menu;
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

  @Override
  public ArrayList<Menu> getChildren(){
    return root.getChildren();
  }

  @Override
  public MenuTree getChild(int index){
    return new MenuTree(root.getChild(index));
  }

  @Override
  public Menu getMenu(){
    return root.getData();
  }

}
