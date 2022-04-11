package cat10;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 算法1.5 quick-union的实现
 */
public class P141QuickUnionUF {
    private int[] id;
    private int count;
    // 分量id,触点为索引
    public P141QuickUnionUF(int N) {
        count = N;
        // 初始化分量
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }
    public int count() {
        return count;
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    public int find(int p) {
        while (id[p] != p) p = id[p];
        return p;
    }
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        P141QuickUnionUF uf = new P141QuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count + "components");
    }
}
/**
 * more tinyUF.txt
 * more mediumUF.txt
 * more largeUF.txt 这是我们的目标
 * 算法分析: 不同算法访问任意数组元素的总次数上
 **/