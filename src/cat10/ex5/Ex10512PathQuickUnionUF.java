package cat10.ex5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 算法1.5 quick-union的实现
 */
public class Ex10512PathQuickUnionUF {
    private int[] id;
    private int count;
    // 分量id,触点为索引
    public Ex10512PathQuickUnionUF(int N) {
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
        int pRoot = p;
        while (id[pRoot] != pRoot) pRoot = id[pRoot];
        for (int nextP; p != pRoot; p = nextP) {
            nextP = id[p];
            id[p] = pRoot;
        }
        return pRoot;
    }
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }

    // 1<-2,3 union 4<-5<-6
    public static void main(String[] args) {
        int N = StdIn.readInt();
        Ex10512PathQuickUnionUF uf = new Ex10512PathQuickUnionUF(N);
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