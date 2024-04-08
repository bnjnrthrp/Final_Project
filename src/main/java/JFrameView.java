import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.lang.StringBuilder;

public class JFrameView<T> extends JFrame implements IView<T>{
  private JLabel display, accountDisplay, toolDisplay, jigDisplay, woodDisplay, furnitureDisplay;
  private JButton exitButton, goToWork, buyWood, buyDimensional, buyTool, buyJig, cutWood, makeFurniture;
  private JTextField inputTool, inputWood, inputJig, inputFurniture;

  public JFrameView(String caption){
    super(caption);

    setSize(500, 300);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel accountPanel = new JPanel();
    JPanel storePanel = new JPanel();
    JPanel toolPanel = new JPanel();
    JPanel jigPanel = new JPanel();
    JPanel workshopPanel = new JPanel();
    JPanel exitPanel = new JPanel();


//    this.setLayout(new GridLayout(5, 3));

    display = new JLabel("Welcome to the Woodshop");
    accountDisplay = new JLabel("Account Balance");
    toolDisplay = new JLabel("Tool Inventory:");
    jigDisplay = new JLabel("Jig Inventory");
    woodDisplay = new JLabel("Wood Inventory");
    furnitureDisplay = new JLabel("Furniture available to Make");
    accountPanel.add(display);
    accountPanel.add(accountDisplay);
//    this.add(display);
//    this.add(accountDisplay);
    toolPanel.add(toolDisplay);
    jigPanel.add(jigDisplay);
    //go to work button

    goToWork = new JButton("Go to Work");
    goToWork.setActionCommand("goToWork");
    accountPanel.add(goToWork);

    //buy plywood
    buyWood = new JButton("Buy Plywood");
    buyWood.setActionCommand("buyPlywood");
    storePanel.add(buyWood);

    inputWood = new JTextField(2);
    storePanel.add(inputWood);


    //buy dimensional
    buyDimensional = new JButton("Buy dimensional (2x4)");
    buyDimensional.setActionCommand("buyDimensional");
    storePanel.add(buyDimensional);

    //buy tool

    buyTool = new JButton("Buy tool");
    buyTool.setActionCommand("buyTool");
    storePanel.add(buyTool);

    // input field tool
    inputTool = new JTextField(2);
    storePanel.add(inputTool);


    //buy Jig

    buyJig = new JButton("Buy jig");
    buyJig.setActionCommand("buyJig");
    storePanel.add(buyJig);

    // input field jig
    inputJig = new JTextField(2);
    storePanel.add(inputJig);

    this.add(woodDisplay);
    cutWood = new JButton("Cut wood");
    cutWood.setActionCommand("cutWood");
    workshopPanel.add(cutWood);




    //make furniture

    makeFurniture = new JButton("Make Furniture");
    makeFurniture.setActionCommand("makeFurniture");
    workshopPanel.add(makeFurniture);

    // input field furniture
    inputFurniture = new JTextField(2);
    workshopPanel.add(inputFurniture);


    //exit button
    exitButton = new JButton("Exit");
    exitButton.setActionCommand("Exit Button");
    exitPanel.add(exitButton);
    workshopPanel.add(furnitureDisplay);
    // pack();

    this.setLayout(new GridLayout(1, 6));

    this.add(accountPanel);
    this.add(storePanel);
    this.add(workshopPanel);
    this.add(toolPanel);
    this.add(jigPanel);
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
    this.accountDisplay.setText(Integer.toString(number));
    this.toolDisplay.setText(tools.toString());
    this.jigDisplay.setText(jigs.toString());
    this.woodDisplay.setText(wood.toString());
    this.furnitureDisplay.setText(furniture.toString());
    }
}
