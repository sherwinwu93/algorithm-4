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
        PrintUtils.printArray(a);
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
        int M = N * (N - 1) / 2;
        int[] c = new int[M];
        for (int i = 0, k = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                c[k++] = a[i] + a[j];
        Arrays.sort(c);
        for (int i = 0, j = 0; i < N && j < M;) {
            int threeSum = b[i] + c[j];
            if (threeSum == 0) {
                cnt++;
                i++;
                j++;
            } else if (threeSum < 0) j++;
            else i++;
        }
        return cnt;
    }
}
