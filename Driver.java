import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.lang.*;


public class Driver{



    public static void main(String [] args) {	
    
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter calc, graph, or algebra (all lowercase please) based on what you would like to do: ");

String input = scan.next();
    
    if (input.equals("calc")){
    RMCalculator g = new RMCalculator();
    g.setVisible(true);
    g.setResizable(false);
return;
    }
    
    if (input.equals("algebra")){
	AlgebraCalculator v = new AlgebraCalculator();
	v.setVisible(true);
	v.setResizable(false);
return;
}
	
    if (input.equals("graph")){
		Graphing h = new Graphing();
	h.setVisible(true);
	h.setResizable(false);
return;
}

else {
throw new IllegalArgumentException("please input one of the three accepted arguments");
    }


}}