package cat20.ex2;

import lib.PrintUtils;

/**
 * Created by Wusd on 2022/5/31.
 * 给出六个含有10个元素的数组,使得Quick.sort()所需的比较次数达到最坏情况
 * 关键是每次切分,总由一个空数组
 **/
// Quick的最坏情况
public class Ex20304 {
    public static void main(String[] args) {
        // 1,2,3,4,5,6,7,8,9,0
        // 9,8,7,6,5,4,3,2,1,0
        // 0,0,0,0,0,0,0,0,0,0
        //全部都加1
        // 1,2,3,4,5,6,7,8,9,0
        // 9,8,7,6,5,4,3,2,1,0
        // 0,0,0,0,0,0,0,0,0,0
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        sort(a, 0, N - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
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
