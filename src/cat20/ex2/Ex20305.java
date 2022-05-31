package cat20.ex2;

import lib.PrintUtils;

/**
 * Created by Wusd on 2022/5/31.
 * 给出一段代码将已知只有两种主键值的数组排序
 **/
public class Ex20305 {
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
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Integer[] a = {2,1,2,2,1,2,1,2};
        sort(a);
        PrintUtils.printArray(a);
    }
}
