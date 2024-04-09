/**
 * Benjamin Northrop
 * CS5004
 * Final Project
 * SP2024
 * The main driver of the MVC model of a workshop.
 */
public class MVCWoodshop {
  public static void main(String []args){
    IModel model = new WorkshopModel();
    IView view = new WorkshopView("Woodshop Game");
    IController controller = new WorkshopController(model, view);
    controller.go();
  }
}
