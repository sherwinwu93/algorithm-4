package cat10;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class P110Stopwatch {
    private final long start;
    public P110Stopwatch() {
        start = System.currentTimeMillis();
    }
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(- 1000000, 1000000);
        P110Stopwatch timer = new P110Stopwatch();
        int cnt = P109ThreeSum.count(a);
        double time = timer.elapsedTime();
        StdOut.println(cnt + " triples " + time + " seconds");
    }
}
