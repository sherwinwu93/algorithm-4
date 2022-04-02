package cat10;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class P121DoublingRatio {
    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        P110Stopwatch timer = new P110Stopwatch();
        int cnt = P109ThreeSum.count(a);
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
/*
实验结果
   250     0.0   1.2
   500     0.0   3.8
  1000     0.1   2.8
  2000     0.5   7.4
  4000     3.9   8.1
  8000    31.4   8.1
预测
 16000   254.3  8.1
 */
