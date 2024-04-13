/**
 * Benjamin Northrop
 * CS5004
 * Final Project
 * SP2024
 *
 * This class is the View of the MVC Viewer model of the workshop game. It displays everything in a
 * grid and takes inputs based on text fields and buttons.
 */

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WorkshopView<T> extends JFrame implements IView<T>{
  private JLabel display, accountDisplay, chooseToolLabel, chooseJigLabel, chooseWoodLabel, chooseDimLabel, chooseFurnitureLabel, messageDisplayLabel;
  private JTextArea toolDisplay, jigDisplay, woodDisplay, furnitureDisplay, blueprintDisplay, messageDisplay;
  private JButton exitButton, goToWork, buyPlywood, buyDimensional, buyTool, buyJig, cutWood, makeFurniture;
  private JTextField inputTool, inputWood, inputJig, inputFurniture, inputDimension;

  /**
   * Constructor for the View. Creates the frame, sets the size, then initializes all of the buttons
   * and listeners.
   * @param caption
   */
  public WorkshopView(String caption){
    super(caption);

    // Initialize the frame
    setSize(1200, 800);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Initialize the 12 panels to be arranged
    JPanel accountPanel = new JPanel();
    JPanel toolDisplayPanel = new JPanel();
    JPanel jigDisplayPanel = new JPanel();
    JPanel woodDisplayPanel = new JPanel();
    JPanel storePanel = new JPanel();
    JPanel buyToolPanel = new JPanel();
    JPanel buyJigPanel = new JPanel();
    JPanel workshopPanel = new JPanel();
    JPanel blueprintDisplayPanel = new JPanel();
    JPanel createdFurniturePanel = new JPanel();
    JPanel messagePanel = new JPanel();
    JPanel exitPanel = new JPanel();

    // Arrange the panels into a 3x4 grid
    this.setLayout(new GridLayout(3, 4, 0, 0));

    // Make all the labels
    display = new JLabel("Welcome to the Woodshop");
    accountDisplay = new JLabel("Account Balance: ");
    chooseToolLabel = new JLabel("Enter tool index");
    chooseJigLabel = new JLabel("Enter jig index");
    chooseWoodLabel = new JLabel("Enter wood index");
    chooseDimLabel = new JLabel("Enter dimension");
    chooseFurnitureLabel = new JLabel("Enter furniture index");
    messageDisplayLabel = new JLabel("Message: ");

    // Add to account panel
    accountPanel.add(display);
    accountPanel.add(accountDisplay);
    //go to work button
    goToWork = new JButton("Go to Work");
    goToWork.setActionCommand("goToWork");
    accountPanel.add(goToWork);

    // Add to tool panel
    toolDisplay = new JTextArea("Tool Inventory:");
    toolDisplay.setLineWrap(true);
    toolDisplay.setPreferredSize(new Dimension(250, 250));
    toolDisplayPanel.add(toolDisplay);

    // Add jig display
    jigDisplay = new JTextArea("Jig Inventory");
    jigDisplay.setPreferredSize(new Dimension(250, 250));
    jigDisplayPanel.add(jigDisplay);

    // Add wood display
    woodDisplay = new JTextArea("Wood Inventory");
    woodDisplay.setPreferredSize(new Dimension(250, 250));
    woodDisplayPanel.add(woodDisplay);

    // Add store interface - ply and dimensional
    buyPlywood = new JButton("Buy Plywood");
    buyPlywood.setActionCommand("buyPlywood");
    storePanel.add(buyPlywood);
    //buy dimensional
    buyDimensional = new JButton("Buy dimensional (2x4)");
    buyDimensional.setActionCommand("buyDimensional");
    storePanel.add(buyDimensional);
    storePanel.setLayout(new BoxLayout(storePanel, BoxLayout.Y_AXIS));

    // Create buy tool panel
    buyToolPanel.add(chooseToolLabel);
    inputTool = new JTextField(2);
    buyToolPanel.add(inputTool);
    buyTool = new JButton("Buy tool");
    buyTool.setActionCommand("buyTool");
    buyToolPanel.add(buyTool);

    //buy Jig panel
    buyJigPanel.add(chooseJigLabel);
    inputJig = new JTextField(2);
    buyJigPanel.add(inputJig);
    buyJig = new JButton("Buy jig");
    buyJig.setActionCommand("buyJig");
    buyJigPanel.add(buyJig);

    //Use workshop panel
    workshopPanel.add(chooseWoodLabel);
    inputWood = new JTextField(2);
    workshopPanel.add(inputWood);
    workshopPanel.add(chooseDimLabel);
    inputDimension = new JTextField(4);
    workshopPanel.add(inputDimension);
    cutWood = new JButton("Cut wood");
    cutWood.setActionCommand("cutWood");
    workshopPanel.add(cutWood);

    // Blueprint panel
    blueprintDisplay = new JTextArea("Furniture available to Make");
    blueprintDisplay.setLineWrap(true);
    blueprintDisplay.setPreferredSize(new Dimension(250, 250));
    blueprintDisplayPanel.add(blueprintDisplay);
    blueprintDisplayPanel.add(chooseFurnitureLabel);
    inputFurniture = new JTextField(2);
    blueprintDisplayPanel.add(inputFurniture);
    makeFurniture = new JButton("Make Furniture");
    makeFurniture.setActionCommand("makeFurniture");
    blueprintDisplayPanel.add(makeFurniture);

    // created furniture panel
    furnitureDisplay = new JTextArea("Made furniture");
    furnitureDisplay.setPreferredSize(new Dimension(250, 250));
    createdFurniturePanel.add(furnitureDisplay);

    //make furniture panel
    messageDisplay = new JTextArea("Message");
    messageDisplay.setLineWrap(true);
    messageDisplay.setPreferredSize(new Dimension(250, 250));
    messagePanel.add(messageDisplay);

    //exit button
    exitButton = new JButton("Exit");
    exitButton.setActionCommand("exit");
    exitPanel.add(exitButton);

    // Add all the panels in the correct order
    this.add(accountPanel);
    this.add(toolDisplayPanel);
    this.add(jigDisplayPanel);
    this.add(woodDisplayPanel);
    this.add(storePanel);
    this.add(buyToolPanel);
    this.add(buyJigPanel);
    this.add(workshopPanel);
    this.add(blueprintDisplayPanel);
    this.add(createdFurniturePanel);
    this.add(messagePanel);
    this.add(exitPanel);

    // Set the panel to visible
    setVisible(true);
  }

  /**
   * Sets all the listeners to connect actions to buttons.
   * @param click
   */
  @Override
  public void setListener(ActionListener click) {
    this.goToWork.addActionListener(click);
    this.buyPlywood.addActionListener(click);
    this.buyDimensional.addActionListener(click);
    this.buyTool.addActionListener(click);
    this.buyJig.addActionListener(click);
    this.cutWood.addActionListener(click);
    this.makeFurniture.addActionListener(click);
    this.exitButton.addActionListener(click);
  }

  /**
   * Gets the input from a given field.
   * @param field the input field to get data from
   * @return the integer from the data field.
   */
  private int getInputField(JTextField field) {

    String input = field.getText();
    if (input.isBlank()){
      return -1;
    }
    return Integer.parseInt(input);
  }

  /**
   * gets the input from the tool field
   * @return the provided int.
   */
  @Override
  public int getToolField(){
    return getInputField(inputTool);
  }

  /**
   * Gets the input from the jig field
   * @return the provided int
   */
  @Override
  public int getJigField(){
    return getInputField(inputJig);
  }

  /**
   * Gets the input from the wood field
   * @return the provided int.
   */
  @Override
  public int getWoodField(){
    return getInputField(inputWood);
  }

  /**
   * gets the input from the dimensions field
   * @return the provided dimension
   */
  @Override
  public double getDimensionField(){
    String input = inputDimension.getText();
    return Double.parseDouble(input);
  }

  /**
   * gets the input from the furniture field
   * @return the provided input.
   */
  @Override
  public int getFurnitureField(){
    return getInputField(inputFurniture);
  }

  /**
   * Sets all the inputs to a given string.
   * @param field the input to set.
   * @param s the string to insert.
   */
  private void setInputField(JTextField field, String s){
    field.setText(s);
  }

  @Override
  public void displayMessage(String s){
    messageDisplay.setText(s);
  }

  /**
   * Clears all the input fields to prepare it for the next set of data
   */
  @Override
  public void clearInputFields() {
    setInputField(inputTool, "");
    setInputField(inputJig, "");
    setInputField(inputWood, "");
    setInputField(inputFurniture, "");
    setInputField(inputDimension, "");
  }

  /**
   * Shows all the data provided onto the display.
   * @param number the account balance
   * @param tools the list of tools
   * @param jigs the list of jigs
   * @param wood the list of wood
   * @param furniture the list of furniture
   * @param blueprints the list of blueprints
   */
  @Override
  public void showAll(int number, IADT<Tool> tools, IADT<Jig> jigs, IADT<Wood> wood, IADT<Furniture> furniture, IADT<Furniture> blueprints) {
    this.accountDisplay.setText("Account Balance: " + Integer.toString(number));
    this.toolDisplay.setText("Tools: \n" + tools);
    this.jigDisplay.setText("Jigs: \n" + jigs.toString());
    this.woodDisplay.setText("Wood: \n" + wood.toString());
    this.furnitureDisplay.setText("Furniture: \n" + furniture.toString());
    this.blueprintDisplay.setText("Furniture available to make: \n" + blueprints.toString());
    }
}
