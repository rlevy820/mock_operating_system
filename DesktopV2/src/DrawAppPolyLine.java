import java.awt.*;
import java.util.ArrayList;

public class DrawAppPolyLine {
    private ArrayList<Integer> xList, yList; // list of x coords and y coords

    public DrawAppPolyLine() {
        xList = new ArrayList<Integer>();
        yList = new ArrayList<Integer>();
    }

    public void addPoint(int x, int y) {
        xList.add(x);
        yList.add(y);
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        for(int i = 0; i < xList.size() - 1; i++) {
            g2.drawLine((int) xList.get(i), (int) yList.get(i), (int) xList.get(i + 1), (int) yList.get(i + 1));
        }
    }
}
