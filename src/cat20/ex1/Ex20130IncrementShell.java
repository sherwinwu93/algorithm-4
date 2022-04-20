package cat20.ex1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import lib.PrintUtils;

public class Ex20130IncrementShell {
    /**
     * N=10^6的随机数组
     * 递增序列: 1, t, t^2, t^3, t^4
     * 给出最佳t值,以及对应的递增序列
     * @param a
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        int[] seq = seq(N);
        PrintUtils.printArray(seq);
        int k = 0;
        while (seq[k] < N)
            k++;
        while (k >= 0) {
            int h = seq[k--];
            for (int i = h; i < N; i++)
                for (int j = i; j >= h && less(a[j], a[j - 1]); j -= h)
                    exch(a, j, j - h);
        }
    }
    private static int[] seq(int N) {
        int tValue = 2;
        int n = 0;
        while (Math.pow(tValue, n) < N)
            n++;
        int[] seq = new int[++n];
        for (int i = 0; i < n; i++)
            seq[i] = (int) Math.pow(tValue, i);
        return seq;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        StdOut.println(true + ":" + isSorted(a));
        show(a);
    }

}
