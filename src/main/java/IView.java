import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTextField;

public interface IView<T> {
  void setListener(ActionListener listener);


  int getToolField();

  int getJigField();

  int getWoodField();

  double getDimensionField();

  int getFurnitureField();

  void clearInputFields();

  void showAll(int number, ADTList<Tool> tools, ADTList<Jig> jigs, ADTList<Wood> wood,
      ADTList<Furniture> furniture, ADTList<Furniture> blueprints);
}
