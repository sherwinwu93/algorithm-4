package cat10.ex4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex10417RemotestPair {
    // O(N)
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] a = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(0.0, 10.0);
        }
        double min = a[0];
        double max = a[0];
        for (int i = 0; i < N; i++) {
            if (a[i] < min) min = a[i];
            if (a[i] > max) max = a[i];
        }
        StdOut.printf("%5.6f %5.6f\n", min, max);
    }
}
