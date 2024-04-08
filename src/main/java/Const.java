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
  public static final String ERROR_NO_SUBMENU = "No submenus for this menu";
  public static final String ERROR_TRY_AGAIN = "There was an error with this, please try again";

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

  //Menu prompts
  public static final String MENU_START = "Welcome to the shop";
  public static final String MENU_GENERIC_TODO = "What would you like to do?";
  public static final String MENU_WORK = "Go to work";
  public static final String MENU_STORE = "Go to the store";
  public static final String MENU_WORKSHOP = "Go to the workshop";
  public static final String MENU_STORE_SUBMENU = "What would you like to buy?";
  public static final String MENU_TOOLS = "Tools";
  public static final String MENU_JIGS = "Jigs";
  public static final String MENU_LUMBER = "Lumber";
  public static final String MENU_TOOLS_SUBMENU = "Which tool would you like to purchase?";
  public static final String MENU_JIGS_SUBMENU = "Which jig would you like to buy?";
  public static final String MENU_LUMBER_SUBMENU = "What wood do you want to buy?";
  public static final String MENU_PLYWOOD = "Plywood";
  public static final String MENU_DIMENSIONAL = "Dimensional";
  public static final String MENU_CUT = "Cut wood";
  public static final String MENU_BUILD_FURNITURE = "Build furniture";
  public static final String MENU_CUT_SUBMENU = "Which piece would you like to cut?";
  public static final String MENU_CUT_TOOL_SUBMENU = "Which tool would you like to use?";
  public static final String MENU_CUT_JIG_SUBMENU = "Which jig would you like to use?";
  public static final String MENU_CUT_DIMENSION_SUBMENU = "What is the dimension you want to cut it to?";
  public static final String MENU_BUILD_FURNITURE_SUBMENU = "What would you like to build?";
  public static final String MENU_SEE_INVENTORY = "See inventory";
  public static final String MENU_SHOW_WOOD = "Current wood inventory:";
  public static final String MENU_CHOOSE_WOOD = "Which piece do you want to cut?";
}
