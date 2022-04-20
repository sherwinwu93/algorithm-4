package cat20.ex1;

import cat10.P110Stopwatch;
import cat20.P157Insertion;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex20126Insertion {
    public static void sort(int[] a) {
        /*排序算法*/
        int N = a.length;
        for (int i = 1; i < N; i++)
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
    }

    /**
     * 将数组操作限制在less和exch,便于阅读以及移植
     * 软约束
     */
    private static boolean less(int v, int w) {
        return v < w;
    }
    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static double time(String alg, Integer[] a) {
        int[] aa = new int[a.length];
        for (int i = 0; i< a.length; i++)
            aa[i] = i;
        P110Stopwatch timer = new P110Stopwatch();
        if (alg.equals("insertion")) P157Insertion.sort(a);
        if (alg.equals("oInsertion")) sort(aa);
        return timer.elapsedTime();
    }

    /**
     * 输入规模为N,重复T次
     */
    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Integer[] a = new Integer[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform(0, N);
            total += time(alg, a);
        }
        return total;
    }

    /**
     * % java SortCompare oInsertion insertion 1000 100
     * 快了大概10^2
     */
    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        // 1快2慢
        StdOut.printf("For %d random Doubles\n %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }
}
