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
  private JLabel display, accountDisplay, chooseToolLabel, chooseJigLabel, chooseWoodLabel, chooseDimLabel, chooseFurnitureLabel;
  private JTextArea toolDisplay, jigDisplay, woodDisplay, furnitureDisplay, blueprintDisplay;
  private JButton exitButton, goToWork, buyPlywood, buyDimensional, buyTool, buyJig, cutWood, makeFurniture;
  private JTextField inputTool, inputWood, inputJig, inputFurniture, inputDimension;

  public WorkshopView(String caption){
    super(caption);

    setSize(1200, 800);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel accountPanel = new JPanel();
    JPanel toolDisplayPanel = new JPanel();
    JPanel jigDisplayPanel = new JPanel();
    JPanel woodDisplayPanel = new JPanel();
    JPanel storePanel = new JPanel();
    JPanel buyToolPanel = new JPanel();
    JPanel buyJigPanel = new JPanel();
    JPanel workshopPanel = new JPanel();
    JPanel blueprintDisplayPanel = new JPanel();
    JPanel makeFurniturePanel = new JPanel();
    JPanel createdFurniturePanel = new JPanel();
    JPanel exitPanel = new JPanel();

    this.setLayout(new GridLayout(3, 4, 0, 0));

    // Make all the labels
    display = new JLabel("Welcome to the Woodshop");
    accountDisplay = new JLabel("Account Balance: ");
    chooseToolLabel = new JLabel("Enter tool index");
    chooseJigLabel = new JLabel("Enter jig index");
    chooseWoodLabel = new JLabel("Enter wood index");
    chooseDimLabel = new JLabel("Enter dimension");
    chooseFurnitureLabel = new JLabel("Enter furniture index");

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
    toolDisplayPanel.add(toolDisplay);

    // Add jig display
    jigDisplay = new JTextArea("Jig Inventory");
    jigDisplayPanel.add(jigDisplay);

    // Add wood display
    woodDisplay = new JTextArea("Wood Inventory");
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


    // buy tool
    // input field tool
    buyToolPanel.add(chooseToolLabel);
    inputTool = new JTextField(2);
    buyToolPanel.add(inputTool);
    buyTool = new JButton("Buy tool");
    buyTool.setActionCommand("buyTool");
    buyToolPanel.add(buyTool);


    //buy Jig panel
    // input field jig
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

    blueprintDisplay = new JTextArea("Furniture available to Make");
    blueprintDisplay.setLineWrap(true);
    blueprintDisplayPanel.add(blueprintDisplay);


    //make furniture
    // input field furniture
    makeFurniturePanel.add(chooseFurnitureLabel);
    inputFurniture = new JTextField(2);
    makeFurniturePanel.add(inputFurniture);
    makeFurniture = new JButton("Make Furniture");
    makeFurniture.setActionCommand("makeFurniture");
    makeFurniturePanel.add(makeFurniture);

    // made furniture display
    furnitureDisplay = new JTextArea("Made furniture");
    createdFurniturePanel.add(furnitureDisplay);

    //exit button
    exitButton = new JButton("Exit");
    exitButton.setActionCommand("exit");
    exitPanel.add(exitButton);

    // pack();

    this.add(accountPanel);
    this.add(toolDisplayPanel);
    this.add(jigDisplayPanel);
    this.add(woodDisplayPanel);
    this.add(storePanel);
    this.add(buyToolPanel);
    this.add(buyJigPanel);
    this.add(workshopPanel);
    this.add(blueprintDisplayPanel);
    this.add(makeFurniturePanel);
    this.add(createdFurniturePanel);
    this.add(exitPanel);

    setVisible(true);
  }

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

  private int getInputField(JTextField field) {

    String input = field.getText();
    if (input.isBlank()){
      return -1;
    }
    return Integer.parseInt(input);
  }

  @Override
  public int getToolField(){
    return getInputField(inputTool);
  }

  @Override
  public int getJigField(){
    return getInputField(inputJig);
  }

  @Override
  public int getWoodField(){
    return getInputField(inputWood);
  }

  @Override
  public double getDimensionField(){
    String input = inputDimension.getText();
    return Double.parseDouble(input);
  }

  @Override
  public int getFurnitureField(){
    return getInputField(inputFurniture);
  }

  private void setInputField(JTextField field, String s){
    field.setText(s);
  }

  @Override
  public void clearInputFields() {
    setInputField(inputTool, "");
    setInputField(inputJig, "");
    setInputField(inputWood, "");
    setInputField(inputFurniture, "");
    setInputField(inputDimension, "");
  }

  @Override
  public void showAll(int number, ADTList<Tool> tools, ADTList<Jig> jigs, ADTList<Wood> wood, ADTList<Furniture> furniture, ADTList<Furniture> blueprints) {
    this.accountDisplay.setText("Account Balance: " + Integer.toString(number));
    this.toolDisplay.setText("Tools: \n" + tools);
    this.jigDisplay.setText("Jigs: \n" + jigs.toString());
    this.woodDisplay.setText("Wood: \n" + wood.toString());
    this.furnitureDisplay.setText("Furniture: \n" + furniture.toString());
    this.blueprintDisplay.setText("Furniture available to make: \n" + blueprints.toString());
    }
}
