import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   This program implements an animation that moves
   a car shape.
 */
public class ClockTester
{
	private static final int CLOCK_RADIUS = 500;
	private static final int SEC_DELAY = 1000;
	private static final int MIN_DELAY = 1000*60;

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();

		ClockFace clockIcon = new ClockFace(0, 0, CLOCK_RADIUS, Type.CLOCK);
		Stopwatch stopwatch = new Stopwatch(0,0,CLOCK_RADIUS);
		BorderLayout layout = new BorderLayout();
		frame.setLayout(layout);
		frame.add(clockIcon, BorderLayout.CENTER);
		JPanel topNav = new JPanel(new FlowLayout());

		
		
		JButton clockButton = new JButton("clock");
		topNav.add(clockButton);
		clockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(layout.getLayoutComponent(BorderLayout.CENTER));
				frame.add(clockIcon, BorderLayout.CENTER);
				frame.revalidate();
				frame.repaint();
			}
		});

		
		
		Timer t = new Timer(SEC_DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				stopwatch.secTick();
				frame.repaint();
			}
		});
		Timer t2 = new Timer(MIN_DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				stopwatch.minTick();
				frame.repaint();
			}
		});
		
		JButton stopwatchButton = new JButton("stopwatch");
		topNav.add(stopwatchButton);
		stopwatchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(layout.getLayoutComponent(BorderLayout.CENTER));
				frame.add(stopwatch, BorderLayout.CENTER);
				frame.revalidate();
				frame.repaint();
			
				t.restart();
				t2.restart();
				}
		});
		
		frame.add(topNav, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
