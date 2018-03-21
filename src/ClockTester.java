import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   This program implements an animation that moves
   a car shape.
*/
public class ClockTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      
      ClockFace clockIcon = new ClockFace(0, 0, CLOCK_RADIUS);
      StopWatchDial stopwatchIcon = new StopWatchDial(0,0,CLOCK_RADIUS);
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
      
      JButton stopwatchButton = new JButton("stopwatch");
      topNav.add(stopwatchButton);
      stopwatchButton.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		  frame.remove(layout.getLayoutComponent(BorderLayout.CENTER));
    		  frame.add(stopwatchIcon, BorderLayout.CENTER);
    		  frame.revalidate();
    		  frame.repaint();
    	  }
      });
      
      frame.add(topNav, BorderLayout.NORTH);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      
   }

   private static final int CLOCK_RADIUS = 500;
}
