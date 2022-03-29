package cat10.ex1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import lib.PrintUtils;

import java.util.Arrays;

public class Ex10128DeleteRepetition {
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

    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        int[] noRepetitionWhitelist = new int[whitelist.length];
        noRepetitionWhitelist[0] = whitelist[0];
        for (int i = 1, offset = 0; i < whitelist.length; i++) {
            if (whitelist[i] == noRepetitionWhitelist[i - offset - 1])
                offset++;
            else noRepetitionWhitelist[i - offset] = whitelist[i];
        }
        PrintUtils.printArray(noRepetitionWhitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, noRepetitionWhitelist) < 0)
                StdOut.println(key);
        }
    }
}
