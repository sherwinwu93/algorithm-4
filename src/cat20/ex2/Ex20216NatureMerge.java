package cat20.ex2;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by Wusd on 2022/5/7.
 * 自然的归并排序
 * 自底向上的归并排序,当需要将两个子数组排序时能够利用数组中已经有序的部分.
 * 1. 首先找到有序的子数组(移动指针直到当前元素比上一个元素小为止),然后再找出另一个并将它们归并.
 * 根据数组大小和递增子数组的最大长度分析算法的运行时间
 *
 * 1. 找出有序的子数组(a,0,hi1)
 * 2. 找到另一个有序的子数组(a, hi1+1, hi2)
 * 3. 归并(a, 0,hi1,hi2)
 * 4. 重复1~3
 * 4. 如果hi1==N, 停止归并
 **/
public class Ex20216NatureMerge {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        int lo1 = 0;
        int hi1 = findSortedHi(a, lo1);
        while (hi1 < N - 1) {
            int hi2 = findSortedHi(a, hi1 + 1);
            merge(a, lo1, hi1, hi2);
            hi1 = findSortedHi(a, lo1);
        }
    }


    private static int findSortedHi(Comparable[] a, int lo) {
        int hi = lo + 1;
        int N = a.length;
        while (true) {
            if (hi == N) break;
            if (less(a[hi], a[hi - 1])) break;
            hi++;
        }
        return hi - 1;
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
//        testFindSortedHi();
        Integer[] a = {3, 6, 7, 2, 4, 1, 0, 5};
        sort(a);
        StdOut.println(Arrays.toString(a));
    }
    public static void testFindSortedHi() {
        Integer[] a = {6, 3, 7, 2, 4, 1, 0, 5};
//        Integer[] a = {0,1,2,3,4,5,6};
        int hi = findSortedHi(a, 0);
        StdOut.println(hi);
    }
}
