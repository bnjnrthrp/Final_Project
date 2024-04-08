import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;


public class TreeNode<T> extends AbstractTreeNode<T> {
  protected List<ITreeNode<T>> children;

  public TreeNode(T data){
    super(data);
    this.children = new ArrayList<ITreeNode<T>>();
  }

  @Override
  public ITreeNode<T> addChild(Predicate<T> identifier, ITreeNode<T> child) {
    if (identifier.test(this.data)){
      this.children.add(child);
      return this;
    }
    for (int i = 0; i < this.children.size(); i++){
      this.children.set(
          i,
          this.children.get(i).addChild(identifier, child));
    }
    return this;
  }

  @Override
  public List<T> toList() {
    List<T> result = new ArrayList<T>();
    result.add(this.data);
    for (ITreeNode<T> child: children) {
      result.addAll(child.toList());
    }
    return result;
  }

  @Override
  public ArrayList<T> getChildren(){
    return (ArrayList<T>) this.children;
  }


}
