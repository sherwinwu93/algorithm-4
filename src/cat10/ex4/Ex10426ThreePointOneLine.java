package cat10.ex4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;

public class Ex10426ThreePointOneLine {
    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        int N = a.length;
        Point2D[] points = new Point2D[N];
        for (int i = 0; i < N; i++)
            points[i] = new Point2D(a[i], a[i] * a[i] * a[i]);
        StdOut.println(countThreePointOneLine(points));
    }
    public static int countThreePointOneLine(Point2D[] points) {
        return 0;
    }
}
