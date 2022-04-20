package cat20.ex1;

import cat10.P110Stopwatch;
import cat20.P156Selection;
import cat20.P157Insertion;
import cat20.P163Shell;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex20128EqualsKey {
    public static double time(String alg, Double[] a) {
        P110Stopwatch timer = new P110Stopwatch();
        if (alg.equals("selection")) P156Selection.sort(a);
        if (alg.equals("insertion")) P157Insertion.sort(a);
        if (alg.equals("noExchInsertion")) Ex20125NoExchInsertion.sort(a);
        if (alg.equals("shell")) P163Shell.sort(a);
        return timer.elapsedTime();
    }

    /**
     * 输入规模为N,重复T次
     */
    public static double timeEqualsKeyInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++)
                if (StdRandom.bernoulli()) a[i] = 0.;
                else a[i] = 1.;
            total += time(alg, a);
        }
        return total;
    }

    /**
     * % java SortCompare insertion selection 1000 100
     */
    // 选择排序不变 1/2N^2
    // 插入排序1/4N^2
    // 大概是一倍的性能
    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeEqualsKeyInput(alg1, N, T);
        double t2 = timeEqualsKeyInput(alg2, N, T);
        // 1快2慢
        StdOut.printf("For %d random Doubles\n %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }
}
