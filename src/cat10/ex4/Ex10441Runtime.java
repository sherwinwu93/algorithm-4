package cat10.ex4;

import cat10.*;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex10441Runtime {
    // TwoSumFast NlogN
    // 1.6s
    // TwoSum N^2
    // 1120s
    // ThreeSumFast N^2logN
    // 3267.2s
    // ThreeSum N^3
    // 423137157.74s
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
        double prev = timeTrial(125);
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            StdOut.printf("%6d %7.1f ", N, time);
            StdOut.printf("%5.1f\n", time/prev);
            prev = time;
        }
    }
}
