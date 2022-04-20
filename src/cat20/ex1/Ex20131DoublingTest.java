package cat20.ex1;

import cat10.P110Stopwatch;
import cat20.P156Selection;
import cat20.P157Insertion;
import cat20.P163Shell;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 各种用于评估排序算法的测试用例
 * 使用随机数据增进对性能特性的理解
 */
public class Ex20131DoublingTest {
    /**
     * java cat20.ex1.Ex20131DoublingTest shell 100
     *    128 0.0001     0.6
     *    256 0.0001     1.0
     *    512 0.0001     2.0
     *   1024 0.0002     1.9
     *   2048 0.0006     2.9
     *   4096 0.0008     1.5
     *   8192 0.0020     2.5
     *  16384 0.0047     2.3
     *  N^(3/2)
     */
    public static void main(String[] args) {
        String alg = args[0];
        int T = Integer.parseInt(args[1]);
        double prev = time(alg, 64, T);
        for (int N = 128; true; N+= N) {
            double time = time(alg, N, T);
            StdOut.printf("%6d %6.4f %7.1f\n", N, time, time / prev);
            prev = time;
        }
    }
    public static double time(String alg, int N, int T) {
        double total = .0;
        for (int t = 0; t < T; t++) {
            Double[] a = new Double[N];
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            P110Stopwatch timer = new P110Stopwatch();
            sort(alg, a);
            total += timer.elapsedTime();
        }
        return total / T;
    }
    public static void sort(String alg, Comparable[] a) {
        if (alg.equals("selection")) P156Selection.sort(a);
        if (alg.equals("insertion")) P157Insertion.sort(a);
        if (alg.equals("shell")) P163Shell.sort(a);
    }
}
