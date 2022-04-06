package cat10.ex4;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static cat10.P111DoublingTest.timeTrial;

public class Ex10403VisualDoublingTest {
    private final List<Point2D> points = new ArrayList<Point2D>();
    private int xMax;
    private double yMax;

    //见P111DoublingTest
    public Ex10403VisualDoublingTest() {
        StdDraw.setCanvasSize(500, 500);
        StdDraw.setPenRadius(.005);
        StdDraw.setPenColor(Color.BLUE);
        xMax = 50;
        yMax = 5;
        initScale();
    }
    private void initScale() {
        StdDraw.clear();
        StdDraw.setXscale(0, xMax);
        StdDraw.setYscale(0, yMax);
    }

    public void draw(double N, double time) {
        rescaleIfNecessary(N, time);
        Point2D point = new Point2D(N, time);
        draw(point);
    }
    private void draw(Point2D point) {
        int size = points.size();
        if (!points.isEmpty()) {
            Point2D previousPoint = points.get(size - 1);
            drawLine(previousPoint, point);
        }
        drawPoint(point);
        points.add(point);
    }
    private void rescaleIfNecessary(double N, double time) {
        if (N < xMax && time < yMax) return;
        if (N > xMax) {
            if (2 * xMax > N) xMax = 2* xMax;
            else xMax = (int) (1.5 * N);
        }
        if (time > yMax) yMax = 2 * yMax;
        initScale();
        int size = points.size();
        for (int i = 0; i < size; i++)
            drawPoint(points.get(i));
        for (int i = 1; i < size; i++)
            drawLine(points.get(i - 1), points.get(i));
    }
    private void drawPoint(Point2D point) {
        StdDraw.point(point.x(), point.y());
    }
    private void drawLine(Point2D previousPoint, Point2D point) {
        StdDraw.line(previousPoint.x(), previousPoint.y(), point.x(), point.y());
    }

    public static void main(String[] args) {
        Ex10403VisualDoublingTest visual = new Ex10403VisualDoublingTest();
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N, time);
            visual.draw(N, time);
        }
    }
}