/**
 * Benjamin Northrop
 * CS5004
 * Final Project
 * SP2024
 * This interface represents all the actions a View must be able to work in this MVC frame
 */

import java.awt.event.ActionListener;

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
