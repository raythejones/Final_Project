import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.lang.*;


public class Driver extends JFrame{

// INITIALIZE FUNCTION BUTTONS
 private JButton plus;
 private JButton clear;
 private JButton posneg;
 private JButton percent;
 private JButton divide;
 private JButton add;
 private JButton multiply;
 private JButton decimal;
 private JButton equal;
 private JButton subtract;

// INITIALIZE NUMBER BUTTONS
 private JButton seven;
 private JButton eight;
 private JButton nine;
 private JButton four;
 private JButton five;
 private JButton six;
 private JButton one;
 private JButton two;
 private JButton three;
 private JButton zero;
 
 
// INITIALIZE OUTPUT AND DISPLAY
 private JTextField output;
 String display = "";

 
// INITIALIZE BOOLEANS FOR EACH FUNCTION
Boolean percentBoolean=false;
Boolean adding = false ;
Boolean subtracting = false ;
Boolean dividing = false ;
Boolean multiplying = false ;

// INITIALIZE DOUBLES FOR tempORARY STORAGE
    private double temp;
    private double solutionTemp;


//ALGEBRA


    private Container algPane;
    //Initialize the TextFields in order to put expressions 
    private JTextField inputRight;
    private JTextField inputLeft;
    private JLabel equals;
    private JTextField outputAlg;
    private JOptionPane error;
    // Button that computes the value of x(requires boolean)
    private JButton compute;
    private String valueRight,valueLeft, solution;
    Boolean solve=false;

     private Container pane;
    private Graphics2D g2;
    private JLabel Equals;
    private JTextField slope;
    private JLabel variable;
    private JLabel makeSpace;
    private JLabel makeSpace2;
    private int slopeInt;
    private int yIntInt;
    private JTextField yInt;
    private JButton graph;
    private Point p1;
    private Point p2;
    String yEquals = "";
    private boolean isGraphing = false;

	JPanel e = new JPanel();
	JPanel graphArea = new JPanel() {

		@Override
		protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    myPaint(g);
		    initPaint(g);
		}	

	    };
    private void myPaint(Graphics g){
	if (isGraphing) {
	    g.setColor(Color.black);
	    g.drawLine(p1.x,p1.y,p2.x,p2.y);

	}
    }

        private void initPaint(Graphics g){
	    g.setColor(Color.black);
	    g.drawLine(40,0,40,400);
	    g.drawLine(0,40,400,40);
	    g.drawLine(80,0,80,400);
	    g.drawLine(0,80,400,80);
	    g.drawLine(120,0,120,400);
	    g.drawLine(0,120,400,120);
	    g.drawLine(160,0,160,400);
	    g.drawLine(0,160,400,160);
	    g.drawLine(240,0,240,400);
	    g.drawLine(0,240,400,240);
	    g.drawLine(280,0,280,400);
	    g.drawLine(0,280,400,280);
	    g.drawLine(320,0,320,400);
	    g.drawLine(0,320,400,320);
	    g.drawLine(360,0,360,400);
	    g.drawLine(0,360,400,360);
	    g.drawLine(20,0,20,400);
	    g.drawLine(0,20,400,20);
	    g.drawLine(60,0,60,400);
	    g.drawLine(0,60,400,60);
	    g.drawLine(100,0,100,400);
	    g.drawLine(0,100,400,100);
	    g.drawLine(140,0,140,400);
	    g.drawLine(0,140,400,140);
	    g.drawLine(220,0,220,400);
	    g.drawLine(0,220,400,220);
	    g.drawLine(260,0,260,400);
	    g.drawLine(0,260,400,260);
	    g.drawLine(300,0,300,400);
	    g.drawLine(0,300,400,300);
	    g.drawLine(340,0,340,400);
	    g.drawLine(0,340,400,340);
	    g.drawLine(0,380,400,380);
	    g.drawLine(0,180,400,180);
	    g.drawLine(380,0,380,400);
	    g.drawLine(180,0,180,400);
   
    Graphics2D g2 = (Graphics2D) g;

	    g2.setStroke(new BasicStroke(3));

	    g.drawLine(0,200,400,200);
	    g.drawLine(200,0,200,400);

	
    }

  //CONSTRUCTOR SETS EVERYTHING UP
    public Driver(){
      setTitle("RMCalculator");
         JTabbedPane mainTabbedPane = new JTabbedPane();
        getContentPane().add(mainTabbedPane);

     this.setSize(400,800);
     this.setLocation(100,100);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
     
     JPanel buttonPanel = new JPanel();
     buttonPanel.setLayout(new GridLayout(5,4));
    
     clear = new JButton("C");
     posneg = new JButton("+/-");
     percent = new JButton("%");
     divide = new JButton("/");
     seven = new JButton("7");
     eight = new JButton("8");
     nine = new JButton("9");
     multiply = new JButton("*");
     four = new JButton("4");
     five = new JButton("5");
     six = new JButton("6");
     subtract = new JButton("-");
     one = new JButton("1");
     two = new JButton("2");
     three = new JButton("3");
     add = new JButton("+");
     zero = new JButton("0");
     decimal = new JButton(".");
     equal = new JButton("=");
     
     buttonPanel.add(clear);
     buttonPanel.add(posneg);
     buttonPanel.add(percent);
     buttonPanel.add(divide);
     buttonPanel.add(seven);
     buttonPanel.add(eight);
     buttonPanel.add(nine);
     buttonPanel.add(multiply);
     buttonPanel.add(four);
     buttonPanel.add(five);
     buttonPanel.add(six);
     buttonPanel.add(subtract);
     buttonPanel.add(one);
     buttonPanel.add(two);
     buttonPanel.add(three);
     buttonPanel.add(add);
     buttonPanel.add(zero);
     buttonPanel.add(decimal);
     buttonPanel.add(equal);

// RESULT

    JPanel answer = new JPanel();
    answer.setLayout(new FlowLayout());
    answer.add(output = new JTextField(20));
    output.setHorizontalAlignment(JTextField.CENTER);
    output.setEditable(false);

    JPanel basicCalculator = new JPanel();
    basicCalculator.setLayout(new GridLayout(2, 1));
    basicCalculator.add(answer);
    basicCalculator.add(buttonPanel);
    
    mainTabbedPane.addTab("Calculator", basicCalculator);
    
	JPanel algPanel = new JPanel();
	algPanel.setLayout(new FlowLayout());
	algPanel.add(inputLeft=new JTextField(20));
	inputLeft.setEditable(true);
	JLabel equals = new JLabel("=");
	algPanel.add(inputRight= new JTextField(20));
	inputRight.setHorizontalAlignment(JTextField.RIGHT);
	inputRight.setEditable(true);
	algPanel.add(outputAlg= new JTextField(20));
	equals.setHorizontalAlignment(JLabel.CENTER);
	outputAlg.setEditable(false);
	compute= new JButton ("Compute");
	// Sets the GUI

	algPanel.add(inputLeft);
	algPanel.add(equals);
	algPanel.add(inputRight);
	algPanel.add(compute);
	algPanel.add(outputAlg);

	//Creates the GUI

    mainTabbedPane.addTab("Algebra", algPanel);

	//Allows us to gather the information from the GUI
	compute.addActionListener(new ListenCompute());
	
    one.addActionListener(new ListenOne());
    two.addActionListener(new ListenTwo());
    three.addActionListener(new ListenThree());
    four.addActionListener(new ListenFour());
    five.addActionListener(new ListenFive());
    six.addActionListener(new ListenSix());
    seven.addActionListener(new ListenSeven());
    eight.addActionListener(new ListenEight());
    nine.addActionListener(new ListenNine());
    zero.addActionListener(new ListenZero());

    add.addActionListener(new ListenAdd());
    subtract.addActionListener(new ListenSubtract());
    multiply.addActionListener(new ListenMultiply());
    divide.addActionListener(new ListenDivide());
    equal.addActionListener(new ListenSolve());
    clear.addActionListener(new ListenClear());
    decimal.addActionListener(new ListenDeci());
    posneg.addActionListener(new ListenPosNeg());
    percent.addActionListener(new ListenPercent());

	pane = this.getContentPane();
	pane.setLayout(new GridLayout(2,1));

	e.setLayout(new FlowLayout());

	graphArea.setLayout(new FlowLayout());

	graphArea.setBackground(Color.white);
	    
	makeSpace = new JLabel("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></html>");


	Equals = new JLabel("y= (");

	slope = new JTextField(5);
	variable = new JLabel("* x) + ");
	yInt = new JTextField(5);
	makeSpace2 = new JLabel("<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></html>");

	graph = new JButton("Graph!");

	e.add(makeSpace);
	e.add(Equals);     
	e.add(slope);
	e.add(variable);
	e.add(yInt);
		e.add(makeSpace2);

	e.add(graph);


     
	graph.addActionListener(new ListenGraph());
     
     
     
     
	pane.setLayout(new GridLayout(2, 1));
	pane.add(graphArea);
	pane.add(e);
	

	    mainTabbedPane.addTab("Graphing", pane);

}

class ListenClear implements ActionListener {
    public void actionPerformed(ActionEvent x) {
        output.setText("");
        adding = false ;
        subtracting = false ;
        multiplying = false ;
        dividing = false ;

        temp = 0;
        solutionTemp =0 ;
    }
}
class ListenCompute implements ActionListener{
    public void actionPerformed(ActionEvent i){
	valueLeft=inputLeft.getText();
	valueRight=inputRight.getText();
	if ((isExpression(valueLeft) || isExpression(valueRight)) && isSameVar(valueRight,valueLeft)){
	    /*For polynomials
	    valueLeft=simplify(valueLeft);
	    valueRight=simplify(valueRight);
	   
	       if (isExpo(valueLeft) || isExpo(valueRight)){
	           solvepoly(valueLeft
	       }
	       else{
	    */

	    solution=(solve(valueLeft, valueRight));
	    outputAlg.setText(solution);

	    /*inputLeft.setText("");
	    inputRight.setText("");
	    */
	}
	else{
	    JOptionPane error = new JOptionPane("A valid expression must be inputed in both sides of the equation, as well as the same variable.", JOptionPane.ERROR_MESSAGE);
	    JDialog message = error.createDialog("InvalidInputException");
	    message.setAlwaysOnTop(true);
	    message.setVisible(true);
	}
    }
    
    // Checks to see if the query string is an expression

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
    // To simplify long algebraic equations. Follows PEMDAS (For Longer Polynomials)
    /*
    public String simplify(String value){
	//Parenthesis
	boolean isError=false;
	if (value.indexOf('(')>-1 || value.indexOf(')')>-1 ){
	    if (value.indexOf(')')==-1 || value.indexOf('(')==-1){
		JOptionPane error = new JOptionPane("Expected open/close parenthesis", JOptionPane.ERROR_MESSAGE);
		JDialog message = error.createDialog("ParenthesisException");
		message.setAlwaysOnTop(true);
		message.setVisible(true);
		isError=true;
	    }
	    else{
		
	    }
	}
	/* Exponents (Not in use until on to polynomials)
	else if(value.indexOf("^")>-1 && !isError){
	}
	
	else if (value.indexOf('*')>-1 && !isError){
	   
	}
	return value;
    }
    */
    //Should try to move the constants to one side keeping the variable on the other for monomials expressions, then should either divide or multiply depending on the coefficent.
    
    public String solve(String exp1, String exp2){
	String container ="";
	boolean parse=true;
	if ((hasLetter(exp1) && !hasLetter(exp2))){
	    container = solver(exp2);
	    String num="";
	    if(exp1.indexOf('+')>-1){
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
	    if(exp1.indexOf('-')>-1){
		for (int x=exp1.indexOf('-') + 1; parse && x<exp1.length(); x++){
		    if (isNums(exp1.charAt(x))){
			num=num+exp1.charAt(x);
		    }
		    else{
			parse=false;
		    }
		}
		parse=true;
		container=add(container, num);
	    }
	    if(exp1.indexOf('/')>-1){
		for (int x=exp1.indexOf('/') + 1; parse && x<exp1.length(); x++){
		    if (isNums(exp1.charAt(x))){
			num=num+exp1.charAt(x);
		    }
		    else{
			parse=false;
		    }
		}
		parse=true;
		container=multiply(container, num);
	    }
	    if(exp1.indexOf('*')>-1){
		for (int x=exp1.indexOf('*') + 1; parse && x<exp1.length(); x++){
		    if (isNums(exp1.charAt(x))){
			num=num+exp1.charAt(x);
		    }
		    else{
			parse=false;
		    }
		}
		parse=true;
		container=divide(num, container);
	    }
	}
	else if ((!hasLetter(exp1) && hasLetter(exp2))){
	    String num="";
	    container= solver(exp1);
	    if(exp1.indexOf('+')>-1){
		for (int x=exp2.indexOf('+') + 1; parse && x<exp2.length(); x++){
		    if (isNums(exp2.charAt(x))){
			num=num+exp2.charAt(x);
		    }
		    else{
			parse=false;
		    }
		}
		parse=true;
		container=subtract(num, container);
	    }
	    else if(exp1.indexOf('-')>-1){
		for (int x=exp1.indexOf('-') + 1; parse && x<exp2.length(); x++){
		    if (isNums(exp2.charAt(x))){
			num=num+exp2.charAt(x);
		    }
		    else{
			parse=false;
		    }
		}
		parse=true;
		container=add(container, num);
	    }
	    else if(exp1.indexOf('/')>-1){
		for (int x=exp2.indexOf('/') + 1; parse && x<exp2.length(); x++){
		    if (isNums(exp2.charAt(x))){
			num=num+exp2.charAt(x);
		    }
		    else{
			parse=false;
		    }
		}
		parse=true;
		container=multiply(container, num);
	    }
	    else if(exp1.indexOf('*')>-1){
		for (int x=exp2.indexOf('*') + 1; parse && x<exp2.length(); x++){
		    if (isNums(exp2.charAt(x))){
			num=num+exp2.charAt(x);
		    }
		    else{
			parse=false;
		    }
		}
		parse=true;
		container=divide(num, container);
	    }
	    return container;
	}
	return container;
    }
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
		if (isNums(str.charAt(x))){
		    temp1=temp1+str.charAt(x);
		}
		else{
		    parse=false;
		}
	    }
	    parse=true;
	    for (int x=str.indexOf("*")-1; parse && x>-1; x--){
		if (isNums(str.charAt(x))){
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
		if (isNums(str.charAt(x))){
		    temp1=temp1+str.charAt(x);
		}
		else{
		    parse=false;
		}
	    }
	    parse=true;
	    for (int x=str.indexOf("/")-1; parse && x>-1; x--){
		if (isNums(str.charAt(x))){
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
		if (isNums(str.charAt(x))){
		    temp1=temp1+str.charAt(x);
		}
		else{
		    parse=false;
		}
	    }
	    parse=true;
	    for (int x=str.indexOf("+")-1; parse && x>-1; x--){
		if (isNums(str.charAt(x))){
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
		if (isNums(str.charAt(x))){
		    temp1=temp1+str.charAt(x);
		}
		else{
		    parse=false;
		}
	    }
	    parse=true;
	    for (int x=str.indexOf("-")-1; parse && x>-1; x--){
		if (isNums(str.charAt(x))){
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
    
    public String multiply(String x, String y){
	return ""+ (Integer.parseInt(x)*Integer.parseInt(y));
    }
    public String divide(String x, String y){
	return ""+ (Integer.parseInt(y)/Integer.parseInt(x));
    }
    public String subtract(String x,String y){
	return ""+ (Integer.parseInt(y)-Integer.parseInt(x));
    }
    public String add(String x,String y){
	return ""+ (Integer.parseInt(x)+Integer.parseInt(y));
    }
}
    
    
    /*
    public String solvePoly(String exp1, String exp2){
	
    }
    */

// NUMBER BUTTONS & Decimal Button

class ListenOne implements ActionListener {
    public void actionPerformed(ActionEvent x) {
        display = output.getText();
        output.setText(display + "1");
    }
}
class ListenTwo implements ActionListener {
    public void actionPerformed(ActionEvent x) {
        display = output.getText();
        output.setText(display + "2");
    }
}
class ListenThree implements ActionListener {
    public void actionPerformed(ActionEvent x) {
        display = output.getText();
        output.setText(display + "3");
    }
}
class ListenFour implements ActionListener {
    public void actionPerformed(ActionEvent x) {
        display = output.getText();
        output.setText(display + "4");
    }
}
class ListenFive implements ActionListener {
    public void actionPerformed(ActionEvent x) {
        display = output.getText();
        output.setText(display + "5");
    }
}
class ListenSix implements ActionListener {
    public void actionPerformed(ActionEvent x) {
        display = output.getText();
        output.setText(display + "6");
    }
}
class ListenSeven implements ActionListener {
    public void actionPerformed(ActionEvent x) {
        display = output.getText();
        output.setText(display + "7");
    }
}
class ListenEight implements ActionListener {
    public void actionPerformed(ActionEvent x) {
        display = output.getText();
        output.setText(display + "8");
    }
}
class ListenNine implements ActionListener {
    public void actionPerformed(ActionEvent x) {
        display = output.getText();
        output.setText(display + "9");
    }
}
class ListenZero implements ActionListener {
    public void actionPerformed(ActionEvent x) {
        display = output.getText();
        output.setText(display + "0");
    }
}
class ListenDeci implements ActionListener{
    public void actionPerformed(ActionEvent i){
	display = output.getText();
	output.setText(display + ".");
    }
}
  

// MATH FUNCTION BUTTONS

class ListenAdd implements ActionListener {
    public void actionPerformed(ActionEvent x) {
        temp = Double.parseDouble(output.getText());
	output.setText("");
	subtracting =false;
	multiplying=false;
	dividing =false;
	adding = true ;
    }
}
class ListenSubtract implements ActionListener {
    public void actionPerformed(ActionEvent x) {
        temp = Double.parseDouble(output.getText());
        output.setText("");
	adding=false;
	multiplying=false;
        subtracting =true;
	dividing=false;
    }
}
class ListenMultiply implements ActionListener {
    public void actionPerformed(ActionEvent x) {
        temp = Double.parseDouble(output.getText());
        output.setText("");
        multiplying =true;
	adding=false;
	subtracting=false;
	dividing=false;
    }
}
class ListenDivide implements ActionListener {
    public void actionPerformed(ActionEvent x) {
        temp = Double.parseDouble(output.getText());
        output.setText("");
        dividing =true;
	multiplying=false;
	adding=false;
	subtracting=false;
    }
}
    //Needs at least a number other than zero to work for its intended use(Makes a number either become positive or negative)
class ListenPosNeg implements ActionListener{
    public void actionPerformed(ActionEvent i){
	display = output.getText();
        output.setText(Double.parseDouble(display)* -1 + "");
    }
}
    //The first number is the whole and the second number is the percentage 
class ListenPercent implements ActionListener{
    public void actionPerformed(ActionEvent i){
	temp=Double.parseDouble(output.getText());
	output.setText("");
	dividing=false;
	multiplying=false;
	adding=false;
	subtracting=false;
	percentBoolean=true;
    }
}
class ListenSolve implements ActionListener {
    public void actionPerformed(ActionEvent x) {
                    solutionTemp = Double.parseDouble(  output.getText() );
                    if ( adding == true  )
                        solutionTemp = solutionTemp + temp;

                    else if ( subtracting == true  )
                        solutionTemp = temp-solutionTemp;
                    else if ( multiplying == true  )
                        solutionTemp = solutionTemp * temp;
                    else if ( dividing == true  )
                        solutionTemp = temp / solutionTemp;
		    else if(percentBoolean=true)
			solutionTemp=solutionTemp * (temp/100);
        output.setText(  Double.toString( solutionTemp ) );

        adding = false ;
        subtracting = false ;
        multiplying = false ;
        dividing = false ;


    }
}

 class ListenGraph implements ActionListener {
	public void actionPerformed(ActionEvent x) {
	
	    slopeInt = Integer.parseInt(slope.getText());
	    yIntInt = Integer.parseInt(yInt.getText());

	    p1 = new Point(0, (slopeInt * -10) + yIntInt);
	    p2 = new Point(400, (slopeInt * 10) + yIntInt);

	    p1.y = -20*p1.y + 200;
	    p2.y = -20*p2.y + 200;
		
	    isGraphing = true;
	    repaint();
    
	}
    }



    public static void main(String [] args) {	
	Graphing h = new Graphing();
	h.setVisible(true);
	h.setResizable(false);
    
    /*
    RMCalculator g = new RMCalculator();
    g.setVisible(true);
    g.setResizable(false);
    
    
	AlgebraCalculator v = new AlgebraCalculator();
	v.setVisible(true);
	v.setResizable(false);
	
	*/
	Driver v = new Driver();
	v.setVisible(true);
	v.setResizable(false);
	
    }
}