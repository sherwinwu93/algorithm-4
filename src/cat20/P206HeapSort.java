package cat20;

import lib.PrintUtils;

/**
 * Created by Wusd on 2022/6/15.
 **/
//经典而优雅
public class P206HeapSort {
    // 2N + 2NlgN
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int k = N / 2; k >= 1; k--)
            sink(a, k, N);

        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }
    private static void sink(Comparable[] a, int k, int N) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && less(a, j, j+1)) j++;
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i -1];
        a[i-1] = a[j-1];
        a[j-1]=t;
    }
    private static boolean less(Comparable[] a, int i, int j) {
        return a[i - 1].compareTo(a[j-1]) < 0;
    }

    public static void main(String[] args) {
        Integer[] a = {3,6,5,4,8,7,1};
        sort(a);
        PrintUtils.printArray(a);
    }
}
