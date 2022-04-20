package cat20.ex1;

import cat10.P110Stopwatch;
import cat20.P156Selection;
import cat20.P157Insertion;
import cat20.P163Shell;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import lib.MathUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ex20132RunningTimeVisual {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[1]);
        int T = Integer.parseInt(args[2]);
        rescale();
        for (; true; N += N) {
            double x = MathUtils.log2(N);
            double y0 = MathUtils.log2(100000000 * time("selection", N, T));
            double y1 = MathUtils.log2(100000000 * time("insertion", N, T));
            double y2 = MathUtils.log2(100000000 * time("shell", N, T));
            StdOut.println(x + ":" + y0);
            StdOut.println(x + ":" + y1);
            StdOut.println(x + ":" + y2);
            StdOut.println();
            draw(x, y0, 0);
            draw(x, y1, 1);
            draw(x, y2, 2);
        }
    }

    public static double time(String alg, int N, int T) {
        double total = .0;
        for (int t = 0; t < T; t++) {
            Double[] a = new Double[N];
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            P110Stopwatch timer = new P110Stopwatch();
            sort(alg, a);
            total += timer.elapsedTime();
        }
        return total / T;
    }

    public static void sort(String alg, Comparable[] a) {
        if (alg.equals("selection")) P156Selection.sort(a);
        if (alg.equals("insertion")) P157Insertion.sort(a);
        if (alg.equals("shell")) P163Shell.sort(a);
    }

    private static List<List<Point2D>> psList = new ArrayList<List<Point2D>>();
    private static Color[] colors = {Color.GRAY, Color.BLACK, Color.RED};
    private static double xMax = 5;
    private static double yMax = 10;
    private static void draw(double x, double y, int alg) {
        rescaleIfNecessary(x, y, alg);
        Point2D p = new Point2D(x, y);
        List<Point2D> list = psList.get(alg);
        if (!list.isEmpty()) drawLine(list.get(list.size() - 1), p, alg);
        list.add(p);
    }
    private static void drawLine(Point2D previousP, Point2D p, int alg) {
        StdDraw.setPenColor(colors[alg]);
        StdDraw.line(previousP.x(), previousP.y(), p.x(), p.y());
    }
    private static void rescaleIfNecessary(double x, double y, int alg) {
        if (xMax < x) xMax = 1.5 * x;
        if (yMax < y) yMax = 1.5 * y;
        rescale();
        redrawLines();
    }
    private static void redrawLines() {
        while (psList.size() <= 2) psList.add(new ArrayList<Point2D>());
        for (int j = 0; j < psList.size(); j++) {
            List<Point2D> list = psList.get(j);
            int N = list.size();
            for (int i = N - 1; i >= 1; i--)
                drawLine(list.get(i - 1), list.get(i), j);
        }
    }
    private static void rescale() {
        StdDraw.clear();
        StdDraw.setPenRadius(.005);
        StdDraw.setXscale(0, xMax);
        StdDraw.setYscale(0, yMax);
    }
}