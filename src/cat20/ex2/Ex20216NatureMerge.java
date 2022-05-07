package cat20.ex2;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by Wusd on 2022/5/7.
 * 自然的归并排序
 * 自底向上的归并排序,当需要将两个子数组排序时能够利用数组中已经有序的部分.
 * 1. 首先找到有序的子数组(移动指针直到当前元素比上一个元素小为止),然后再找出另一个并将它们归并.
 * 根据数组大小和递增子数组的最大长度分析算法的运行时间
 **/
public class Ex20216NatureMerge {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        sort(a, 0, N - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        int subLo = lo;
        while (subLo <= hi) {
            subLo = lo;
            int mid = sortedHi(a, subLo);
            int subHi = sortedHi(a, mid + 1);
            merge(a, subLo, mid, subHi);
            subLo = subHi + 1;
        }
    }

    private static int sortedHi(Comparable[] a, int lo) {
        int hi = lo;
        for (int i = lo; i < a.length - 1; i++)
            if(less(a[i+1], a[i])) return hi;
            else hi = i;
        return hi;
    }

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

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        Integer[] a = {3, 6, 7, 2, 4, 1, 0, 5};
        sort(a);
        StdOut.println(Arrays.toString(a));
    }
}
