package cat10.ex4;

import cat10.P109ThreeSum;
import cat10.P110Stopwatch;
import cat10.P120ThreeSumFast;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex10438DoublingTest {
    public static void main(String[] args) {
        double prev = fasterScale(125);
        for (int N = 250; true; N += N) {
            double fasterScale = fasterScale(N);
            StdOut.printf("%7d %7.1f %5.1f\n", N, fasterScale, fasterScale/prev);
            prev = fasterScale;
        }
    }
    public static double fasterScale(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        P110Stopwatch timer = new P110Stopwatch();
        P109ThreeSum.count(a);
        double time = timer.elapsedTime();
        P110Stopwatch fastTimer = new P110Stopwatch();
        P120ThreeSumFast.count(a);
        double fastTime = fastTimer.elapsedTime();
        return time / fastTime;
    }
}
/**
 *     250     4.0   4.0
 *     500     8.8   2.2
 *    1000    23.2   2.6
 *    2000    39.8   1.7
 *    4000    70.0   1.8
 *    8000    比例越来越大 N/logN
 */
