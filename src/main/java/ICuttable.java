/**
 * Benjamin Northrop
 * CS5004
 * Final Project
 * SP2024
 */

public interface ICuttable<T> {
  ADTList<T> cut(int sideIndex, double newDimension, boolean accurate);
}
