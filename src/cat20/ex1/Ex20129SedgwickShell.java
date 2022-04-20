package cat20.ex1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Ex20129SedgwickShell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int[] sedgwickSeq = {1, 5, 19, 41, 109, 209, 305, 929, 2161};
        int k = 0;
        while (sedgwickSeq[k] < N)
            k++;
        while (k >= 0) {
            int h = sedgwickSeq[k--];
            for (int i = h; i < N; i++)
                for (int j = i; j >= h && less(a[j], a[j - 1]); j -= h)
                    exch(a, j, j - h);
        }
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
