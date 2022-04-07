package cat10.ex4;

import edu.princeton.cs.algs4.StdOut;

public class Ex10423RationalBinarySearch {
    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int rankP = rank(p, a);
        int rankQ = rank(q, a);
        StdOut.println(rankP + "/" + rankQ);
    }
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }
    private static int rank(int key, int[] a, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key > a[mid]) return rank(key, a, mid + 1, hi);
        else if (key < a[mid]) return rank(key, a, lo, mid - 1);
        else return mid;
    }
}
