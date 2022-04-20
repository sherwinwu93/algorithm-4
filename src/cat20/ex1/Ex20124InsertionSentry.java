package cat20.ex1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Ex20124InsertionSentry {
    public static void sort(Comparable[] a) {
        int N = a.length;
        // 先找出最小元素置于数组最左边
        for (int i = 1; i < N; i++) {
            minSentry(a, i);
            for (int j = i; ; j--)
                if (less(a[j], a[j - 1])) exch(a, j, j - 1);
                else break;
        }
    }
    // 这是一种常见的规避边界测试的方法,能够省略判断条件的元素称为哨兵
    private static void minSentry(Comparable[] a, int j) {
        int min = j;
        for (int i = 0; i < j; i++)
            if (less(a[i], a[min])) min = i;
        exch(a, min, 0);
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

    /**
     * % more words3.txt
     * % java Example < words.txt
     * @param args
     */
    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        StdOut.println(true + ":" + isSorted(a));
        show(a);
    }
}
