package cat10;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class P119TwoSumFast {
    // 线性对数解决TwoSum问题
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            // 1. j = -1,不计数
            // 2. j > i, 那么a[i] + a[j] = 0, a[j] > a[i]计数
            // 3. j < i, 那么重复了,比如a[1],a[3] 和 a[3],a[1]
            if (P028BinarySearch.rank(-a[i], a) > i)
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
