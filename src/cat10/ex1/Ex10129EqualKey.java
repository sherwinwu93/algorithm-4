package cat10.ex1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Ex10129EqualKey {
    // 等值键
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    private static int maxRank(int key, int[] a) {
        int rank = rank(key, a);
        while (rank < a.length - 1 && a[rank + 1] == key)
            rank++;
        return rank;
    }

    private static int count(int key, int[] a) {
        int rank = rank(key, a);
        while (rank > 0 && a[rank - 1] == key)
            rank++;
        return rank;
    }

    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            StdOut.println(maxRank(key, whitelist));
            StdOut.println(count(key, whitelist));
        }
    }
}
