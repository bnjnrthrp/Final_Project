/** Benjamin Northrop CS5004 Final*/

import java.util.function.Function;
import java.util.function.Predicate;


/**
 * This class represents an Abstract Data Type for a Linked List.
 *
 * @param <T> The generic type to fill the nodes
 */
public class ADTList<T> {
  private iNode<T> head;

  /** No argument constructor constructs a basic list, with just an empty Node */
  public ADTList() {
    this.head = new EmptyNode();
  }

  /**
   * Constructor with a parameter creates a list and initializes the head of the list.
   *
   * @param data the data to fill the node.
   */
  public ADTList(iNode<T> data) {
    this.head = data;
  }



  /**
   * Adds to the back of the linked list.
   *
   * @param data the data to add to the list.
   */
  public void add(T data) {
    this.head = this.head.addBack(data);
  }

  /**
   * Adds to the linked list at a position given by the index
   *
   * @param data the data to add to the list
   * @param index the index at which to add to the list
   */
  public void add(T data, int index) throws IllegalArgumentException{
    if (index < 0 || index > this.count()){
      throw new IllegalArgumentException("index out of range");
    }
    this.head = this.head.add(data, index);
  }

  /**
   * Adds to the front of the list
   *
   * @param data the data to add to the list
   */
  public void addFront(T data) {
    this.head = this.head.addFront(data);
  }

  /**
   * Adds to the back of the linked list.
   *
   * @param data the data to add to the list.
   */
  public void addBack(T data) {
    this.head = this.head.addBack(data);
  }

  /**
   * Gets the object contained within the node at a given index
   *
   * @param index int, the index to get the data from
   * @return the data contained within the node
   * @throws IllegalArgumentException if the index exceeds the size of the list, or < 0
   */
  public T get(int index) throws IllegalArgumentException {
    if (index < 0 || index > this.count()) {
      throw new IllegalArgumentException("Invalid index");
    } else {
      return this.head.get(index);
    }
  }

  /**
   * Appends the provided list to the back of this current list.
   * @param list the list to add to the tail of this list
   */
  public void addAll(ADTList<T> list) {this.head.addAll(list.head);}

  /**
   * Finds and removes the node containing the data we want to delete
   *
   * @param data the identifiable data to delete from the linked list.
   */
  public void remove(T data) {
    this.head = this.head.remove(data);
  }

  /**
   * Remove a node given an index of the position
   * @param index the index of the node to remove
   * @return the removed task Node
   * @throws IndexOutOfBoundsException if the index is <0
   */
  public void remove(int index){
    this.head = this.head.remove(index);
  }

  /**
   * Gets the size of the linked list
   *
   * @return int, the size of the list.
   */
  public int count() {
    return this.head.count();
  }

  /**
   * Gets the size of the list that matches a given criteria by the Predicate
   * @param tester The predicate function to test the list
   * @return int, the number of items that match the criteria.
   */
  public int count(Predicate<T> tester){
    return this.head.count(tester);
  }

  /**
   * Creates a new linked list containing only the items that pass the predicate test
   *
   * @param tester Predicate, the test to filter the nodes by
   * @return a new ADT list
   */
  public <T> ADTList<T> filter(Predicate<T> tester) {
    return new ADTList<T>(this.head.filter(tester));
  }

  /**
   * Iterates over each item in the List and performs the converter function on it, returning a new list
   * with transformed data
   * @param converter the converter function
   * @return a List of type R
   * @param <R> The return type of the converted list
   */
  public <R> ADTList<R> map(Function<T,R> converter){
    return new ADTList(head.map(converter));
  };


  /**
   * Prints the entire list
   *
   * @return String, each successive node.
   */
  @Override
  public String toString() {
    return head.printAll();
  }
}
