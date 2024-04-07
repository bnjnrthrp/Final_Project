public enum MenuCategories {
  mainMenu(Const.MENU_START, Const.MENU_GENERIC_TODO),
  work(Const.MENU_WORK, Const.MENU_GENERIC_TODO),
  buy(Const.MENU_STORE, Const.MENU_STORE_SUBMENU),
  workshop(Const.MENU_WORKSHOP, Const.MENU_GENERIC_TODO),
  tools(Const.MENU_TOOLS,Const.MENU_TOOLS_SUBMENU),
  jigs(Const.MENU_JIGS, Const.MENU_JIGS_SUBMENU),
  lumber(Const.MENU_LUMBER, Const.MENU_LUMBER_SUBMENU),
  cutWood(Const.MENU_CUT, Const.MENU_CUT_SUBMENU),
  buildFurniture(Const.MENU_BUILD_FURNITURE, Const.MENU_BUILD_FURNITURE_SUBMENU),
  displayInventory(Const.MENU_SEE_INVENTORY, Const.MENU_GENERIC_TODO);

  private String title;
  private String subMenu;

  MenuCategories(String title, String subMenu){
    this.title = title;
    this.subMenu = subMenu;
  };

  public String getTitle(){return this.title;}

  public String getSubMenu(){return this.subMenu;}
}
