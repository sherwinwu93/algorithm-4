package cat20.ex2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by Wusd on 2022/5/31.
 * 编写代码来计算Cn的准确值,在N=100~1000和10000的情况下比较准确值和估计值2NlnN的差距
 **/
// 期望的比较次数
public class Ex20306 {
    // 100 789 1328 -539
    // 1000 11863 19931 -8068
    // 10000 160966 265754 -104788
    // 比估计值要少个39%左右
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++)
            a[i] = i;
        StdRandom.shuffle(a);
        sort(a);
        int expected = (int) (2 * N * Math.log(N)/Math.log(2));
        StdOut.printf("%d %d %d", cn,  expected, cn - expected);
    }
    public static int cn;
    public static void sort(Comparable[] a) {
        int N = a.length;
        sort(a, 0, N - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi) {
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
        cn++;
        return u.compareTo(v) < 0;
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
