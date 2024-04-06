import java.util.function.Function;
import java.util.function.Predicate;

public interface iNode<T> {
  iNode<T> addFront(T data);

  iNode<T> addBack(T data);

  iNode<T> add(T data);

  iNode<T> add(T data, int index);

  void addAll(iNode<T> head);

  iNode<T> remove(T data);

  iNode<T> remove(int index);

  int count();

  int count(Predicate<T> tester);

  <T> iNode<T> filter(Predicate<T> tester);

  <R> iNode<R> map(Function<T,R> converter);

  T get(int index);

  iNode<T> getNext();

  void setNextNode(iNode<T> nextNode);
  @Override
  String toString();

  String printAll();
}
