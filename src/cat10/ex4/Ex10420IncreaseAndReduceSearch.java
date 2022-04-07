package cat10.ex4;

import edu.princeton.cs.algs4.StdOut;

public class Ex10420IncreaseAndReduceSearch {
    public static int rank(int key, int[] a) {
        int maxIndex = maxIndex(a);
        int rank = rank(key, a, 0, maxIndex);
        if (rank != -1) return rank;
        else return rankReverse(key, a, maxIndex + 1, a.length - 1);
    }
    public static int rank(int key, int[] a, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) return mid;
            else if (a[mid] > key) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
    }
    public static int rankReverse(int key, int[] a, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) return mid;
            else if (a[mid] < key) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
    }
    public static int maxIndex(int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > a[mid -1] && a[mid] > a[mid+ 1]) return mid;
            else if (a[mid-1] < a[mid] && a[mid] < a[mid+ 1]) lo = mid;
            else  hi = mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,4, 5, 7, 15, 10, 9, 3, 2};
        if (rank(4, a) != -1)
            StdOut.println(4);
        int[] b = {1,3, 5, 7, 15, 10, 9, 6, 4, 2};
        if (rank(15, b) != -1)
            StdOut.println(15);
    }
}
