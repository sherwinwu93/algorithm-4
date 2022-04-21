package cat20;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class P175MergeBU {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz += sz)
            for (int lo = 0; lo < N - sz;lo += sz + sz)
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz -1, N - 1));
    }

    // 原地归并的抽象方法
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++)
            // 左半边用尽
            if (i > mid) a[k] = aux[j++];
                // 右半边用尽
            else if (j > hi) a[k] = aux[i++];
                // 右边比左边小
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
                // 左边小于等于右边
            else a[k] = aux[i++];
    }

    /**
     * 将数组操作限制在less和exch,便于阅读以及移植
     * 软约束
     */
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
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        StdOut.println(true + ":" + isSorted(a));
        show(a);
    }
}
