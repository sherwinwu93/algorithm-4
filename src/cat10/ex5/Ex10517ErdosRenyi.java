package cat10.ex5;

import cat10.P142WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex10517ErdosRenyi {
    // 100 200~300
    // 10 10~20
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int count = count(N);
        StdOut.println(count);
    }
    public static int count(int N) {
        int count = 0;
        P142WeightedQuickUnionUF uf = new P142WeightedQuickUnionUF(N);
        while (uf.count() != 1) {
            int p = StdRandom.uniform(0, N);
            int q = StdRandom.uniform(0, N);
            count++;
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
        }
        return count;
    }
    public static boolean connected(P142WeightedQuickUnionUF uf, int[] id) {
        int id0 = id[0];
        for (int i = 1; i < id.length; i++)
            if (!uf.connected(id0, id[i])) return false;
        return true;
    }
}
