package cat10.ex4;

import cat10.P109ThreeSum;
import cat10.P110Stopwatch;
import cat10.P119TwoSumFast;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex10442ScaleProblem {
    // TwoSumFast NlogN
    // 1.6s
    // 2^20 1.6s
    // 2^24 2^4 * 1.6 = 51.2
    //   25 102.4
    //   26 204.8
    //   27 409.6
    //   28 819.2
    //   29 1638.4
    //   30 3276.8
    //   31 6553.6(2小时) 2GB的数据量
    // TwoSum N^2
    // 1120s
    // 2^21 4480(1小时半) 2M的数据量
    // ThreeSumFast N^2logN
    // 3267.2s
    // 2^21 6500(2小时多) 2M的数据量
    // 2^21
    // ThreeSum N^3
    // 2^14 1614(半小时) 8K的数据量
    // 2^15 12,913
    // 2^16 103,304
    // 2^17 826,439
    // 2^18 6,611,518
    // 2^19 52,892,144
    // 423137157.74s
    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        P110Stopwatch timer = new P110Stopwatch();
        int cnt = P119TwoSumFast.count(a);
        return timer.elapsedTime();
    }


    public static void main(String[] args) {
        double prev = timeTrial(125);
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            StdOut.printf("%6d %7.1f ", N, time);
            StdOut.printf("%5.1f\n", time/prev);
            prev = time;
        }
    }
}
