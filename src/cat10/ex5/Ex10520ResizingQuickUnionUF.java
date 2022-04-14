package cat10.ex5;

import cat10.P140QuickFindUF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 算法1.5 quick-union的实现
 */
public class Ex10520ResizingQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int decreaseCount;
    private int newSite;

    public Ex10520ResizingQuickUnionUF() {
        int N = 2;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++)
            sz[i] = 1;
    }

    public int newSite() {
        return newSite;
    }

    public int count() {
        return newSite - decreaseCount;
    }

    public boolean connected(int p, int q) {
        if (p >= newSite || q >= newSite) return false;
        return find(p) == find(q);
    }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        if (p >= id.length)
            resize(2 * p);
        if (q >= id.length)
            resize(2 * q);
        if (p >= newSite) newSite = p + 1;
        if (q >= newSite) newSite = q + 1;
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        decreaseCount++;
    }

    private void resize(int max) {
        int[] tempId = id;
        int[] tempSz = sz;
        id = new int[max];
        sz = new int[max];
        for (int i = 0; i < newSite; i++) {
            id[i] = tempId[i];
            sz[i] = tempSz[i];
        }
        for (int i = newSite; i < max; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        Ex10520ResizingQuickUnionUF uf = new Ex10520ResizingQuickUnionUF();
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
/**
 *
 **/