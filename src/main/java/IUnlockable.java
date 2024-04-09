/**
 * Benjamin Northrop
 * CS5004
 * Final Project
 * SP2024
 *
 * This interface represents the actions available to an item that must be unlocked to be used.
 */

public interface IUnlockable {
  boolean isUnlocked();
  void unlock();
  int getValue();
}
