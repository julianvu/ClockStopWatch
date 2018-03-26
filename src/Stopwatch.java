import javax.swing.*;
import java.awt.*;

/**
 * Implementation of a Stopwatch.
 * Aggregates two StopWatchDials
 */
public class Stopwatch extends JPanel{
	// Instance variables
	private int x;
	private int y;
	private int diam;
	private StopWatchDial outer;
	private StopWatchDial inner;

	/**
	 * Constructor for Stopwatches
	 * @param x	x-coordinate
	 * @param y	y-coordinate
	 * @param diam	diameter
	 */
	public Stopwatch(int x, int y, int diam) {
		this.x = x;
		this.y = y;
		this.diam = diam;
		this.setBackground(Color.BLUE);
		
		outer = new StopWatchDial(0,0,diam);
		inner = new StopWatchDial(0, diam/8, diam/2);
		inner.setPreferredSize(new Dimension(diam/2, diam*3/4));
		outer.add(inner);
		this.add(outer);
	}

	/**
	 * Moves seconds hand one unit clockwise
	 */
	public void secTick() {
		outer.dialTick();
	}

	/**
	 * Resets all hand positions back to 0
	 */
	public void reset() {
		outer.dialReset();
		inner.dialReset();
	}

	/**
	 * Gets outer StopWatchDial
	 * @return	outer StopWatchDial
	 */
	public StopWatchDial getOuter() {
		return outer;
	}

	/**
	 * Gets inner StopWatchDial
	 * @return	inner StopWatchDial
	 */
	public StopWatchDial getInner() {
		return inner;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
	}
}