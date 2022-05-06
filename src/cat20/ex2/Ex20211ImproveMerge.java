package cat20.ex2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Ex20211ImproveMerge {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        sort(a, 0, N - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        //1.加快小数组的排序速度
        if (hi - lo < 7) {
            insertion(a, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        Comparable[] temp = a;
        a = aux;
        aux = temp;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        temp = a;
        a = aux;
        aux = temp;
        merge(a, lo, mid, hi);
    }

    private static void insertion(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            for (int j = i; j > lo; j--)
                if (less(a[j], a[j - 1])) exch(a, j - 1, j);
                else break;
    }

    public static void testInsertion(String[] args) {
        Integer[] a = {8, 4, 3, 2, 7, 5};
        insertion(a, 2, 5);
        StdOut.println();
    }

    // 原地归并的抽象方法
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        // 检测数组是否已经有序
        if (!less(a[mid + 1], a[mid])) return;
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            // 左半边用尽
            if (i > mid) a[k] = aux[j++];
                // 右半边用尽
            else if (j > hi) a[k] = aux[i++];
                // 右边比左边小
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
                // 左边小于等于右边
            else a[k] = aux[i++];
        }
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
