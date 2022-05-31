package cat20.ex2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by Wusd on 2022/5/31.
 * 排序大小为N不重复数组,计算大小为0~1和2的子数组的数量
 * 0 N/3
 * 1 N/3
 * 2 N/6
 **/
public class Ex20307 {
    public static void main(String[] args) {
        int N = 1000;
        while (true) {
            Integer[] a = new Integer[N];
            for (int i = 0; i < N; i++)
                a[i] = i;
            sort(a);
            StdOut.printf("%d %d %d %d\n", N, size0Cnt, size1Cnt, size2Cnt);
            N += N;
        }
    }
    private static int size0Cnt;
    private static int size1Cnt;
    private static int size2Cnt;
    public static void sort(Comparable[] a) {
        size0Cnt = 0;
        size1Cnt = 0;
        size2Cnt = 0;
        StdRandom.shuffle(a);
        int N = a.length;
        sort(a, 0, N - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi) {
        int subSize = hi - lo + 1;
        if (subSize == 0) size0Cnt++;
        if (subSize == 1) size1Cnt++;
        if (subSize == 2) size2Cnt++;
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j+1, hi);
    }
    // 将数组切分为a[lo...i-1],a[i],a[i+1...hi]
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
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
