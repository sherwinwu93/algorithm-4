package cat10.ex4;

import edu.princeton.cs.algs4.StdOut;

public class Ex10424ThrowEgg {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7,8, 9, 10, 11, 12, 13, 14};
//        double key = Double.parseDouble(args[1]);
        double key = 9.2;
        int g = findG(key, a);
        int rank = rank(key, a, g / 2, g);
        if (rank == -1) rank = g/2 + 1;
        StdOut.println(rank);
    }
    public static int findG(double key,int[] a) {
        int N = a.length;
        int x = 1;
        while (a[x] < key && x * 2 < N) {
            x += x;
        }
        return x;
    }

    public static int rank(double key, int[] a, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) /2;
        if (a[mid] < key && key < a[mid+1]) return mid;
        else if (key < a[mid]) return rank(key, a, lo, mid - 1);
        else return rank(key, a, mid + 1, hi);
    }
}
