import java.awt.*;

import javax.swing.*;

public class Stopwatch extends JLayeredPane{
	int x;
	int y;
	int diam;
	ClockHand secondHand;
	ClockHand minuteHand;
	
	public Stopwatch(int x, int y, int diam) {
		this.x = x;
		this.y = y;
		this.diam = diam;
		StopWatchDial dial = new StopWatchDial(0,0,diam);
		this.add(dial);

		secondHand = new ClockHand(diam/2, diam/2, diam/2, 0);
		minuteHand = new ClockHand(diam/2, diam*3/8, diam/2, diam/8);
	}
	
	class HandPanel extends JLayeredPane{
		@Override
		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			secondHand.draw(g2);
			minuteHand.draw(g2);
		}
	}
	
	public void secTick() {
		secondHand.tick();
		this.repaint();
	}
	
	public void minTick() {
		minuteHand.tick();
		this.repaint();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		HandPanel panel = new HandPanel();
		
		super.paintComponent(g2);
		panel.paintComponent(g2);
	}
}










