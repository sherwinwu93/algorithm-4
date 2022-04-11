package cat10.ex4;

import cat10.P109ThreeSum;
import cat10.P110Stopwatch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 改进倍率测试的精度
 */
public class Ex10439DoublingRatio {
    public static double timeTrial(int N, int times) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        P110Stopwatch timer = new P110Stopwatch();
        for (int i = 0; i< times; i++)
            P109ThreeSum.count(a);
        return timer.elapsedTime() /times;
    }


    public static void main(String[] args) {
        int times = Integer.parseInt(args[0]);
        double prev = timeTrial(125, times);
        for (int N = 250; true; N += N) {
            double time = timeTrial(N, times);
            StdOut.printf("%6d %7.1f ", N, time);
            StdOut.printf("%5.1f\n", time/prev);
            prev = time;
        }
    }
}
/**
 * java cat10.ex4.Ex10439DoublingRatio 10
 *    250     0.0   0.9
 *    500     0.0   6.5
 *   1000     0.0   5.3
 *   2000     0.4   7.8
 *   4000     2.8   7.5
 * java cat10.ex4.Ex10439DoublingRatio 100
 *    250     0.0   3.5
 *    500     0.0   7.0
 *   1000     0.0   7.3
 *   2000     0.4   7.8
 *   4000     2.8   7.5
 * java cat10.ex4.Ex10439DoublingRatio 1000
 *
 * ----------------------------------
 * 运行次数越多,就越快收敛到8
 */
