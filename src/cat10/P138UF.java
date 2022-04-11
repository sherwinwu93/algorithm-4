package cat10;

import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 算法1.5 union-find的实现
 */
public class P138UF {
    // 分量id,触点为索引
    private int[] id;
    private int count;
    public P138UF(int N) {
        count = N;
        id = new int[N];
        // 初始化分量
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
        return id[p];
    }
    public void union(int p, int q) {
        // quick-find
        // quick-union
        // weight-quick-union
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        P138UF uf = new P138UF(N);
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