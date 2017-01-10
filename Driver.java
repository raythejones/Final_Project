public class Driver {

    public static void main(String [] args) {	
    
	Graphing h = new Graphing();
	h.setVisible(true);
	h.setResizable(false);
    
    
    RMCalculator g = new RMCalculator();
    g.setVisible(true);
    g.setResizable(false);
    
    
	AlgebraCalculator v = new AlgebraCalculator();
	v.setVisible(true);
	v.setResizable(false);
    }
}