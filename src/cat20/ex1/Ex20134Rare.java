package cat20.ex1;

import cat20.P153Example;
import cat20.P157Insertion;
import cat20.P163Shell;
import edu.princeton.cs.algs4.StdOut;

public class Ex20134Rare {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        sorted(N);
        reverseSorted(N);
        equalsKey(N);
        twoKeys(N);
    }
    public static void sorted(int N) {
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++)
            a[i] = i;
        P157Insertion.sort(a);
        StdOut.println(P153Example.isSorted(a));
    }
    public static void reverseSorted(int N) {
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++)
            a[i] = N - 1 - i;
        P163Shell.sort(a);
        StdOut.println(P153Example.isSorted(a));
    }
    public static void equalsKey(int N) {
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++)
            a[i] = 0;
        P157Insertion.sort(a);
        StdOut.println(P153Example.isSorted(a));
    }
    public static void twoKeys(int N) {
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++)
            a[i] = 0;
        P163Shell.sort(a);
        StdOut.println(P153Example.isSorted(a));
    }
}
