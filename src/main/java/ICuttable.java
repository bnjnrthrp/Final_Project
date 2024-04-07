public interface ICuttable<T> {
  ADTList<T> cut(int sideIndex, double newDimension, boolean accurate);
}
