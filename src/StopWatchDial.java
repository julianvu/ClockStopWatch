import javax.swing.*;
import java.awt.*;

public class StopWatchDial extends JPanel{
	
	private int x;
	private int y;
	private int width;
	ClockFace dial;

	ClockHand hand;
			
	/**
    Constructs a StopWatchDial using 2 ClockFaces <br>
    x, y represent the outer dial's coords
    @param x the left of the bounding rectangle
    @param y the top of the bounding rectangle
    @param width the width of the bounding rectangle
	 */
	
	public StopWatchDial(int x, int y, int width){
		this.x = x;
		this.y = y;
		this.width = width;
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(width, width));
		
		dial = new ClockFace(x,y,width, Type.STOPWATCH);
		dial.setPreferredSize(new Dimension(width, width));
		hand = new ClockHand(x+(width/2), y+(width/2), width/2, y);
	}
	
	public void dialTick() {
		hand.tick();
		this.repaint();
	}
	
	public void dialReset() {
		hand = new ClockHand(x+(width/2), y+(width/2), width/2, y);
	}

	public ClockHand getHand() {
		return hand;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		dial.paintComponent(g2);
		hand.draw(g2);	
	}
}
