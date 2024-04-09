/**
 * Benjamin Northrop
 * CS5004 Final
 * This class represents all the constants used throughout the program.
 */
public class Const {
  //Errors
  public static final String ERROR_NON_POSITIVE_MEASUREMENT = "Measurement cannot be negative.";
  public static final String ERROR_NON_POSITIVE_VALUE = "Value cannot be negative.";
  public static final String ERROR_INVALID_SIZE = "Measurement must be greater than 0 and less than the measurement of the board";
  public static final String ERROR_INVALID_INDEX = "Index provided is outside range of array";
  public static final String ERROR_DIMENSION_OOB = "New dimension cannot be larger than the original";
  public static final String ERROR_INSUFFICIENT_WOOD = "Not enough wood components to create furniture";
  public static final String ERROR_INCOMPATIBLE_CUTTABLE_SHAPE = "Cannot cut this shape on this tool";
  public static final String ERROR_INCOMPATIBLE_JIG = "Jig not compatible with this tool";
  public static final String ERROR_INCOMPATIBLE_WOOD = "This wood isn't compatible with this tool";
  public static final String ERROR_TOOL_LOCKED = "This item is still locked";
  public static final String ERROR_INSUFFICIENT_FUNDS = "Not enough funds in account balance";

  //Standard Dimensions
  public static final double LENGTH_PLYWOOD = 96;
  public static final double LENGTH_DIMENSIONAL = 96;
  public static final double WIDTH_PLYWOOD = 48;
  public static final double WIDTH_DIMENSIONAL = 4;
  public static final double THICKNESS_PLYWOOD = .75;
  public static final double THICKNESS_DIMENSIONAL = 2;

  public static final double[] TABLE_LEGS = {30, 2, 2};
  public static final double[] TABLE_TOP = {60, 36, .75};
  public static final double[] STOOL_LEGS = {13, 1, 2};
  public static final double[] STOOL_SEAT = {15, 6, .75};
  public static final double[] CHAIR_FRONT_LEGS = {18, 1, 2};
  public static final double[] CHAIR_BACK_LEGS = {40, 1, 2};
  public static final double[] CHAIR_SEAT = {15, 15, .75};
  public static final int TABLE_NUM_LEGS = 4;
  public static final int TABLE_NUM_TOPS = 1;
  public static final int STOOL_NUM_LEGS = 3;
  public static final int STOOL_NUM_SEATS = 1;
  public static final int CHAIR_NUM_FRONT_LEGS = 2;
  public static final int CHAIR_NUM_BACK_LEGS = 2;
  public static final int CHAIR_NUM_SEATS = 1;

  public static final String table = "table";
  public static final String chair = "chair";
  public static final String stool = "stool";

  //Standard values
  public static final int VALUE_JIG_CROSSCUT_SLED = 100;
  public static final int VALUE_JIG_TAPE_MEASURE = 10;
  public static final int VALUE_TOOL_TABLE_SAW = 250;
  public static final int VALUE_TOOL_MITER_SAW = 150;
  public static final int VALUE_WOOD_STANDARD_PLY = 40;
  public static final int VALUE_WOOD_STANDARD_2X4 = 10;

}
