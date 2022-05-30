package cat20;

import lib.PrintUtils;

/**
 * Created by Wusd on 2022/5/30.
 **/
public class P139Quick3way {
    public static void main(String[] args) {
        Integer[] a = {5,4,3,1,2,7,8,6,5};
        sort(a);
        PrintUtils.printArray(a);
    }
    public static void sort(Comparable[] a) {
        int N = a.length;
        sort(a, 0, N - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        while (i <= gt) {

        }
    }
    private static boolean less(Comparable u, Comparable v) {
        return u.compareTo(v) < 0;
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
