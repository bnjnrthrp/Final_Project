import java.util.function.Function;
import java.util.function.Predicate;

public interface INode<T> {
  INode<T> addFront(T data);

  INode<T> addBack(T data);

  INode<T> add(T data);

  INode<T> add(T data, int index);

  void addAll(INode<T> head);

  INode<T> remove(T data);

  INode<T> remove(int index);

  int count();

  int count(Predicate<T> tester);

  <T> INode<T> filter(Predicate<T> tester);

  <R> INode<R> map(Function<T,R> converter);

  T get(int index);

  INode<T> getNext();

  void setNextNode(INode<T> nextNode);
  @Override
  String toString();

  String printAll(int startIndex);
}
