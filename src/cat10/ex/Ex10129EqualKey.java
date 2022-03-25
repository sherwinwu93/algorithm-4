package cat10.ex;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Ex10129EqualKey {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return maxRank(key, mid, a);
        }
        return -1;
    }

    private static int maxRank(int key, int equalRank, int[] a) {
        if (equalRank == a.length || a[equalRank + 1] > key) return equalRank;
        else return maxRank(key, equalRank + 1, a);
    }

    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist) > 0)
                StdOut.println(rank(key, whitelist));
        }
    }
}
