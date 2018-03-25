import java.awt.*;
import java.awt.geom.Line2D;

public class ClockHand implements MoveableShape {
    // instance variables
    private double x1, x2, y1, y2, length;


    public ClockHand(double x1, double y1, double length) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1;
        this.y2 = y1 - length;
    }

    @Override
    public void draw(Graphics2D g2) {
        Line2D.Double hand = new Line2D.Double(x1, y1, x2, y2);
        Stroke stroke = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1f);
        g2.setStroke(stroke);
        g2.setColor(Color.BLACK);
        g2.draw(hand);
    }

    @Override
    public void translate(int dx, int dy) {
        this.x2 += dx;
        this.y2 += dy;
    }
}
