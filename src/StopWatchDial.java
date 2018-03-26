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
		
		dial = new ClockFace(0,0,width, Type.STOPWATCH);
		hand = new ClockHand(width/2, width/2, width/2, 0);
	}
	
	public void dialTick() {
		hand.tick();
		this.repaint();
	}
	
	public void dialReset() {
		hand = new ClockHand(width/2, width/2, width/2, 0);
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
