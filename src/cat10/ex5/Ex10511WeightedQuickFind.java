package cat10.ex5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex10511WeightedQuickFind {
    private int[] id;
    private int[] sz;
    private int count;
    public Ex10511WeightedQuickFind(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++)
            sz[i] = 1;
    }
    public int find(int p) {
        return id[p];
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    // 会减少一点数组的写入,但没有太大变化
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) return;
        int pSize = sz[pID];
        int qSize = sz[qID];
        if (pSize < qSize)
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pID) id[i] = qID;
                sz[qID] = pSize + qSize;
            }
        else for (int i = 0; i < id.length; i++) {
            if (id[i] == qID) id[i] = pID;
            sz[pID] = pSize + qSize;
        }
        count--;
    }
    public int count() {
        return count;
    }
    public static void main(String[] args) {
        int N = StdIn.readInt();
        Ex10511WeightedQuickFind uf = new Ex10511WeightedQuickFind(N);
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
