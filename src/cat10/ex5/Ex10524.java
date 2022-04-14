package cat10.ex5;

import cat10.P110Stopwatch;
import cat10.P142WeightedQuickUnionUF;
import cat10.P145PathCompressionWeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex10524 {
    /**
     * weighted用的时间/pathCompress的时间大约为1~2倍.
     * 实际使用几乎无法分辨
     * @param args
     */
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        for (int N = 250; true; N += N) {
            double weightedQuickUnionTime = weightedQuickUnionTimeTrial(T, N);
            double pathCompressionWeightedQuickUnionTime = pathCompressionWeightedQuickUnionTimeTrial(T, N);
            StdOut.printf("%6d %5.2f\n", N, weightedQuickUnionTime / pathCompressionWeightedQuickUnionTime);
        }
    }

    public static double weightedQuickUnionTimeTrial(int T, int N) {
        double time = 0;
        for (int t = 0; t < T; t++) {
            P142WeightedQuickUnionUF uf = new P142WeightedQuickUnionUF(N);
            P110Stopwatch timer = new P110Stopwatch();
            while (uf.count() != 1) {
                int p = StdRandom.uniform(0, N);
                int q = StdRandom.uniform(0, N);
                if (uf.connected(p, q)) continue;
                uf.union(p, q);
            }
            time += timer.elapsedTime();
        }
        return time;
    }

    public static double pathCompressionWeightedQuickUnionTimeTrial(int T, int N) {
        double time = 0;
        for (int t = 0; t < T; t++) {
            P145PathCompressionWeightedQuickUnionUF uf = new P145PathCompressionWeightedQuickUnionUF(N);
            P110Stopwatch timer = new P110Stopwatch();
            while (uf.count() != 1) {
                int p = StdRandom.uniform(0, N);
                int q = StdRandom.uniform(0, N);
                if (uf.connected(p, q)) continue;
                uf.union(p, q);
            }
            time += timer.elapsedTime();
        }
        return time;
    }
}
