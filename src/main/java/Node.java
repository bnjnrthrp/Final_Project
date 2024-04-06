/** Benjamin Northrop CS5004 / Sp 2024 Lab 4 3/15/24 */

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This class represents a generic node holding data
 *
 * @param <T> the data held within the node.
 */
public class Node<T> implements iNode<T> {

  private T data;
  private iNode<T> nextNode;

  /** Basic constructor, creates a node given the data and the next node to which it should point */
  public Node(T data, iNode<T> nextNode) {
    this.data = data;
    this.nextNode = nextNode;
  }

  /**
   * Gets the node at a given index within a linked list.
   *
   * @param index int, the index we want
   * @return T generic object, whatever data is inside the node.
   */
  @Override
  public T get(int index) {
    if (index == 0) {
      return this.data;
    }
    return (T) this.nextNode.get(index - 1);
  }

  /**
   * Gets the node that this node points to.
   * @return the next node.
   */
  @Override
  public iNode<T> getNext(){
    return this.nextNode;
  }

  /**
   * Sets the next node to a provided node.
   * @param nextNode The new node to connected to the list.
   */
  @Override
  public void setNextNode(iNode<T> nextNode){
    this.nextNode = nextNode;
  }

  /**
   * Adds a node to the front of the current node
   *
   * @param data the data to add to the new node
   * @return the newly created node
   */
  @Override
  public iNode<T> addFront(T data) {
    return new Node<T>(data, this);
  }

  /**
   * Adds a node to the back of the list.
   *
   * @param data the data to add to the list
   * @return the newly created node
   */
  @Override
  public iNode<T> addBack(T data) {
    this.nextNode = this.nextNode.addBack(data);
    return this;
  }

  /**
   * Adds a node to the back of the list.
   * @param data
   * @return
   */
  @Override
  public iNode<T> add(T data){
    return this.addBack(data);
  }

  /**
   * Adds a node at a given index.
   *
   * @param data the data to add to the node.
   * @param index the index at which we want to insert the node.
   * @return the newly created node.
   */
  @Override
  public iNode<T> add(T data, int index) {
    if (index == 0) {
      return addFront(data);
    } else {
      this.nextNode = this.nextNode.add(data, --index);
      return this;
    }
  }

  /**
   * Adds the head of a new list to the back of the rest of the list.
   * @param head the head of the new list to add
   */
  @Override
  public void addAll(iNode<T> head){
    if (this.count() == 1) {
      this.nextNode = head;
    } else {
      this.nextNode.addAll(head);
    }
  }

  /**
   * Remove a task node matching the given object.
   *
   * @return the removed Task node
   */
  @Override
  public iNode<T> remove(T data) {
    if (this.data.equals(data)) {
      return this.nextNode;
    } else {
      this.nextNode = this.nextNode.remove(data);
      return this;
    }
  }

  /**
   * Remove a node given an index of the position
   * @param index the index of the node to remove
   * @return the removed task Node
   * @throws IndexOutOfBoundsException if the index is <0
   */
  @Override
  public iNode<T> remove(int index) throws IndexOutOfBoundsException{
    if (index < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (index == 0){
      return this.nextNode;
    } else {
      this.nextNode = this.nextNode.remove(index - 1);
      return this;
    }
  }

  /**
   * Gets the size of the linked list by counting the nodes.
   *
   * @return int, the size of the list.
   */
  @Override
  public int count() {
    return 1 + nextNode.count();
  }

  /**
   * Counts the number of nodes that pass the predicate test
   * @param tester Predicate, the test that we're trying to count
   * @return int, the number of nodes that match the criteria
   */
  @Override
  public int count(Predicate<T> tester){
    if (tester.test((T) data)){
      return 1 + nextNode.count(tester);
    } else {
      return nextNode.count(tester);
    }
  }

  /** Gets the nodes that pass the predicate test */
  @Override
  public <T> iNode<T> filter(Predicate<T> tester) {
    if (tester.test((T) this.data)) {
      return new Node<T>((T) this.data, nextNode.filter(tester));
    } else {
      return nextNode.filter(tester);
    }
  }

  /**
   * Applies a converter function to the node to transform the data and return a new type of node
   * @param converter function, the converting function
   * @return An iNode of type R
   * @param <R> The return type of the converter function
   */
  @Override
  public <R> iNode<R> map(Function<T,R> converter){
    return new Node<R>(
        converter.apply(this.data),
        this.nextNode.map(converter));
  }

  /**
   * Prints the node data
   *
   * @return String, the data within the node
   */
  @Override
  public String toString() {
    return this.data.toString();
  }

  /**
   * Prints both the current node data and all the subsequent node data
   *
   * @return returns the data of the node chain.
   */
  @Override
  public String printAll() {
    return this.data.toString() + ", " + this.nextNode.printAll();
  }
}


