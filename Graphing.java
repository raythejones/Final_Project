import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.lang.*;


public class Graphing extends JFrame {
    private Graphics2D g2;
    private JLabel Equals;
    private JTextField slope;
    private JLabel variable;
    private JLabel makeSpace;
    private JLabel makeSpace2;
    private int slopeInt;
    private int yIntInt;
    private JTextField yInt;
    private JButton graphLine;
    private int aInt;
    private int bInt;
    private int cInt;
    private JTextField A;
    private JTextField B;
    private JTextField C;
    private JButton graphParabola;
    private Point p1;
    private Point p2;
    String yEquals = "";
    private boolean isGraphingLine = false;
    private boolean isGraphingParabola = false;

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
	if (isGraphingLine) {
	    g.setColor(Color.black);
	    g.drawLine(p1.x,p1.y,p2.x,p2.y);
	}
	
	if (isGraphingParabola) {
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
    
    public Graphing() {

	this.setTitle("Graphing");
	this.setSize(400,800);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	     Container pane;

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

	A = new JTextField(5);
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

	e.add(graphLine);


	e.add(makeSpace);
	e.add(Equals);     
	e.add(A);
	e.add(variable);
	
	e.add(B);
	e.add(C);

		e.add(makeSpace2);

	e.add(graphParabola);

     
	graphLine.addActionListener(new ListenGraphLine());
     	graphParabola.addActionListener(new ListenGraphParabola());

     
     
     
	pane.setLayout(new GridLayout(2, 1));
	pane.add(graphArea);
	pane.add(e);
     
    }

    

  
    class ListenGraphLine implements ActionListener {
	public void actionPerformed(ActionEvent x) {
	
	    slopeInt = Integer.parseInt(slope.getText());
	    yIntInt = Integer.parseInt(yInt.getText());

	    p1 = new Point(0, (slopeInt * -10) + yIntInt);
	    p2 = new Point(400, (slopeInt * 10) + yIntInt);

	    p1.y = -20*p1.y + 200;
	    p2.y = -20*p2.y + 200;
		
	    isGraphingLine = true;
	    repaint();
    
	}
    }
    
       class ListenGraphParabola implements ActionListener {
	public void actionPerformed(ActionEvent x) {
	isGraphingParabola = true;
	    aInt = Integer.parseInt(A.getText());
	    bInt = Integer.parseInt(B.getText());
	    cInt = Integer.parseInt(C.getText());

	for(int w = 1; w<401; w++){
		p1 = new Point(w-1, (aInt * (w-1)*(w-1)) + (bInt * (w-1)) + cInt);
		p2 = new Point(w, (aInt * w*w) + (bInt * w) + cInt);
		repaint();
	}


    
	}
    }
     
    public static void main(String [] args) {	
	Graphing h = new Graphing();
	h.setVisible(true);
	h.setResizable(false);
    }
    
}