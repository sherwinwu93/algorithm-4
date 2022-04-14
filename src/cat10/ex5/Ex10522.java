package cat10.ex5;

import cat10.P110Stopwatch;
import cat10.P140QuickFindUF;
import cat10.P141QuickUnionUF;
import cat10.P142WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex10522 {
    /**
     * QuickFind: 比值接近于4
     * QuickUnion: 比值接近于4
     * WeightedQuickUnion: 比值接近于2
     *
     *
     * 前面几次实验失败,都是因为包括了初始化的时间
     * @param args
     */
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        double prev = timeTrial(T, 125);
        for (int N = 250; true; N+= N) {
            double time = timeTrial(T, N);
            StdOut.printf("%6d %6d %6.1f\n", N, countTrial(T, N), time / prev);
            prev = time;
        }
    }
    public static int countTrial(int T, int N) {
        int count = 0;
        for (int i = 0; i < T; i++) {
//            P140QuickFindUF uf = new P140QuickFindUF(N);
//            P141QuickUnionUF uf = new P141QuickUnionUF(N);
            P142WeightedQuickUnionUF uf = new P142WeightedQuickUnionUF(N);
            while (uf.count() != 1) {
                int p = StdRandom.uniform(0, N);
                int q = StdRandom.uniform(0, N);
                if (uf.connected(p, q)) continue;
                uf.union(p, q);
                count++;
            }
        }
        return count;
    }

    public static double timeTrial(int T, int N) {
        double time = 0;
        for (int i = 0; i < T; i++) {
//            P140QuickFindUF uf = new P140QuickFindUF(N);
//            P141QuickUnionUF uf = new P141QuickUnionUF(N);
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
        return time / T;
    }
}
