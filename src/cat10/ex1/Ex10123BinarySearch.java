package cat10.ex1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Ex10123BinarySearch {
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }

    private static int rank(int key, int[] a, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (lo > hi) return -1;
        else if (key < a[mid]) return rank(key, a, lo, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi);
        else return mid;
    }

    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        String op = args[1];
        boolean needRanked = false;
        if (op.equals("+")) needRanked = true;
        else if (op.equals("-")) needRanked = false;
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (needRanked && rank(key, whitelist) >= 0)
                StdOut.println(key);
            else if (!needRanked && rank(key, whitelist) < 0)
                StdOut.println(key);
        }
    }
}
