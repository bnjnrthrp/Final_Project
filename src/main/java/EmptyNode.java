import java.util.function.Function;
import java.util.function.Predicate;

public class EmptyNode<T> implements INode<T> {

  /**
   * Adds a node in front of the empty node.
   *
   * @param data the data to insert
   * @return the newly created node
   */
  @Override
  public INode<T> addFront(T data) {
    return new Node<>(data, this);
  }

  /**
   * Inserts a node in front of the empty node.
   *
   * @param data the data to insert
   * @return the newly created node
   */
  @Override
  public INode<T> addBack(T data) {
    return addFront(data);
  }

  /**
   * Inserts a node in front of the empty node.
   *
   * @param data the data to insert
   * @return the newly created node
   */
  @Override
  public INode<T> add(T data){
    return addFront(data);
  }

  /**
   * Inserts a node at a given index. If at the empty node, index is out of range
   *
   * @param data data to add
   * @param index index at which to add it
   * @return an exception
   * @throws IllegalArgumentException index out of range if we've reached the empty node
   */
  @Override
  public INode<T> add(T data, int index) throws IllegalArgumentException {
    if (index == 0) {
      return addFront(data);
    }
    throw new IllegalArgumentException("Invalid index provided");
  }

  /**
   * Appends the beginning of one list to the tail of another. If it got to the empty node, we went
   * too far
   */
  @Override
  public void addAll(INode<T> head) {
    throw new IllegalArgumentException("Invalid index provided");
  }

  /**
   * Cannot remove an empty node, as it doesn't hold data. We've reached here by accident (out of
   * index).
   *
   * @param data the data to remove
   * @return an exception
   * @throws IllegalArgumentException the item is not found
   */
  @Override
  public INode<T> remove(T data) throws IllegalArgumentException {
    throw new IllegalArgumentException("Item does not exist");
  }

  /**
   * Cannot remove an empty node, as it doesn't hold data. We've reached here by accident (out of
   * index).
   *
   * @param index the index of the node to remove
   * @return an exception
   * @throws IllegalArgumentException the item is not found
   */

  @Override
  public INode<T> remove(int index) {
    throw new IllegalArgumentException("Item does not exist");
  }

  /**
   * Gets size of the linked list. Empty node will return 0.
   *
   * @return 0
   */
  @Override
  public int count() {
    return 0;
  }

  /** Gets the size of the linked list that passes a certain criteria */
  @Override
  public int count(Predicate<T> tester) {
    return 0;
  }

  /**
   * Predicate test for empty node always returns the empty node.
   *
   * @param tester the test
   * @return an empty node
   */
  @Override
  public <T> INode<T> filter(Predicate<T> tester) {
    return new EmptyNode<>();
  }

  /**
   * Gets the node at a given index
   *
   * @param index desired index
   * @return returns null, since if we've reached the empty node
   * @throws IllegalArgumentException index out of range trying to get from an empty node.
   */
  @Override
  public T get(int index) {
    return null;
  }

  @Override
  public INode<T> getNext() {
    return null;
  }

  @Override
  public void setNextNode(INode<T> nextNode) {
    throw new IllegalStateException("Cannot add next to empty node");
  }

  /**
   * Applies a converter function to the node and transforms the data
   *
   * @param converter the function that is performing the transformation
   * @return the result of the function, of type R
   * @param <R> the return type of the function
   */
  @Override
  public <R> INode<R> map(Function<T, R> converter) {
    return new EmptyNode<>();
  }

  /**
   * Prints the contents of the empty node
   *
   * @return ""
   */
  @Override
  public String toString() {
    return "";
  }

  /**
   * Prints the contents of the empty node
   *
   * @return ""
   */
  @Override
  public String printAll(int startIndex) {
    return this.toString();
  }
}
