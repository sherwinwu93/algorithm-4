package cat20.ex2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 自底向上的有序队列归并排序
 */
public class Ex20215Merge {
    public static void sort(Comparable[] a) {
        int N = a.length;
        Queue<Comparable[]> queues = new Queue<Comparable[]>();
        for (int i = 0; i < N; i++) {
            Comparable[] sub = new Comparable[1];
            sub[0] = a[i];
            queues.enqueue(sub);
        }
        // 不断将队列的头两个元素归并,直接队列的队列只剩下一个元素
        while (queues.size() > 1) {
            int sz = queues.size();
            for (int i = 0; i < sz / 2; i++) {
                Comparable[] sub1 = queues.dequeue();
                Comparable[] sub2 = queues.dequeue();
                queues.enqueue(Ex20214MergeSorted.merge(sub1, sub2));
            }
            if (sz % 2 != 0) queues.enqueue(queues.dequeue());
        }
        Comparable[] arr = queues.dequeue();
        for (int i = 0; i < N; i++)
            a[i] = arr[i];
    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
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
    public static void main(String[] args) {
        Integer[] a = {3,6,7,2,4,1,0,5};
        sort(a);
        StdOut.println(Arrays.toString(a));
    }
}
