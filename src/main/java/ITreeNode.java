import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public interface ITreeNode<T> {
  ITreeNode<T> addChild(Predicate<T> identifier, ITreeNode<T> child);
  List<T> toList();
  ArrayList<T> getChildren();
  ITreeNode<T> getChild(int index);

  T getData();
}
