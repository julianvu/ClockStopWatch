import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class StopWatchDial extends JPanel{
	
	private int x;
	private int y;
	private int width;
	//private static final int OUTER_RADIUS = 500;
	//private static final int INNER_RADIUS = 125;
			
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
		
		ClockFace outer = new ClockFace(0,0,width);
		ClockFace inner = new ClockFace(width/4,width/8,width/2);
		inner.setPreferredSize(new Dimension(width, width));
		
		this.add(outer);
		outer.add(inner);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
			
	}
}
