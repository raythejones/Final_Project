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
	if ((isExpression(valueLeft) || isExpression(valueRight)) && isSameVar(valueRight,valueLeft) && isSomething(valueLeft) && isSomething(valueRight)){
	    if (isExpo(valueLeft) || isExpo(valueRight)){
		JOptionPane error = new JOptionPane("A valid expression must be inputed in both sides of the equation, as well as the same variable.Exponent and Polynomials aren't supported. Please put a valid expression.", JOptionPane.ERROR_MESSAGE);
		JDialog message = error.createDialog("InvalidPolyException");
		message.setAlwaysOnTop(true);
		message.setVisible(true); 
	    }
	    else{
		solution=(solve(removeSpaces(valueLeft), removeSpaces(valueRight)));
		output.setText(solution);
	    }
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
    //Checks if it is a polynomial equations
    public boolean isExpo(String value){
	boolean expo=false;
	for (int x=0; x+1<value.length(); x++){
	    if ((value.substring(x,x+1)).equals("^")){
		expo=true;
	    }
	}
	return expo;
    }
    // Removes spaces to stop bugs
    public String removeSpaces(String value){
        String holder ="";
	holder=value.replace(" ", "");
	return holder;
    }
    //Makes sure something has been inputed
    public boolean isSomething(String value){
	if (value.equals("")){
	    return false;
	}
	else{
	    return true;
	}
    }
    // Checks to see if the query string is an expression

    public boolean isExpression(String value){
	char var=';'; // No such thing as empty char, so an obscure char should work
	for (int x=0; x<value.length();x++){
	    if (Character.isLetter(value.charAt(x))){
		if(var==';'){
		    var=value.charAt(x);
		}
		else if (var!=value.charAt(x)){
			return false;
		    }
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
	char var1='/';
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
      //Should try to move the constants to one side keeping the variable on the other for monomials expressions, then should either divide or multiply depending on the coefficent.
    
    public String solve(String exp1, String exp2){
	String container ="";
	boolean parse=true;
	if ((hasLetter(exp1) && !hasLetter(exp2))){
	    container = solver(exp2);
	    String num="";
	    if(exp1.indexOf('+')>-1){
		if (Character.isLetter(exp1.charAt(exp1.indexOf('+')+1))){
		    for (int x=exp1.indexOf('+')-1; parse && x>-1; x--){
			if(isNums(exp1.charAt(x))){
			    num=exp1.charAt(x)+ num;
			}
			else{
			    parse=true;
			}
		    }
		    parse=true;
		    inputRight.setText(container);
		    container=subtract(num, container);
		}
		else{
		    for (int x=exp1.indexOf('+') + 1; parse && x<exp1.length(); x++){
			if (isNums(exp1.charAt(x))){
			    num=num+exp1.charAt(x);
			}
			else{
			    parse=false;
			}
		    }
		    parse=true;
		    inputRight.setText(container);
		    container=subtract(num, container);
		}
	    }
	    num="";
	    if(exp1.indexOf('-')>-1){
		if (Character.isLetter(exp1.charAt(exp1.indexOf('-')+1))){
		    for (int x=exp1.indexOf('-')-1; parse && x>-1; x--){
			if(isNums(exp1.charAt(x))){
			    num=exp1.charAt(x)+ num;
			}
			else{
			    parse=true;
			}
		    }
		    parse=true;
		    inputRight.setText(container);
		    container=add(num, container);
		}
		else{
		    for (int x=exp1.indexOf('-') + 1; parse && x<exp1.length(); x++){
			if (isNums(exp1.charAt(x))){
			    num=num+exp1.charAt(x);
			}
			else{
			    parse=false;
			}
		    }
		    parse=true;
		    inputRight.setText(container);
		    container=add(num, container);
		}
	    }
	    num="";
	    if(exp1.indexOf('/')>-1){
		if (Character.isLetter(exp1.charAt(exp1.indexOf('/')+1))){
		    for (int x=exp1.indexOf('/')-1; parse && x>-1; x--){
			if(isNums(exp1.charAt(x))){
			    num=exp1.charAt(x)+ num;
			}
			else{
			    parse=true;
			}
		    }
		    parse=true;
		    inputRight.setText(container);
		    container=multiply(num, container);
		}
		else{
		    for (int x=exp1.indexOf('/') + 1; parse && x<exp1.length(); x++){
			if (isNums(exp1.charAt(x))){
			    num=num+exp1.charAt(x);
			}
			else{
			    parse=false;
			}
		    }
		    parse=true;
		    inputRight.setText(container);
		    container=multiply(num, container);
		}
	    }
	    num="";
	    if(exp1.indexOf('*')>-1){
		if (Character.isLetter(exp1.charAt(exp1.indexOf('*')+1))){
		    for (int x=exp1.indexOf('*')-1; parse && x>-1; x--){
			if(isNums(exp1.charAt(x))){
			    num=exp1.charAt(x)+ num;
			}
			else{
			    parse=true;
			}
		    }
		    parse=true;
		    inputRight.setText(container);
		    container=divide(num, container);
		}
		else{
		    for (int x=exp1.indexOf('*') + 1; parse && x<exp1.length(); x++){
			if (isNums(exp1.charAt(x))){
			    num=num+exp1.charAt(x);
			}
			else{
			    parse=false;
			}
		    }
		    parse=true;
		    inputRight.setText(container);
		    container=divide(num, container);
		}
	    }
	}
	
	else if ((!hasLetter(exp1) && hasLetter(exp2))){
	    String num="";
	    container= solver(exp1);
	    if(exp2.indexOf('+')>-1){
		if (Character.isLetter(exp2.charAt(exp2.indexOf('+')+1))){
		    for (int x=exp2.indexOf('+')-1; parse && x>-1; x--){
			if(isNums(exp2.charAt(x))){
			    num=exp2.charAt(x)+ num;
			}
			else{
			    parse=true;
			}
		    }
		    parse=true;
		    inputRight.setText(container);
		    container=subtract(num, container);
		}
		else{
		    for (int x=exp2.indexOf('+') + 1; parse && x<exp2.length(); x++){
			if (isNums(exp2.charAt(x))){
			    num=num+exp2.charAt(x);
			}
			else{
			    parse=false;
			}
		    }
		    parse=true;
		    inputRight.setText(container);
		    container=subtract(num, container);
		}
	    }
	    num="";
	    if(exp2.indexOf('-')>-1){
		if (Character.isLetter(exp2.charAt(exp2.indexOf('-')+1))){
		    for (int x=exp2.indexOf('-')-1; parse && x>-1; x--){
			if(isNums(exp2.charAt(x))){
			    num=exp1.charAt(x)+ num;
			}
			else{
			    parse=true;
			}
		    }
		    parse=true;
		    inputRight.setText(container);
		    container=add(num, container);
		}
		else{
		    for (int x=exp2.indexOf('-') + 1; parse && x<exp2.length(); x++){
			if (isNums(exp2.charAt(x))){
			    num=num+exp2.charAt(x);
			}
			else{
			    parse=false;
			}
		    }
		    parse=true;
		    inputRight.setText(container);
		    container=add(num, container);
		}
	    }
	    num="";
	    if(exp2.indexOf('/')>-1){
		if (Character.isLetter(exp2.charAt(exp2.indexOf('/')+1))){
		    for (int x=exp2.indexOf('/')-1; parse && x>-1; x--){
			if(isNums(exp2.charAt(x))){
			    num=exp2.charAt(x)+ num;
			}
			else{
			    parse=true;
			}
		    }
		    parse=true;
		    inputRight.setText(container);
		    container=multiply(num, container);
		}
		else{
		    for (int x=exp2.indexOf('/') + 1; parse && x<exp2.length(); x++){
			if (isNums(exp2.charAt(x))){
			    num=num+exp2.charAt(x);
			}
			else{
			    parse=false;
			}
		    }
		    parse=true;
		    inputRight.setText(container);
		    container=multiply(num, container);
		}
	    }
	    num="";
	    if(exp2.indexOf('*')>-1){
		if (Character.isLetter(exp2.charAt(exp2.indexOf('*')+1))){
		    for (int x=exp2.indexOf('*')-1; parse && x>-1; x--){
			if(isNums(exp2.charAt(x))){
			    num=exp2.charAt(x)+ num;
			}
			else{
			    parse=true;
			}
		    }
		    parse=true;
		    inputRight.setText(container);
		    container=divide(num, container);
		}
		else{
		    for (int x=exp2.indexOf('*') + 1; parse && x<exp2.length(); x++){
			if (isNums(exp2.charAt(x))){
			    num=num+exp2.charAt(x);
			}
			else{
			    parse=false;
			}
		    }
		    parse=true;
		    inputRight.setText(container);
		    container=divide(num, container);
		}
	    }
	}
	return container;
    }
    // 
    public boolean isNums(char x){
	if (x=='0' || x=='1'|| x=='2' || x=='3' || x=='4' || x=='5' || x=='6' ||x=='7' ||x=='8' ||x=='9'){
	    return true;
	}
	else{
	    return false;
	}
    }
    public String solver(String str){
	String temp1="";
	String temp2="";
	String solution=str;
	boolean parse=true;
	if (str.indexOf('*')!=-1){
	    for (int x=str.indexOf("*")+1; parse && x<str.length(); x++){
		if (isNums(str.charAt(x)) || str.charAt(x)=='.'){
		    temp1=temp1+str.charAt(x);
		}
		else{
		    parse=false;
		}
	    }
	    parse=true;
	    for (int x=str.indexOf("*")-1; parse && x>-1; x--){
		if (isNums(str.charAt(x)) || str.charAt(x)=='.'){
		    temp2=str.charAt(x)+temp2;
		}
		else{
		    parse=false;
		}
	    }
	    solution=multiply(temp1,temp2);
	}
	temp2="";
	temp1="";
	parse=true;
	if (str.indexOf('/')!=-1){
	    for (int x=str.indexOf("/")+1; parse && x<str.length(); x++){
		if (isNums(str.charAt(x)) || str.charAt(x)=='.'){
		    temp1=temp1+str.charAt(x);
		}
		else{
		    parse=false;
		}
	    }
	    parse=true;
	    for (int x=str.indexOf("/")-1; parse && x>-1; x--){
		if (isNums(str.charAt(x)) || str.charAt(x)=='.'){
		    temp2=str.charAt(x)+temp2;
		}
		else{
		    parse=false;
		}
	    }
	    solution=divide(temp1,temp2);
	}
	temp2="";
	temp1="";
	parse=true;
	if (str.indexOf('+')!=-1){
	    for (int x=str.indexOf("+")+1; parse && x<str.length(); x++){
		if (isNums(str.charAt(x)) || str.charAt(x)=='.'){
		    temp1=temp1+str.charAt(x);
		}
		else{
		    parse=false;
		}
	    }
	    parse=true;
	    for (int x=str.indexOf("+")-1; parse && x>-1; x--){
		if (isNums(str.charAt(x)) || str.charAt(x)=='.'){
		    temp2=str.charAt(x)+temp2;
		}
		else{
		    parse=false;
		}
	    }
	    solution=add(temp1,temp2);
	}
	temp2="";
	temp1="";
	parse=true;
	if (str.indexOf('-')!=-1){
	    for (int x=str.indexOf("-")+1; parse && x<str.length(); x++){
		if (isNums(str.charAt(x)) || str.charAt(x)=='.'){
		    temp1=temp1+str.charAt(x);
		}
		else{
		    parse=false;
		}
	    }
	    parse=true;
	    for (int x=str.indexOf("-")-1; parse && x>-1; x--){
		if (isNums(str.charAt(x)) || str.charAt(x)=='.'){
		    temp2=str.charAt(x)+temp2;
		}
		else{
		    parse=false;
		}
	    }
	    solution=subtract(temp1,temp2);
	}
	return solution;
    }
    // Basiv math fxns
    public String multiply(String x, String y){
	return ""+ (Double.parseDouble(x)*Double.parseDouble(y));
    }
    public String divide(String x, String y){
	return ""+ (Double.parseDouble(y)/Double.parseDouble(x));
    }
    public String subtract(String x,String y){
	return ""+ (Double.parseDouble(y)-Double.parseDouble(x));
    }
    public String add(String x,String y){
	return ""+ (Double.parseDouble(x)+Double.parseDouble(y));
    }

       
    public String remove(String value, int pos) {
      return value.substring(0, pos) + value.substring(pos + 1);
   }
}
    
    
    

    public static void main(String[] args){
	AlgebraCalculator x = new AlgebraCalculator();
	x.setVisible(true);
	x.setResizable(false);
    }
}
