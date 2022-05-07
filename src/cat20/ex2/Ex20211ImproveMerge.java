package cat20.ex2;

import edu.princeton.cs.algs4.StdOut;

public class Ex20211ImproveMerge {

    public static void sort(Comparable[] a) {
        int N = a.length;
        // Comparable[] aux = a; 相同指针
        // Comparable[] aux = a.clone(); 不同指针
        // 解决了第一次aux可能为空的情况
        Comparable[] aux = a.clone();
        sort(aux, a, 0, N - 1);
    }

    /**
     * 在lo到hi中, 从dest排序到src,得到dest[lo...hi]有序
     * @param src 源数组
     * @param dest 目标数组
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] src, Comparable[] dest, int lo, int hi) {
        if (lo >= hi) return;
        if (hi - lo < CUT_OFF) {
            insertion(dest, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        // 在lo到mid中, 从dest排序到src中
        sort(dest, src, lo, mid);
        // 在mid+1到hi中,从dest排序到src中
        sort(dest, src, mid+1, hi);
        // 在lo,mid,hi中,从src归并到dest中
        if (less(dest[mid+1], dest[mid]))
            merge(src, dest, lo, mid, hi);
    }
    private static int CUT_OFF = 3;

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
    public static void merge(Comparable[] src, Comparable[] dest, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        for (int k = lo; k <= hi; k++) {
            // 左半边取尽
            if (i > mid) dest[k] = src[j++];
            // 右半边取尽
            else if (j > hi) dest[k] = src[i++];
            // 右边比左边小
            else if (less(src[j], src[i])) dest[k] = src[j++];
            // 左边小于等于右边
            else dest[k] = src[i++];
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
        sort(a);
        StdOut.println(true + ":" + isSorted(a));
        show(a);
    }
}
