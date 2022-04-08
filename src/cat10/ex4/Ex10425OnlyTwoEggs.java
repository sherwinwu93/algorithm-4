package cat10.ex4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import lib.PrintUtils;

import java.util.Arrays;

public class Ex10425OnlyTwoEggs {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double key = Double.parseDouble(args[1]);
        double[] a = new double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(0, 100.0);
        Arrays.sort(a);
        PrintUtils.printArray(a);
        int g = findG(key, a);
        StdOut.println(g);
        StdOut.println(rank(key, a, (g-1)*(g-1) + 1, g*g));
    }

    public static int findG(double key, double[] a) {
        int N = a.length;
        int g = 0;
        while (a[g * g] < key && g * g < N)
            g++;
        return g;
    }

    public static int rank(double key, double[] a, int lo, int hi) {
        int N = a.length - 1;
        if (lo >= N - 1) return N;
        if (lo > hi) return -1;
        if (a[lo] >= key) return lo - 1;
        else return rank(key, a, lo + 2, hi);
    }
}
