package cat10.ex4;

import cat10.P110Stopwatch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Ex10415TwoSumFaster {
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
        for (int i = 0, j = N - 1; i != j; ) {
            int sum = a[i] + a[j];
            if (sum > 0) j--;
            else if (sum < 0) i++;
            else {
                cnt++;
                i++;
                j--;
            }
        }
        return cnt;
    }
}
