import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class RMCalculator extends JFrame {


 private Container pane;
 private Container pane2;


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

  //CONSTRUCTOR SETS EVERYTHING UP
  public RMCalculator() {
     this.setTitle("RM Calculator");
     this.setSize(500,800);
     this.setLocation(100,100);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
     
     JPanel pan1 = new JPanel();
     pan1.setLayout(new GridLayout(5,4));
    
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
     
     pan1.add(clear);
     pan1.add(posneg);
     pan1.add(percent);
     pan1.add(divide);
     pan1.add(seven);
     pan1.add(eight);
     pan1.add(nine);
     pan1.add(multiply);
     pan1.add(four);
     pan1.add(five);
     pan1.add(six);
     pan1.add(subtract);
     pan1.add(one);
     pan1.add(two);
     pan1.add(three);
     pan1.add(add);
     pan1.add(zero);
     pan1.add(decimal);
     pan1.add(equal);

// RESULT

    JPanel pan2 = new JPanel();
    pan2.setLayout(new FlowLayout());
    pan2.add(output = new JTextField(20));
    output.setHorizontalAlignment(JTextField.CENTER);
    output.setEditable(false);

    JPanel p = new JPanel();
    p.setLayout(new GridLayout(2, 1));
    p.add(pan2);
    p.add(pan1);
    add(p);
    
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


  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
     RMCalculator g = new RMCalculator();
     g.setVisible(true);
     g.setResizable(false);

  }
}
