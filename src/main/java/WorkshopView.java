import java.io.PrintStream;

public class WorkshopView<T> implements IView<T> {
  private PrintStream out;

  public WorkshopView(PrintStream out) {this.out = out;}


  @Override
  public void showADTList(ADTList<T> input) {
    out.println();
  }

  @Override
  public void showString() {

  }

  @Override
  public void showOptions() {

  }
}
