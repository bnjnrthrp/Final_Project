import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.lang.StringBuilder;
import javax.swing.ScrollPaneLayout;

public class JFrameView<T> extends JFrame implements IView<T>{
  private JLabel display, accountDisplay;
  private JTextArea toolDisplay, jigDisplay, woodDisplay, furnitureDisplay;;
  private JButton exitButton, goToWork, buyWood, buyDimensional, buyTool, buyJig, cutWood, makeFurniture;
  private JTextField inputTool, inputWood, inputJig, inputFurniture, inputDimension;

  public JFrameView(String caption){
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
    JPanel furnitureDisplayPanel = new JPanel();
    JPanel makeFurniturePanel = new JPanel();
    JPanel createdFurniturePanel = new JPanel();
    JPanel exitPanel = new JPanel();

    this.setLayout(new GridLayout(3, 4, 0, 0));

//    accountPanel.setLayout(new GridLayout(3, 0));
    // Add to account panel
    display = new JLabel("Welcome to the Woodshop");
    accountPanel.add(display);
    accountDisplay = new JLabel("Account Balance: ");
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


    // Add store interface - ply and idmensional
    buyWood = new JButton("Buy Plywood");
    buyWood.setActionCommand("buyPlywood");
    storePanel.add(buyWood);
    //buy dimensional
    buyDimensional = new JButton("Buy dimensional (2x4)");
    buyDimensional.setActionCommand("buyDimensional");
    storePanel.add(buyDimensional);
    storePanel.setLayout(new BoxLayout(storePanel, BoxLayout.Y_AXIS));


    // buy tool
    // input field tool
    inputTool = new JTextField(2);
    buyToolPanel.add(inputTool);
    buyTool = new JButton("Buy tool");
    buyTool.setActionCommand("buyTool");
    buyToolPanel.add(buyTool);


    //buy Jig panel
    buyJig = new JButton("Buy jig");
    buyJig.setActionCommand("buyJig");
    buyJigPanel.add(buyJig);
    // input field jig
    inputJig = new JTextField(2);
    buyJigPanel.add(inputJig);


    //Use workshop panel

    inputWood = new JTextField(2);
    workshopPanel.add(inputWood);
    inputDimension = new JTextField(4);
    workshopPanel.add(inputDimension);
    cutWood = new JButton("Cut wood");
    cutWood.setActionCommand("cutWood");
    workshopPanel.add(cutWood);

    furnitureDisplay = new JTextArea("Furniture available to Make");
    furnitureDisplayPanel.add(furnitureDisplay);


    //make furniture
    // input field furniture
    inputFurniture = new JTextField(2);
    workshopPanel.add(inputFurniture);
    makeFurniture = new JButton("Make Furniture");
    makeFurniture.setActionCommand("makeFurniture");
    makeFurniturePanel.add(makeFurniture);

    // made furniture display
    furnitureDisplay = new JTextArea("Made furniture");
    furnitureDisplayPanel.add(furnitureDisplay);
    createdFurniturePanel.add(furnitureDisplay);

    //exit button
    exitButton = new JButton("Exit");
    exitButton.setActionCommand("Exit Button");
    exitPanel.add(exitButton);
    workshopPanel.add(furnitureDisplay);
    // pack();

    this.add(accountPanel);
    this.add(toolDisplayPanel);
    this.add(jigDisplayPanel);
    this.add(woodDisplayPanel);
    this.add(storePanel);
    this.add(buyToolPanel);
    this.add(buyJigPanel);
    this.add(workshopPanel);
    this.add(furnitureDisplayPanel);
    this.add(makeFurniturePanel);
    this.add(createdFurniturePanel);
    this.add(exitPanel);

    setVisible(true);
  }

  @Override
  public void showADTList(ADTList list) {

  }

  @Override
  public void showString(String str) {

  }

  @Override
  public void setListener(ActionListener click) {
    this.goToWork.addActionListener(click);
    this.exitButton.addActionListener(click);
    this.buyWood.addActionListener(click);
    this.buyWood.addActionListener(click);
    this.buyDimensional.addActionListener(click);
    this.buyTool.addActionListener(click);
    this.buyJig.addActionListener(click);
    this.makeFurniture.addActionListener(click);
  }

  @Override
  public int getInputField(JTextField field) {
    String input = field.getText();
    return Integer.getInteger(input);
  }

  @Override
  public void clearInputFields() {

  }

  @Override
  public void showMenu(Menu menu) {

  }

  @Override
  public void showList(List list) {

  }

  @Override
  public void showOptions(Menu menu) {

  }

  @Override
  public void showInt(int num) {

  }

  @Override
  public void showError(Exception e) {

  }

  @Override
  public void cueInput() {

  }

  @Override
  public void display() {
    this.setVisible(true);
  }

  @Override
  public String ADTListToString(ADTList<T> list){
    return null;
  }

  @Override
  public void showAll(int number, ADTList<Tool> tools, ADTList<Jig> jigs, ADTList<Wood> wood, ADTList<Furniture> furniture) {
    this.accountDisplay.setText("Account Balance: " + Integer.toString(number));
    this.toolDisplay.setText("Tools: \n" + tools);
    this.jigDisplay.setText("Jigs: \n" + jigs.toString());
    this.woodDisplay.setText("Wood: \n" + wood.toString());
    this.furnitureDisplay.setText("Furniture :" + furniture.toString());
    }
}
