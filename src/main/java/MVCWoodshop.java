public class MVCWoodshop {
  public static void main(String []args){
    IModel model = new WorkshopModel();
//    IView view = new WorkshopView(System.out);
    IView view = new JFrameView("Woodshop Game");
    IController controller = new WorkshopController(model, System.in, view);
    controller.go();
  }
}
