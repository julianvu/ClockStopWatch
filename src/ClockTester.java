import javax.swing.*;
import java.awt.*;

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

		MyClock myClock = new MyClock(0, 0, CLOCK_RADIUS);
		Stopwatch stopwatch = new Stopwatch(0,0,CLOCK_RADIUS);
		BorderLayout layout = new BorderLayout();
		frame.setLayout(layout);
		frame.add(myClock, BorderLayout.CENTER);
		JPanel topNav = new JPanel(new FlowLayout());

        Timer t2 = new Timer(SEC_DELAY, event -> {
            myClock.tick();
            frame.repaint();
        });

		JButton clockButton = new JButton("clock");
		topNav.add(clockButton);
		clockButton.addActionListener(e -> {
            frame.remove(layout.getLayoutComponent(BorderLayout.CENTER));
            frame.add(myClock, BorderLayout.CENTER);
            frame.revalidate();
            frame.repaint();
            t2.restart();
        });
		
		Timer t = new Timer(SEC_DELAY, event -> {
            stopwatch.secTick();
            if (stopwatch.getOuter().getHand().getMinuteCount() > 0) {
                stopwatch.getInner().getHand().tickTo(stopwatch.getOuter().getHand().getMinuteCount());
            }
            frame.repaint();
        });


		
		JButton stopwatchButton = new JButton("stopwatch");
		topNav.add(stopwatchButton);
		stopwatchButton.addActionListener(e -> {
            frame.remove(layout.getLayoutComponent(BorderLayout.CENTER));
            frame.add(stopwatch, BorderLayout.CENTER);
            stopwatch.reset();
            frame.revalidate();
            frame.repaint();

            t.restart();
            });
		
		frame.add(topNav, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
