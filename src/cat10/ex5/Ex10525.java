package cat10.ex5;

import cat10.P110Stopwatch;
import cat10.P140QuickFindUF;
import cat10.P142WeightedQuickUnionUF;
import cat10.ex3.Ex10334RandomBag;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex10525 {
    /**
     * quickFind: 比例是16=4^2
     * weightedQuickUnion: 比例是4
     * @param args
     */
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        double prev = timeTrial(T, 2);
        for (int N = 4; true; N+= N) {
            double time = timeTrial(T, N);
            StdOut.printf("%6d %6.1f\n", N, time / prev);
            prev = time;
        }
    }
    public static double timeTrial(int T, int N) {
        double time = 0;
        int M = N *N;
        for (int t = 0; t < T; t++) {
            Ex10518RandomGrid.Connection[] connects = Ex10518RandomGrid.generate(N);
//            P140QuickFindUF uf = new P140QuickFindUF(M );
            P142WeightedQuickUnionUF uf = new P142WeightedQuickUnionUF(M );
            P110Stopwatch timer = new P110Stopwatch();
            int i = 0;
            while (uf.count() != 1) {
                Ex10518RandomGrid.Connection conn1 = connects[StdRandom.uniform(0, M)];
                Ex10518RandomGrid.Connection conn2 = connects[StdRandom.uniform(0, M)];
                int p = conn1.p + conn1.q * N;
                int q = conn2.p + conn2.q * N;
                if (uf.connected(p, q)) continue;
                uf.union(p, q);
//                StdOut.printf("%d-%d %d-%d\n", conn1.p, conn1.q, conn2.p, conn2.q);
            }
            time += timer.elapsedTime();
        }
        return time;
    }
}
