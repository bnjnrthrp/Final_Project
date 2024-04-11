/**
 * Benjamin Northrop
 * CS5004
 * Final Project
 * SP2024
 * This interface represents all the actions a View must be able to work in this MVC frame
 */

import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public interface IView<T> {
  void setListener(ActionListener listener);

  int getToolField();

  int getJigField();

  int getWoodField();

  double getDimensionField();

  int getFurnitureField();

  void displayMessage(String s);

  void clearInputFields();

  void showAll(int number, IADT<Tool> tools, IADT<Jig> jigs, IADT<Wood> wood,
      IADT<Furniture> furniture, IADT<Furniture> blueprints);
}
