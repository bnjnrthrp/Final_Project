import java.util.List;

public interface IView<T> {
  void showADTList(ADTList<T> list);
  void showString(String str);

  void showMenu(Menu menu);
  void showList(List<T> list);
  void showOptions(Menu menu);
  void showInt(int number);
  void showAll(int number, ADTList<Tool> tools, ADTList<Jig> jigs, ADTList<Wood> wood, ADTList<Furniture> furniture);

}
