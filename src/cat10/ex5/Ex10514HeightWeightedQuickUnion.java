package cat10.ex5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex10514HeightWeightedQuickUnion {
    private int[] id;
    private int[] sz;
    private int count;

    public Ex10514HeightWeightedQuickUnion(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++)
            sz[i] = 0;
    }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) return;
        int pIDsz = sz[pID];
        int qIDsz = sz[qID];
        if (pIDsz < qIDsz) id[pID] = qID;
        else if (pIDsz > qIDsz) id[qID] = pID;
        else {
            id[qID] = pID;
            sz[pID]++;
        }
        count--;
    }
    public int count() {
        return count;
    }

    // 证明
    // 假设i<=j, i+j=k
    // union(i, j)时, H = lgi + 1 或 lgj
    // lgi + 1 = lg(i+i) <= lgk
    // lgj < lgk
    // 所以 N个触点的树高度小于lgN
    public static void main(String[] args) {
        int N = StdIn.readInt();
        Ex10514HeightWeightedQuickUnion uf = new Ex10514HeightWeightedQuickUnion(N);
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
