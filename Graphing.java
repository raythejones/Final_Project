import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.lang.*;


public class Graphing extends JFrame {
    private Container pane;
    private Graphics2D g2;
    private JLabel Equals;
    private JTextField slope;
    private JLabel variable;
    private	    double[] xvalues;
    private	    double[] yvalues;
    private int slopeInt;
    private int yIntInt;
    private JTextField yInt;
    private JButton graph;
    String yEquals = "";
    private JTextField output;

    
    public Graphing() {
	this.setTitle("Graphing");
	this.setSize(500,800);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new GridLayout(2,1));
	JPanel e = new JPanel();

	e.setLayout(new FlowLayout());

	Equals = new JLabel("y= (");

	slope = new JTextField(5);
	variable = new JLabel("* x) + ");
	yInt = new JTextField(5);
	output = new JTextField(20);
	graph = new JButton("Graph!");
     
	e.add(Equals);     
	e.add(slope);
	e.add(variable);
	e.add(yInt);
	e.add(graph);
     
	e.add(output);
	pane.add(e);


     
	graph.addActionListener(new ListenGraph());
     
     
     
     
	pane.setLayout(new GridLayout(2, 1));
	pane.add(e);
     
    }

    

    
    
    class ListenGraph implements ActionListener {
	public void actionPerformed(ActionEvent x) {
	    xvalues = new double[21];
	    yvalues = new double[21];
	
	    slopeInt = Integer.parseInt(slope.getText());
	    yIntInt = Integer.parseInt(yInt.getText());


	    int p = -10;
	    int q = 0;
		while(p<11){
		    xvalues[q] = p;
		    yvalues[q] = (slopeInt * p) + yIntInt;

		    p++;
		    q++;}
	    
	    
	    
		
	}}	    	    

   
	
	



public static void main(String [] args) {	
    Graphing g = new Graphing();
    g.setVisible(true);
}
    
}
