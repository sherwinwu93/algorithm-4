package cat20.ex2;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Ex20214MergeSorted {
    public static Comparable[] merge(Comparable[] a, Comparable[] b) {
        int M = a.length;
        int N = b.length;
        int O = M + N;
        Comparable[] c = new Comparable[O];
        for (int i = 0, j = 0, k = 0; k < O; k++) {
            if (i == M) c[k] = b[j++];
            else if (j == N) c[k] = a[i++];
            else if (less(b[j], a[i])) c[k] = b[j++];
            else c[k] = a[i++];
        }
        return c;
    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        Integer[] a = {3,4,6,7};
        Integer[] b = {0,1,2,5};
        Comparable[] c =  merge(a, b);
        StdOut.println(Arrays.toString(c));
    }
}
