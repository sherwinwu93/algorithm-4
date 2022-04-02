package cat10;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class P120TwoSum {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                if (a[i] + a[j] == 0)
                    cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        P110Stopwatch stopwatch = new P110Stopwatch();
        StdOut.println(count(a));
        StdOut.println(stopwatch.elapsedTime() + "s");
    }
}
