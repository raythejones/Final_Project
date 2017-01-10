import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AlgebraCalculator extends JFrame{
    
    private Container algPane;
    //Initialize the TextFields in order to put expressions 
    private JTextField inputRight;
    private JTextField inputLeft;
    private JLabel equals;
    private JTextField output;
    private JOptionPane error;
    // Button that computes the value of x(requires boolean)
    private JButton compute;
    private String valueRight,valueLeft, solution;
    Boolean solve=false;


    // Creates the Pane/Tab

    public AlgebraCalculator(){
	this.setTitle("Algebraic Calculator");
	//Might not need if we are doing tabs?
	this.setSize(500,800);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	JPanel algPanel = new JPanel();
	algPanel.setLayout(new FlowLayout());
	algPanel.add(inputLeft=new JTextField(20));
	inputLeft.setEditable(true);
	JLabel equals = new JLabel("=");
	algPanel.add(inputRight= new JTextField(20));
	inputRight.setHorizontalAlignment(JTextField.RIGHT);
	inputRight.setEditable(true);
	algPanel.add(output= new JTextField(20));
	equals.setHorizontalAlignment(JLabel.CENTER);
	output.setEditable(false);
	compute= new JButton ("Compute");
	// Sets the GUI

	algPanel.add(inputLeft);
	algPanel.add(equals);
	algPanel.add(inputRight);
	algPanel.add(compute);
	algPanel.add(output);

	//Creates the GUI

	add(algPanel); 

	//Allows us to gather the information from the GUI
	compute.addActionListener(new ListenCompute());
    }


class ListenCompute implements ActionListener{
    public void actionPerformed(ActionEvent i){
	valueLeft=inputLeft.getText();
	valueRight=inputRight.getText();
	if ((isExpression(valueLeft) || isExpression(valueRight)) && isSameVar(valueRight,valueLeft)){
	    valueLeft=simplify(valueLeft);
	    valueRight=simplify(valueRight);

	    /* //for polynoymials
	       if (isExpo(valueLeft) || isExpo(valueRight)){
	           solvepoly(valueLeft
	       }
	       else{
	    */

	    solution=(solve(valueLeft, valueRight));
	    output.setText(solution);
	    inputLeft.setText("");
	    inputRight.setText("");
	}
	else{
	    JOptionPane error = new JOptionPane("A valid expression must be inputed in both sides of the equation, as well as the same variable.", JOptionPane.ERROR_MESSAGE);
	    JDialog message = error.createDialog("InvalidInputException");
	    message.setAlwaysOnTop(true);
	    message.setVisible(true);
	}
    }
    
    // Checks to see if the query string is an expression (not working as of yet)

    public boolean isExpression(String value){
	if (value.equals("")){
	    return false;
	}
	char var=';'; // No such thing as empty char, so an obscure char should work
	for (int x=0; x<value.length();x++){
	    if (Character.isLetter(value.charAt(x))){
		if(var==';'){
		    var=value.charAt(x);
		}
		else if (var!=value.charAt(x)){
			return false;
		    }
		// Need to implement a method to only have one variable only, possibly in isExpression

	    }
	}
	if (var==';'){
	    return false;
	}
	else{
	    return true;
	}
    }
    
    //Checks to see if the same variable is used

    public boolean isSameVar(String exp1, String exp2){
	char var1='/'; //needs to be instantiated 
	char var2='[';
	for (int x=0; x<exp1.length(); x++){
	    if(Character.isLetter(exp1.charAt(x))){
		var1=exp1.charAt(x);
	    }
	}
	for (int x=0; x<exp2.length()&& hasLetter(exp2); x++){
	    if(Character.isLetter(exp2.charAt(x))){
		var2=exp2.charAt(x);
	    }
	}
	if  (var1 == var2 ||
	     (hasLetter(exp1) && !hasLetter(exp2)) ||
	     (hasLetter(exp2) && !hasLetter(exp1))){
	    return true;
	}
	else{
	    return false;
	}
    }

    public boolean hasLetter(String value){
	boolean has=false;
	for (int x=0; x<value.length(); x++){
	    if(Character.isLetter(value.charAt(x))){
		has=true;
	    }
	}
	return has;
    }
    // To simplify long algebraic equations. Follows PEMDAS

    public String simplify(String value){
	//Parenthesis
	if (value.indexOf('(')>-1 || value.indexOf(')')>-1){
	    if (value.indexOf(')')==-1 || value.indexOf('(')==-1){
		JOptionPane error = new JOptionPane("Expected close parenthesis", JOptionPane.ERROR_MESSAGE);
		JDialog message = error.createDialog("ParenthesisException");
		message.setAlwaysOnTop(true);
		message.setVisible(true);
	    }
	    else{
		
	    }
	}
	/* Exponents (Not in use until on to polynomials)
	else if(value.indexOf("^")>-1){

	}
	*/
	return value;
    }
	
    //Should try to move the constants to one side keeping the variable on the other for monomials expressions, then should either divide or multiply depending on the coefficent. (Working on)

	public String solve(String exp1, String exp2){
	//Dummy Text
	return exp1;
    }
}
    
    /*
    public String solvePoly(String exp1, String exp2){
	
    }
    */

public static void main(String[] args){
    AlgebraCalculator x = new AlgebraCalculator();
    x.setVisible(true);
    x.setResizable(false);
}
}

