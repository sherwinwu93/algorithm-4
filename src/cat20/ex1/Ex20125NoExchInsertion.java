package cat20.ex1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Ex20125NoExchInsertion {
    // 并没有改变,新的exch仍然访问了两次数组
    public static void sort(Comparable[] a) {
        /*排序算法*/
        int N = a.length;
        for (int i = 1; i < N; i++) {
            Comparable item = a[i];
            for (int j = i - 1; j > 0; j--) {
                if (less(item, a[j])) a[j+1] = a[j];
                else a[j + 1] = item;
            }
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
     * @param args
     */
    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        StdOut.println(true + ":" + isSorted(a));
        show(a);
    }
}
