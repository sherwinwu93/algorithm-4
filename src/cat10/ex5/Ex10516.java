package cat10.ex5;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

public class Ex10516 {
    // 900 < mediumUF.txt
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int N = StdIn.readInt();
        StdDraw.setXscale(0, M);
//        StdDraw.setYscale(0, 2 * N);
        StdDraw.setYscale(0, 100);
        StdDraw.setPenRadius(.001);
//        VisualQuickFindUF uf = new VisualQuickFindUF(N);
        VisualQuickUnionUF uf = new VisualQuickUnionUF(N);
        for (int i = 1; !StdIn.isEmpty(); i++) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            uf.initCost();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                StdOut.println(p + " " + q);
            }
            StdDraw.setPenColor(Color.DARK_GRAY);
            StdDraw.point(i, uf.cost());
            StdDraw.setPenColor(Color.RED);
            StdDraw.point(i, uf.total() / i);
        }
        StdOut.println(uf.count() + "components");
    }
}

class VisualQuickFindUF {
    private int[] id;
    private int count;
    private int cost;
    private int total;

    public VisualQuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        cost++;
        total++;
        return id[p];
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) return;
        for (int i = 0; i < id.length; i++) {
            cost++;
            total++;
            if (id[i] == pID) {
                id[i] = qID;
                cost++;
                total++;
            }
        }
        count--;
    }

    public int count() {
        return count;
    }

    public int cost() {
        return cost;
    }

    public void initCost() {
        cost = 0;
    }

    public int total() {
        return total;
    }
}

class VisualQuickUnionUF {
    private int[] id;
    private int count;
    private int cost;
    private int total;

    public VisualQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public void initCost() {
        cost = 0;
    }

    public int cost() {
        return cost;
    }
    public int total() {
        return total;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        cost++;
        total++;
        while (p != id[p]) {
            cost++;
            total++;
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        cost++;
        total++;
        id[pRoot] = qRoot;
        count--;
    }
}
