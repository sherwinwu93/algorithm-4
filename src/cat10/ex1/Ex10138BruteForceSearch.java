package cat10.ex1;

import cat10.P028BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class Ex10138BruteForceSearch {
    public static int rank(int key, int[] a) {
        int N = a.length;
        int rank = -1;
        for (int i = 0; i < N; i++)
            if (key ==a[i]) {
                rank = i;
                break;
            }
        return rank;
    }

    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        Stopwatch stopwatch = new Stopwatch();
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (P028BinarySearch.rank(key, whitelist) < 0)
                StdOut.println(key);
        }
        StdOut.println(stopwatch.elapsedTime());
    }
}
