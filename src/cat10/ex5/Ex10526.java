package cat10.ex5;

import cat10.P140QuickFindUF;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

public class Ex10526 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        P140QuickFindUF uf = new P140QuickFindUF(N);
        while (uf.count() != 1) {
            int p = StdRandom.uniform(0, N);
            int q = StdRandom.uniform(0, N);
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
        }
    }
}

class Ex10526QuickFindUF {
    // 分量id,触点为索引
    private int[] id;
    private int count;
    private int cost;
    private int total;

    public Ex10526QuickFindUF(int N) {
        // 初始化分量
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
        cost += 2;
        total += 2;
        return id[p] == id[q];
    }

    public int find(int p) {
        // 很快,只需要访问数组一次
        cost++;
        total++;
        return id[p];
    }

    // 2 + N + (1, N-1)
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) return;
        // 扫描整个id
        for (int i = 0; i < id.length; i++)
        // N + (1,N-1)
        {
            cost++;
            total++;
            if (id[i] == pID) {
                cost++;
                total++;
                id[i] = qID;
            }
        }
        count--;
    }

    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        StdDraw.setXscale(0, M);
        StdDraw.setYscale(0, 2 * N);
        StdDraw.setPenRadius(.001);
        Ex10526QuickFindUF uf = new Ex10526QuickFindUF(N);
        int i = 1;
        while (uf.count() != -1) {
            uf.initCost();
            int p = StdRandom.uniform(0, N);
            int q = StdRandom.uniform(0, N);

            if (!uf.connected(p, q))
                uf.union(p, q);

            StdDraw.setPenColor(Color.DARK_GRAY);
            StdDraw.point(i, uf.cost());
            StdDraw.setPenColor(Color.RED);
            StdDraw.point(i++, uf.total() / i);
        }
    }
}
