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
    private JLabel makeSpace;
    private JLabel makeSpace2;
    private double[] xvalues;
    private double[] yvalues;
    private int slopeInt;
    private int yIntInt;
    private JTextField yInt;
    private JButton graph;
    String yEquals = "";
    private boolean isGraphing = false;

	JPanel e = new JPanel();
	JPanel graphArea = new JPanel() {

		@Override
		protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    myPaint(g);
		}	

	    };
    private void myPaint(Graphics g){
	if (isGraphing) {
	    g.setColor(Color.black);
	    g.drawLine(0,100,100,100);

	}
    }
    
    public Graphing() {
	JFrame frame = new JFrame("Dispose shapes");

	this.setTitle("Graphing");
	this.setSize(500,800);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
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
	    isGraphing = true;
	    repaint();
    
	}
    }	    	    



    public static void main(String [] args) {	
	Graphing h = new Graphing();
	h.setVisible(true);
	h.setResizable(false);
    }
    
}
