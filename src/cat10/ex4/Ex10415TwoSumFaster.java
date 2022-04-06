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
        int[] b = new int[N];
        for (int i = 0; i < N; i++)
            b[i] = a[N - 1 - i];
        for (int i = 0, j = 0; i < N && j < N;) {
            int twoSum = a[i] + a[j];
            if (twoSum == 0) {
                cnt++;
                i++;
                j++;
            } else if (twoSum < 0) j++;
            else i++;
        }
        return cnt;
    }
}
