package cat20.ex1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex20117Animation {
    // Selection
//    private static void sort(Comparable[] a) {
//        int N = a.length;
//        for (int i = 0; i < N; i++) {
//            int min = i;
//            for (int j = i + 1; j < N; j++)
//                if (less(a[j], a[min])) min = j;
//            exch(a, min, i);
//            show(a);
//        }
//    }
    // Insertion
    public static void sort(Comparable[] a) {
        /*排序算法*/
        int N = a.length;
        for (int i = 1; i < N; i++)
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
                show(a);
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
    private static void show(Comparable[] b) {
        Double[] a = (Double[]) b;
        int N = a.length;

        StdDraw.clear();
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, 1.0);
        for (int i = 0; i < N; i++)
            StdDraw.filledRectangle(0.5+ i, a[i] / 2, .49, a[i] / 2);
        StdDraw.show(2000);
    }
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }
    /**
     * % more words3.txt
     * % java Example < words.txt
     */
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        sort(a);
        StdOut.println(isSorted(a));
    }
}
