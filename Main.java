import javax.swing.*;

import java.awt.*;
import java.util.Scanner;

public class Main
{


    public static void main (String [] args)
    {
    	
    	JFrame frame= new MotionFrame();
    	frame.setSize(1000,600);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
    	frame.setResizable(false);
 	    	
    	frame.setTitle("Physics ISU");  
    }
   
}