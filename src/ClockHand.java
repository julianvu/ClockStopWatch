import java.awt.*;
import java.awt.geom.Line2D;

public class ClockHand implements MoveableShape, Stroke {
    // instance variables
    private double x1, x2, y1, y2, length;
    private int tick;
    private int minuteCount;
    private int hourTick;


    public ClockHand(int x1, int y1, int x2, int y2) {
        this.x1 = x1;   // x-coordinate for center
        this.y1 = y1;   // y-coordinate for center
        this.x2 = x2;
        this.y2 = y2;

        tick = 1;
        hourTick = 1;

        this.length = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
    }

    public double getLength() {
        return this.length;
    }

    public int getMinuteCount() {
        return minuteCount;
    }

    public int getTick() {
        return tick;
    }

    public double getCX() {
        return x1;
    }

    public double getCY() {
        return y1;
    }

    public void tick() {
        if (tick == 60) {
            tick = 0;
            minuteCount++;
        }

        // Calculate angle of rotation - pi/2 since angle is from 0 on unit circle.
        // Subtracting pi/2 from angle of rotation will essentially rotate the clock
        // counter-clockwise by a quarter radian (which is what we want)
        // The quarter rotation puts 0 radians at the top instead of at 3:00
        double theta = tick/60.0 * 2.0 * Math.PI - Math.PI/2;

        // x = rcos(theta), y = rsin(theta)
        setEndPoint(x1 + length * Math.cos(theta), y1 + length * Math.sin(theta));
        tick++;
    }

    public void tickTo(int destination) {
        double theta = destination/60.0 * 2.0 * Math.PI - Math.PI/2;

        // x = rcos(theta), y = rsin(theta)
        setEndPoint(x1 + length * Math.cos(theta), y1 + length * Math.sin(theta));
    }

    public void hourTick() {
        if (hourTick == 12) {
            hourTick = 0;
        }
        double theta = hourTick*5.0/60.0 * 2.0 * Math.PI - Math.PI/2;

        // x = rcos(theta), y = rsin(theta)
        setEndPoint(x1 + length * Math.cos(theta), y1 + length * Math.sin(theta));
        hourTick++;

    }

    @Override
    public void draw(Graphics2D g2) {
        Line2D.Double hand = new Line2D.Double(x1, y1, x2, y2);
        g2.draw(hand);
    }

    @Override
    public void translate(int dx, int dy) {
        x2 = dx;
        y2 = dy;
    }

    public void setEndPoint(double x, double y) {
        x2 = x;
        y2 = y;
    }

    @Override
    public Shape createStrokedShape(Shape p) {
        return null;
    }
}
