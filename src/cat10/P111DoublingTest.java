package cat10;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import lib.MathUtils;

public class P111DoublingTest {
    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        P110Stopwatch timer = new P110Stopwatch();
        int cnt = P109ThreeSum.count(a);
        return timer.elapsedTime();
    }
    public static void main(String[] args) {
        P095Queue<Double> queue = new P095Queue<Double>();
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        StdDraw.setPenRadius(.01);
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N, time);
            queue.enqueue(time);
            StdDraw.clear();
            int times = queue.size();
            for (int i = 1; i <= times; i++) {
                double t = queue.dequeue();
                queue.enqueue(t);
                double y = t / time;
                double x = 1.0 * i / times;
                StdDraw.point(x, y);
            }
        }
    }
}
