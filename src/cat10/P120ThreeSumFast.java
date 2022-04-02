package cat10;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class P120ThreeSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                if (P028BinarySearch.rank(-a[i] - a[j], a) > j)
                    cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        P110Stopwatch stopwatch = new P110Stopwatch();
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
        StdOut.println(stopwatch.elapsedTime() + "s");
    }
}
