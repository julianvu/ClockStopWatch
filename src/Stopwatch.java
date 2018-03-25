import java.awt.*;

import javax.swing.*;

public class Stopwatch extends JPanel{
	int x;
	int y;
	int diam;
	StopWatchDial outer;
	StopWatchDial inner;
	
	public Stopwatch(int x, int y, int diam) {
		this.x = x;
		this.y = y;
		this.diam = diam;
		
		outer = new StopWatchDial(0,0,diam);
		inner = new StopWatchDial(0,diam/2,diam/2);
		//inner.setPreferredSize(new Dimension(diam, diam));
		outer.add(inner);
		this.add(outer);
	}
	
	public void secTick() {
		outer.dialTick();
	}
	
	public void minTick() {
		inner.dialTick();
	}
	
	public void reset() {
		outer.dialReset();
		inner.dialReset();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
	}
}