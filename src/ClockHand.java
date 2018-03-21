import java.awt.*;
import java.awt.geom.Line2D;

public class ClockHand implements MoveableShape, Stroke {
    // instance variables
    private int x1, x2, y1, y2, length;


    public ClockHand(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics2D g2) {
        Line2D.Double hand = new Line2D.Double(x1, y1, x2, y2);
        g2.draw(hand);
    }

    @Override
    public void translate(int dx, int dy) {
        x2 += dx;
        y2 += dy;
    }

    @Override
    public Shape createStrokedShape(Shape p) {
        return null;
    }
}
