package cat10;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class P109ThreeSum {
    // 3个数的和是0的对数
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                for (int k = j + 1; k < N; k++)
                    // 执行N*(N-1)*(N-2)/6
                    if (a[i] + a[j] + a[k] == 0)
                        cnt++;
        return cnt;
    }
    // 1Kints: 0.212
    // 2Kints: 1.422
    // 4Kints: 11.325
    // 8Kints: 90s? 90.217 N的三次方
    public static void main(String[] args) {
        P110Stopwatch stopwatch = new P110Stopwatch();
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
        StdOut.println(stopwatch.elapsedTime() + "s");
    }
}
