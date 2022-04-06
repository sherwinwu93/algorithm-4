package cat10.ex4;

import cat10.P110Stopwatch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import lib.PrintUtils;

import java.util.Arrays;

public class Ex10415ThreeSumFast {
    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        Arrays.sort(a);
        P110Stopwatch stopwatch = new P110Stopwatch();
        StdOut.println(count(a));
        StdOut.println(stopwatch.elapsedTime() + "s");
    }
    public static int count(int[] a) {
        int cnt = 0;
        int N = a.length;
        for (int i = 0; i < N; i++)
            for (int j = i + 1,k = N -1;  j < N && j < k; ) {
                int sum = a[i] + a[j] + a[k];
                if (sum < 0) j++;
                else if (sum > 0) k--;
                else {
                    cnt++;
                    j++;
                    k--;
                }
            }
        return cnt;
    }
}
