public interface iCuttable<T> {
  ADTList<T> cut(int sideIndex, double newDimension, boolean accurate);
}
