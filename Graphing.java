import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.geom.Line2D;

public class Graphing extends JFrame {
    
    private JTextField input;
    private JButton graph;
    String yEquals = "";
    
    public Graphing() {
	this.setTitle("Graphing");
	this.setSize(500,800);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	
     JPanel inputEquation = new JPanel();
     inputEquation.setLayout(new FlowLayout());
     
     graph = new JButton("Graph!");
     
     inputEquation.add(graph);
     inputEquation.add(input);
     graph.addActionListener(new ListenGraph());

     
     
     
     JPanel p = new JPanel();
     p.setLayout(new GridLayout(2, 1));
     p.add(inputEquation);
     add(p);
    }
    
    public boolean isSlopeIntercept {
	
	
	
    }
    
    class ListenGraph implements ActionListener {
	public void actionPerformed(ActionEvent x) {
	    yEquals = input.getText();
	    
	}
	
    }
 
    public static void main(String [] args) {

	
	Graphing g = new Graphing();
	g.setVisible(true);
    }
    
}
