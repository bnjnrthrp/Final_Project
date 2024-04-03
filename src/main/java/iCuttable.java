import java.util.List;

public interface iCuttable<T> {
  List<T> cut(double size, boolean accurate);
}
