package cat10.ex5;

import cat10.P142WeightedQuickUnionUF;
import cat10.P145PathCompressionWeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex10503 {
    // < ex10501.txt
    public static void main(String[] args) {
        int N = StdIn.readInt();
        P142WeightedQuickUnionUF uf = new P142WeightedQuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + "components");
    }
}
