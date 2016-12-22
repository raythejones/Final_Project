
import javax.swing.*;
import java.awt.*;
public class RMCalculator extends JFrame {
 private Container pane;

 private JButton plus;
 private JLabel l;
 private JTextField t;
 private JCheckBox c;
 
  //CONSTRUCTOR SETS EVERYTHING UP
  public RMCalculator() {
     this.setTitle("RM Calculator");
     this.setSize(500,800);
     this.setLocation(100,100);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
     pane = this.getContentPane();
     pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
    
     plus = new JButton("+");
     l = new JLabel("This is AWESOME! (lies)",null,JLabel.CENTER);
     t = new JTextField(12);
     c = new JCheckBox("Overclock!!!");
     pane.add(l);
     pane.add(plus);
     pane.add(t);
     pane.add(c);
 }

  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
     RMCalculator g = new RMCalculator();
     g.setVisible(true);
  }
}
