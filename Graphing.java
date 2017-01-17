import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.script.*;
import java.util.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.lang.*;


public class Graphing extends JFrame {
    private Graphics2D g2;
    private double[] xValues;
    private double[] yValues;
    private JLabel Equals;
    private JLabel Equals2;
    private JTextField slope;
    private JLabel variable;
    private JLabel variable2;
    private JLabel variable3;
    private JLabel linebreak;
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
    private Point p3;
    private Point p4;
    private Point p5;
    private Point p6;
    private Point p7;
    private Point p8;
    private Point p9;
    private Point p10;
    private Point p11;        
    private Point p12;    
    private Point p13;    
    private Point p14;    
    private Point p15;    
    private Point p16;    
    private Point p17;    
    private Point p18;    
    private Point p19;    
    private Point p20;    
    private Point p22;    
    private Point p23;    
    private Point p24;    
    private Point p25;    
    private Point p26;    
    private Point p27;    
    private Point p28;    
    private Point p29;    
    private Point p30;    
    private Point p31;    
    private Point p32;    
    private Point p33;    
    private Point p34;    
    private Point p35;    
    private Point p36;    
    private Point p37;    
    private Point p38;    
    private Point p39;    
    private Point p40;    
    private Point p41;    
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
//	    g.drawLine(p1.x,p1.y,p2.x,p2.y);
//	    g.drawLine(p2.x,p2.y,p3.x,p3.y);
//	    g.drawLine(p3.x,p3.y,p4.x,p4.y);
//	    g.drawLine(p4.x,p4.y,p5.x,p5.y);
//	    g.drawLine(p5.x,p5.y,p6.x,p6.y);
//	    g.drawLine(p6.x,p6.y,p7.x,p7.y);
//	    g.drawLine(p7.x,p7.y,p8.x,p8.y);
//	    g.drawLine(p8.x,p8.y,p9.x,p9.y);
//	    g.drawLine(p9.x,p9.y,p10.x,p10.y);
//	    g.drawLine(p10.x,p10.y,p11.x,p11.y);

	/*    
	       for (int i=0; i<401; i+=2) {
	       	for (int i2=1; i2<402; i2+=2){
	       
        	double XforY = (i-200) / 20;
        	        	double XforY2 = (i2-200) / 20;

        	double l = (aInt * XforY * XforY) + (bInt * XforY) + cInt;
        	double l2 = (aInt * XforY2 * XforY2) + (bInt * XforY2) + cInt;
        	
 	
        	
           l = -20*l + 200;
            l2 = -20*l2 + 200;
                            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);

            
            g.draw(new Line2D.Double(i, l, i2, l2));



    	 
      
	}}
	
	
	
	for(int i = 0; i<yValues.length; i++){
	g.drawLine((int)xValues[i],(int)yValues[i],(int)xValues[i],(int)yValues[i]);
	
}
*/


        for(int x=0;x<=400;x+=1){
        	int x2 = x+1;
        	double prex = (x - 200) / 20.0;
        	double prex2 = (x2 - 200) / 20.0;
            double y = (aInt*prex*prex) + (bInt*prex) + cInt;
            double y2 = (aInt*prex2*prex2) + (bInt*prex2) + cInt;
            

            
            
            y = (y * -20.0) + 200;
            y2 = (y2 * -20.0) + 200;

            int Y = (int)y;
            int Y2 = (int)y2;
            
            
            
         g.drawLine(x,Y,x2,Y2);

        }

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
	    


	Equals = new JLabel("y= (");
	slope = new JTextField(5);
	variable = new JLabel("* x) + ");
	yInt = new JTextField(5);

	graphLine = new JButton("Graph a Line!");
	Equals2 = new JLabel("    y= (");

	A = new JTextField(5);
	B = new JTextField(5);
	C = new JTextField(5);
	variable2 = new JLabel("* x^2) + (");
		variable3 = new JLabel("* x) +");

	
	yInt = new JTextField(5);

	graphParabola = new JButton("Graph a Quadratic!");

	e.add(Equals);     
	e.add(slope);
	e.add(variable);
	e.add(yInt);

	e.add(graphLine);

	e.add(Equals2);     
	e.add(A);
	e.add(variable2);
	
	e.add(B);
	e.add(variable3);
	e.add(C);


	e.add(graphParabola);

     
	graphLine.addActionListener(new ListenGraphLine());
     	graphParabola.addActionListener(new ListenGraphParabola());

     
     
     
	pane.setLayout(new GridLayout(2, 1));
	pane.add(graphArea);
	pane.add(e);
     
    }

    

  
    class ListenGraphLine implements ActionListener {
	public void actionPerformed(ActionEvent x) {
		isGraphingParabola = false;
		    isGraphingLine = false;

		repaint();

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
		    isGraphingLine = false;
		isGraphingParabola = false;

	repaint();
	  
	  
	    aInt = Integer.parseInt(A.getText());
	    bInt = Integer.parseInt(B.getText());
	    cInt = Integer.parseInt(C.getText());

  
  isGraphingParabola = true;
		repaint();	
		  }}
    
    

    public static void main(String [] args) {	
	Graphing h = new Graphing();
	h.setVisible(true);
	h.setResizable(false);
    }
    
}