public class Menu {
  private String title;
  private String subMenu;

  Menu(MenuCategories menu){
    this.title = menu.getTitle();
    this.subMenu = menu.getSubMenu();
  }

  public String getTitle(){
    return this.title;
  }

  public String getSubMenu(){
    return this.subMenu;
  }

  @Override
  public String toString(){
    return this.title;
  }
}
