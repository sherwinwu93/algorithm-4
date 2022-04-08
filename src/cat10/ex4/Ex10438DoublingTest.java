package cat10.ex4;

import cat10.P109ThreeSum;
import cat10.P110Stopwatch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex10438DoublingTest {
    public static void main(String[] args) {
        double prev = timeTrial(125);
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            StdOut.printf("%7d %7.1f %5.1f\n", N, time, time/prev);
            prev = time;
        }
    }
    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        P110Stopwatch timer = new P110Stopwatch();
        int count = P109ThreeSum.count(a);
        return timer.elapsedTime();
    }
}
