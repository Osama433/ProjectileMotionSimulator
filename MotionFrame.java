import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.*;

@SuppressWarnings("serial")
public class MotionFrame extends JFrame{
	public MotionFrame() {

	}

	public void paint(Graphics g)
	{
		
		
		
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		Scanner input = new Scanner(System.in);
		////////////////////////////

		g2.setColor(Color.blue);
		g2.fillRect(0, 0, 1000, 500);
		g2.setColor(Color.green);
		g2.fillRect(0, 500, 1000, 100);
		System.out.println("Enter initial velocity:");
		double velocity = input.nextDouble();
		System.out.println("Enter initial angle:");
		double angle = input.nextDouble();
		System.out.println("Enter acceleration due to gravity:");
		double gravity = input.nextDouble();
		double Vx = velocity * Math.cos(Math.toRadians(angle));
		double Vy = velocity * Math.sin(Math.toRadians(angle));
		double Vy2;
		double y2;
		double Vn;
		double Dy;
		double Dx = 0;
		double Dymax = 0;
		double angle2;
		double y = 0;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		DecimalFormat df = new DecimalFormat("#.##");
		Ball: for (y = 0; y > -1; y = y + 0.005) {
			Vy2 = Vy - (gravity * y);
			Dy = (Vy - (0.5 * gravity * y)) * y;
			Dx = (Vx * y);
			Vn = Math.sqrt(Vx * Vx + Vy2 * Vy2);
			angle2 = Math.toDegrees(Math.atan((Vy2 / Vx)));
			g2.setColor(Color.blue);
			g2.fillRect(749, 0, 200, 140);
			g2.setColor(Color.white);
			g2.drawString("Velocity: " + df.format(Vn), 750, 50);
			g2.drawString("Horizantal Velocity: " + df.format(Vx), 750, 70);
			g2.drawString("Vertical Velocity: " + df.format(Vy2), 750, 90);
			g2.drawString("Angle: " + df.format(angle2), 750, 110);
			g2.drawString("Time: " + df.format(y), 750, 130);
			/*
			 * g2.drawString("Displacement : " + df.format(D), 750, 150);
			 * g2.drawString("Horizontal Displacement: " + df.format(Dx), 750,
			 * 170); g2.drawString("Vertical Displacement: " + df.format(Dy),
			 * 750, 190);
			 */
			if (Math.round(Vy2) == 0) {
				Dymax = Dy;
			}

			y2 = y - 0.005;
			g2.setColor(Color.blue);
		    	g2.fillOval((int) (5 + (10 * Vx * y2)),
			(int) (470 - (10 * ((Vy - (0.5 * gravity * y2)) * y2))),
					25, 25);
			g2.setColor(Color.RED);
			g2.fillOval((int) (5 + 10 * Vx * y), (int) (470 - (10 * Dy)), 25,
					25);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			if ((int) Vn * 10 == (int) velocity * 10 && y != 0) {
				g2.setColor(Color.blue);
				g2.fillRect(749, 0, 200, 140);
				g2.setColor(Color.white);
				g2.drawString("Velocity: " + df.format(Vn), 750, 50);
				g2.drawString("Horizantal Velocity: " + df.format(Vx), 750, 70);
				g2.drawString("Vertical Velocity: " + df.format(Vy2), 750, 90);
				g2.drawString("Angle: " + df.format(angle2), 750, 110);
				g2.drawString("Time: " + df.format(y), 750, 130);
				g2.drawString("Max Height: " + df.format(Dymax), 750, 150);
				g2.drawString("Range: " + df.format(Dx), 750, 170);
				break Ball;

			}
			

		}
		
	    System.exit(0);
	    
	    

	}

}
