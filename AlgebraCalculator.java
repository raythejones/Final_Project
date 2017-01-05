import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AlgebraCalculator extends JFrame{

    private Container algPane;
    //Initialize the TextFields in order to put expressions 
    private JTextField inputRight;
    private JTextField inputLeft;
    private JTextField output;
    // Button that computes the value of x(requires boolean)
    private JButton compute;
    Boolean compute=false;
    // Creates the Pane/Tab
    public AlgebraCalculator(){
	this.setTitle("Algebraic Calculator");
	//Might not need if we are doing tabs?
	this.setSize(500,800);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	Jpanel algPanel = new JPanel();
	algPanel.setLayout(new FlowLayout());
	algPanel.add(inputRight= new JTextField(20));
  inputRight.setHorizontalAlignment(JTextField.RIGHT);
	inputRight.setEditable(true);
	algPanel.add(inputLeft=new JTextField(20));
	inputLeft.setEditable(true);
	algPanel.add(output= new JTextField(20));
	output.setEditable(false);

	inputRight.addActionListener(new ListenInputRight);
	inputLeft.addActionListener(new ListenInputLeft);
	compute.addActionListener(new ListenCompute);
    }
}
class ListenInputRight implements ActionListener{
    public void actionPerformed(ActionEvent i){
	
    }
}
class ListenInputLeft implements ActionListener{
    public void actionPerformed(actionEvent i){

    }
}
class ListenCompute implements ActionListener{
    public void ActionPerformed(actionEvent i){
	
    }
}
public static void main(String[] args){
    AlgebraCalculator x = new AlgebraCalculator();
    x.setVisible(true);
    x.setResizable(false);
}
