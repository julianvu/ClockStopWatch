import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;

public class MyClock extends JPanel implements MoveableShape{
	
	private int x;
	private int y;
	private int width;
    private int tick;
    private int hourTick;
	//private static final int OUTER_RADIUS = 500;
	//private static final int INNER_RADIUS = 125;
			

	public MyClock (int x, int y, int width){
		this.x = x;
		this.y = y;
		this.width = width;
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(width, width));
		

		ClockFace faceIcon = new ClockFace(0,0,width, Type.CLOCK);
		ClockHand secondHand = new ClockHand(width/2, width2, width/2, 0);
		ClockHand minuteHand = new ClockHand(width/2, width2, width/2, 0);
		ClockHand hourHand = new ClockHand(width/2, width2, width/2, 0);
		
		//time
		Calendar cal = new GregorianCalendar();
		int second = cal.get(Calendar.SECOND);
		int minute = cal.get(Calendar.MINUTE);
		int hour = cal.get(Calendar.HOUR);
		tick = minute;
		hourTick = hour;
		
		faceIcon.setPreferredSize(new Dimension(width, width));
		
		this.add(faceIcon);
	}
	
	public void tick() {
		
		
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
			
	}
}
