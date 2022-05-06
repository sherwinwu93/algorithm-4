package cat20.ex2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import lib.MathUtils;

import java.awt.*;

/**
 * 编写程序计算自顶向下和自底向上归并排序访问数组的准确次数
 * 使用整个程序将N=1至512结果绘成曲线图,并将其与上限6NlgN比较
 */
public class Ex20206Merge {
    private static int visitCnt;

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        visitCnt = 0;
        int N = a.length;
        aux = new Comparable[N];
        sort(a, 0, N - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void sortBU(Comparable[] a) {
        visitCnt= 0;
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz += sz)
            for (int lo = 0; lo < N - sz; lo += sz + sz)
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
    }

    // 原地归并的抽象方法
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        visitCnt += hi - lo + 1;
        for (int k = lo; k <= hi; k++) {
            // 左半边用尽
            if (i > mid) {
                a[k] = aux[j++];
                visitCnt += 2;
            }
            // 右半边用尽
            else if (j > hi) {
                a[k] = aux[i++];
                visitCnt += 2;
            }
            // 右边比左边小
            else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
                visitCnt += 4;
            }
            // 左边小于等于右边
            else {
                a[k] = aux[i++];
                visitCnt += 2;
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
        int T = Integer.parseInt(args[0]);

        int Nmax = 512;
        StdDraw.setXscale(0, Nmax);
        StdDraw.setYscale(0, 6 * Nmax * (int) (MathUtils.lg(Nmax)) + 1);
        StdDraw.setPenRadius(.001);
        for (int N = 1; N <= Nmax; N++) {
            StdDraw.setPenColor(Color.RED);
            StdDraw.point(N, 6 * N * MathUtils.lg(N));

            int y = timeRandomInput("merge", N, T);
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.point(N, y);
            int y1 = timeRandomInput("mergeBU", N, T);
            StdDraw.setPenColor(Color.BLUE);
            StdDraw.point(N, y1);
        }
    }

    public static int timeRandomInput(String alg, int N, int T) {
        int total = 0;
        for (int t = 0; t < T; t++) {
            total += timeRandomInput(alg, N);
        }
        return total / T;
    }

    public static int timeRandomInput(String alg, int N) {
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        if (alg.equals("merge")) sort(a);
        if (alg.equals("mergeBU")) sortBU(a);
        return visitCnt;
    }

}
