import javax.swing.*;
import java.awt.*;

/**
 * Implementation of a clock that displays the current local time.
 * Aggregates one ClockFace and three ClockHands
 */
public class MyClock extends JPanel {
	// Instance variables
	private int x;
	private int y;
	private int width;
	private ClockFace faceIcon;
	private ClockHand secondHand;
	private ClockHand minuteHand;
	private ClockHand hourHand;

	/**
	 * Constructor for MyClock
	 * @param x	x-coordinate
	 * @param y	y-coordinate
	 * @param width	width of this Clock
	 */
	public MyClock (int x, int y, int width){
		this.x = x;
		this.y = y;
		this.width = width;
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(width, width));

		faceIcon = new ClockFace(0,0, width, Type.CLOCK);
		secondHand = new ClockHand(width/2, width/2, width/2, 50);
		minuteHand = new ClockHand(width/2, width/2, width/2, 100);
		hourHand = new ClockHand(width/2, width/2,width/2, 150);
		
		faceIcon.setPreferredSize(new Dimension(width, width));

		tick();	// Moves hands to current local time
	}

	/**
	 * Gets local time and calculates angles of rotation for each hand to move them.
	 */
	public void tick() {
		// Get local times
		int second = java.time.LocalTime.now().getSecond();
		int minute = java.time.LocalTime.now().getMinute();
		int hour = java.time.LocalTime.now().getHour();

		// Calculate angles of rotation
		double thetaSecond = second/60.0 * 2.0 * Math.PI - Math.PI/2;
		double thetaMinute = minute/60.0 * 2.0 * Math.PI - Math.PI/2;
		double thetaHour = hour*5/60.0 * 2.0 * Math.PI - Math.PI/2;

		// Move ClockHands
		secondHand.setEndPoint(secondHand.getCX() + secondHand.getLength() * Math.cos(thetaSecond), secondHand.getCY() + secondHand.getLength() * Math.sin(thetaSecond));
		minuteHand.setEndPoint(minuteHand.getCX() + minuteHand.getLength() * Math.cos(thetaMinute), minuteHand.getCY() + minuteHand.getLength() * Math.sin(thetaMinute));
		hourHand.setEndPoint(hourHand.getCX() + hourHand.getLength() * Math.cos(thetaHour), hourHand.getCY() + hourHand.getLength() * Math.sin(thetaHour));

		this.repaint();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		faceIcon.paintComponent(g2);
		secondHand.draw(g2);

		g2.setColor(Color.BLACK);
		minuteHand.draw(g2);
		g2.setStroke(new BasicStroke(5));
		hourHand.draw(g2);
	}
}
