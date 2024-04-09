public class MVCWoodshop {
  public static void main(String []args){
    IModel model = new WorkshopModel();
    IView view = new WorkshopView("Woodshop Game");
    IController controller = new WorkshopController(model, view);
    controller.go();
  }
}
