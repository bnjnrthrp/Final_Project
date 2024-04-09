import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTextField;

public interface IView<T> {
  void showADTList(ADTList<T> list);
  void showString(String str);
  void showMenu(Menu menu);
  void showList(List<T> list);
  void showOptions(Menu menu);
  void showInt(int num);
  void showError(Exception e);

  void cueInput();
  void display();
  void setListener(ActionListener listener);


  int getToolField();

  int getJigField();

  int getWoodField();

  double getDimensionField();

  int getFurnitureField();

  void clearInputFields();
  String ADTListToString(ADTList<T> list);
  void showAll(int number, ADTList<Tool> tools, ADTList<Jig> jigs, ADTList<Wood> wood,
      ADTList<Furniture> furniture);
}
