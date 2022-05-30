package cat20;

import lib.PrintUtils;

/**
 * Created by Wusd on 2022/5/30.
 **/
public class P189Quick3way {
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
        Comparable v = a[lo];
        // <的归左边,>的归右边,=的扩大中间
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a,  i++, lt++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }
        // 这里要特别小心,不能取相等的地方
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
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
