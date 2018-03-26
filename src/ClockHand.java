import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Implementation of a ClockHand
 * Handles calculation of angles
 */
public class ClockHand implements MoveableShape {
    // instance variables
    private double x1, x2, y1, y2, length;
    private int tick;
    private int minuteCount;

    /**
     * Constructor for ClockHand
     * @param x1    x-coordinate for pivot
     * @param y1    y-coordinate for pivot
     * @param x2    x-coordinate for endpoint
     * @param y2    y-coordinate for endpoint
     */
    public ClockHand(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        // Needs to be initialized to 1 so tick() can move hand at first invocation
        tick = 1;

        // Uses distance formula to calculate length between two points
        this.length = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
    }

    /**
     * Gets length of this ClockHand
     * @return  length of this ClockHand
     */
    public double getLength() {
        return this.length;
    }

    /**
     * Gets the number of minutes have passed
     * @return  number of minutes have passed
     */
    public int getMinuteCount() {
        return minuteCount;
    }

    /**
     * Gets number of ticks passed
     * @return  number of ticks passed
     */
    public int getTick() {
        return tick;
    }

    /**
     * Gets x-coordinate of pivot
     * @return  x-coordinate of pivot
     */
    public double getCX() {
        return x1;
    }

    /**
     * Gets y-coordinate of pivot
     * @return  y-coordinate of pivot
     */
    public double getCY() {
        return y1;
    }

    /**
     * Moves hand one unit clockwise.
     * Handles calculation of angle of rotation for this ClockHand
     */
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

    /**
     * Moves hand to particular tick on ClockFace
     * @param destination   tick on ClockFace to which to move this ClockHand
     */
    public void tickTo(int destination) {
        double theta = destination/60.0 * 2.0 * Math.PI - Math.PI/2;

        // x = rcos(theta), y = rsin(theta)
        setEndPoint(x1 + length * Math.cos(theta), y1 + length * Math.sin(theta));
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

    /**
     * Sets the endpoint for this ClockHand
     * @param x x-coordinate for endpoint
     * @param y y-coordinate for endpoint
     */
    public void setEndPoint(double x, double y) {
        x2 = x;
        y2 = y;
    }
}
