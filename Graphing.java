import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.geom.Line2D;

public class Graphing extends JFrame {
    private Container pane;
    
    private JLabel Equals;
    private JTextField input;
    private JButton graph;
    String yEquals = "";
    private JTextField output;

    
    public Graphing() {
	this.setTitle("Graphing");
	this.setSize(500,800);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	
     pane.setLayout(new FlowLayout());

     Equals = new JLabel("y=");

     input = new JTextField();
     output = new JTextField();
     
     graph = new JButton("Graph!");

     pane.add(Equals);     
     pane.add(input);
          pane.add(graph);

     pane.add(output);
     

     //   graph.addActionListener(new ListenGraph());

     
     /*
     
     JPanel p = new JPanel();
     p.setLayout(new GridLayout(2, 1));
     p.add(inputEquation);
     add(p);
     */    
    }
    /*  
    public boolean isSlopeInterceptForm(String text){
	if(){
	    
	}
}    
*/	

    
/*
    
    class ListenGraph implements ActionListener {
	public void actionPerformed(ActionEvent x) {
	    yEquals = input.getText();

	    
	    if (isSlopeInterceptForm(yEquals)){
		output.setText(yEquals);
	    }
	    
	}
	
    }
*/

    public static void main(String [] args) {	
	Graphing g = new Graphing();
	g.setVisible(true);
    }
    
}
