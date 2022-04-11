package cat10;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 算法1.5 quick-find的实现
 */
public class P140QuickFindUF {
    // 分量id,触点为索引
    private int[] id;
    private int count;
    public P140QuickFindUF(int N) {
        // 初始化分量
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }
    public int count() {
        return count;
    }
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }
    public int find(int p) {
        // 很快,只需要访问数组一次
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
            if (id[i] == pID) id[i] = qID;
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        P140QuickFindUF uf = new P140QuickFindUF(N);
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
 * more tinyUF.txt
 * more mediumUF.txt
 * more largeUF.txt 这是我们的目标
 * 算法分析: 不同算法访问任意数组元素的总次数上
 **/