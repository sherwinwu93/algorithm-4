package cat10.ex4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Ex10416NearestPair {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] a = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(0.0, 10.0);
        }
        // O(NlogN)
        Arrays.sort(a);
        int minIndex = 1;
        double minDiff = Math.abs(a[1] - a[0]);
        for (int i = 1; i < N; i++) {
            double diff = Math.abs(a[i] - a[i - 1]);
            if (diff < minDiff) {
                minIndex = i;
                minDiff = diff;
            }
        }
        StdOut.printf("%5.8f %5.8f\n", a[minIndex - 1], a[minIndex]);
    }
}
