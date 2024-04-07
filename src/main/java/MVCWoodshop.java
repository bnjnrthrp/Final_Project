public class MVCWoodshop {
  public static void main(String []args){
    IModel model = new WorkshopModel();
    IView view = new WorkshopView(System.out);
    IController controller = new WorkshopController(model, System.in, view);
    controller.go();
  }
}
