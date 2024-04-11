import java.util.function.Function;
import java.util.function.Predicate;

public interface IADT<T> {

  void add(T data);

  void add(T data, int index) throws IllegalArgumentException;

  T get(int index) throws IllegalArgumentException;

  void addAll(ADTList<T> list);

  void remove(T data);

  void remove(int index);

  int count();

  int count(Predicate<T> tester);

  <T> ADTList<T> filter(Predicate<T> tester);

  <R> ADTList<R> map(Function<T, R> converter);
}
