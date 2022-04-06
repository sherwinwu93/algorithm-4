package cat10.ex4;

import cat10.P028BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class Ex10408SamePair {
    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        Stopwatch timer = new Stopwatch();
        int cnt = countFast(a);
        StdOut.println(timer.elapsedTime());
    }
    public static int count(int[] a) {
        int cnt = 0;
        int N = a.length;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                if (a[i] == a[j])
                    cnt++;
        return cnt;
    }
    public static int countFast(int[] a) {
        int cnt = 0;
        Arrays.sort(a);
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int rank = P028BinarySearch.rank(a[i], a);
            for (int j = rank; j < N && a[i] == a[j]; j++)
                if (j != rank) cnt++;
            for (int j = rank-1; j >= 0 && a[i] == a[j]; j--)
                if (j != rank) cnt++;
        }
        return cnt;
    }
}
