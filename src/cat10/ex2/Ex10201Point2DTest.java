package cat10.ex2;

import edu.princeton.cs.algs4.*;

public class Ex10201Point2DTest {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        Interval1D xinterval = new Interval1D(0, 1.);
        Interval1D yinterval = new Interval1D(0, 1.);
        Interval2D box = new Interval2D(xinterval, yinterval);
        box.draw();

        Point2D[] ps = new Point2D[N];
        for (int i = 0; i < N; i++) {
            Point2D p = new Point2D(StdRandom.uniform(), StdRandom.uniform());
            ps[i] = p;
            p.draw();
        }
        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < N - 1; i++)
            for (int j = i + 1; j < N; j++) {
                double distance = ps[i].distanceTo(ps[j]);
                if (minDistance > distance)
                    minDistance = distance;
            }
        StdOut.println(minDistance);
    }
}
