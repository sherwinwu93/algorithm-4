package cat10.ex5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Ex10516 {
    // < ex10501.txt
    public static void main(String[] args) {
        In in = new In(args[0]);
        int N = in.readInt();
//        QuickFindUF uf = new QuickFindUF(N);
        QuickUnionUF uf = new QuickUnionUF(N);
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + "components");
    }
}