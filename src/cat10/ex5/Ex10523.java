package cat10.ex5;

import cat10.P110Stopwatch;
import cat10.P140QuickFindUF;
import cat10.P141QuickUnionUF;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex10523 {
    /**
     * 具体用例中 quick-find比quick-union要快
     * 因为要频繁检查connected()
     * @param args
     */
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        for (int N = 250; true; N+= N) {
            double quickFindTime = quickFindTimeTrial(T, N);
            double quickUnionTime = quickUnionTimeTrial(T, N);
            StdOut.printf("%6d %5.2f\n", N, quickFindTime / quickUnionTime);
        }
    }
    public static double quickFindTimeTrial(int T, int N) {
        double time = 0;
        for (int t = 0; t < T; t++) {
            P140QuickFindUF uf = new P140QuickFindUF(N);
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
    public static double quickUnionTimeTrial(int T, int N) {
        double time = 0;
        for (int t = 0; t < T; t++) {
            P141QuickUnionUF uf = new P141QuickUnionUF(N);
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
