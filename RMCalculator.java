
import javax.swing.*;
import java.awt.*;
public class RMCalculator extends JFrame {
 private Container pane;

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

  //CONSTRUCTOR SETS EVERYTHING UP
  public RMCalculator() {
     this.setTitle("RM Calculator");
     this.setSize(500,800);
     this.setLocation(100,100);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
     pane = this.getContentPane();
     pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
    
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

     pane.add(clear);
     pane.add(posneg);
     pane.add(percent);
     pane.add(divide);
     pane.add(seven);
     pane.add(eight);
     pane.add(nine);
     pane.add(multiply);
     pane.add(four);
     pane.add(five);
     pane.add(six);
     pane.add(subtract);
     pane.add(one);
     pane.add(two);
     pane.add(three);
     pane.add(add);
     pane.add(zero);
     pane.add(decimal);
     pane.add(equal);

 }

  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
     RMCalculator g = new RMCalculator();
     g.setVisible(true);
     g.setResizable(false);

  }
}
