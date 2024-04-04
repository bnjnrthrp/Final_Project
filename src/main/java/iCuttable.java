import java.util.ArrayList;

public interface iCuttable<T> {
  ArrayList<T> cut(int sideIndex, double newDimension, boolean accurate);
}
