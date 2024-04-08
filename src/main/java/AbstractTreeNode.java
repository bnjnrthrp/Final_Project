import java.util.ArrayList;

/**
 * Provides the blueprint for a basic tree node/tree structure for the menu.
 * @param <T>
 */

public abstract class AbstractTreeNode<T> implements ITreeNode<T> {
  protected T data;

  public AbstractTreeNode(T data) {this.data = data;}


  public abstract ArrayList<T> getChildren();
}
