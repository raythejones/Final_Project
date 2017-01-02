
import javax.swing.*;
import java.awt.*;
public class RMCalculator extends JFrame {
 private Container pane;
 private Container pane2;

 private JButton plus;

 private JButton clear;
 private JButton posneg;
 private JButton percent;
 private JButton divide;
 private JButton seven;
 private JButton eight;
 private JButton nine;
 private JButton multiply;
 private JButton four;
 private JButton five;
 private JButton six;
 private JButton subtract;
 private JButton one;
 private JButton two;
 private JButton three;
 private JButton add;
 private JButton zero;
 private JButton decimal;
 private JButton equal;
 private JTextField output;
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

 }

  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
     RMCalculator g = new RMCalculator();
     g.setVisible(true);
     g.setResizable(false);

  }
}
