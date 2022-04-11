package cat10.ex4;

import cat10.P110Stopwatch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex10440 {
    // t: 为一次内循环的时间
    //1: (16*MAX) * t
    //N: N(16*MAX) * t
    public static void main(String[] args) {
        int times = Integer.parseInt(args[0]);
        double prev = timeTrial(125, times);
        for (int N = 250; true; N+= N) {
            double time = timeTrial(N, times);
            StdOut.printf("%7d %5.1f %5.1f\n", N, time, time/prev);
            prev = time;
        }
    }
    public static double timeTrial(int N, int times) {
        int MAX = 1000000;
        P110Stopwatch timer = new P110Stopwatch();
        for (int i = 0; i < times; i++)
            while (N > 0) {
                int x = StdRandom.uniform(-MAX, MAX);
                int y = StdRandom.uniform(-MAX, MAX);
                int z = StdRandom.uniform(-MAX, MAX);
                if (x + y + z == 0) N--;
            }
        return timer.elapsedTime() / times;
    }
}
/**
 *  java cat10.ex4.Ex10440 10
 *     500   3.8   2.2
 *    1000   7.7   2.0
 *    2000  14.8   1.9
 *    4000  29.6   2.0
 *    8000  57.9   2.0
 *   16000 115.7   2.0
 // t: 为一次内循环的时间
 //1: (16*MAX) * t
 //N: N(16*MAX) * t
 */
