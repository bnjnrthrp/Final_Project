/**
 * Benjamin Northrop
 * CS5004
 * Final Project
 * SP2024
 *
 * This interface is for any tool that can cut wood, such as power saws, hand saws, chisels, etc.
 */

public interface ICuttingTool {
  ADTList<Wood> cut(Wood wood, double size);
  ADTList<Wood> cut(Wood wood, Jig jig, double size);
}
