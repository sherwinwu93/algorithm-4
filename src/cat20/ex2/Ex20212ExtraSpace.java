package cat20.ex2;

import edu.princeton.cs.algs4.StdOut;

/**
 * 将数组分成N/M块.
 * 实现一个归并方法,使之所需的额外空间减少到max(M, N/M)
 * 1. 将块看作一个元素,将块的第一个元素作为块的主键,用选择排序将块排序
 * 2. 遍历数组,将第一块和第二块归并,完成后将第二块和第三块归并.等等
 */
public class Ex20212ExtraSpace {
    private static Comparable[] aux;

    public static void sort(Comparable[] a, int M) {
        int N = a.length;
        aux = new Comparable[N];
        for (int i = 0; i < N; i += M)
            selection(a, i, Math.min(i + M - 1, N - 1));
        for (int sz = M; sz < N; sz += M)
            for (int lo = 0; lo < N - sz; lo += sz + sz)
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
    }

    public static void selection(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            int min = i;
            for (int j = i + 1; j <= hi; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, min, i);
        }
    }

    // 原地归并的抽象方法
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
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
//        String[] a = In.readStrings();
        Integer[] a = {6,5,3,7,0,4,2,1};
        sort(a, 3);
        StdOut.println(true + ":" + isSorted(a));
        show(a);
    }
}
