package ch04;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.GraphGenerator;
import edu.princeton.cs.algs4.StdOut;

/**
 * 对给定的图G,假设没有平行边,平行边会错误地识别为桥
 *  1. 找出桥的数量
 *  2. 打印出所有的桥
 */
public class Bridge {
    // number of bridges
    private int bridges;
    // counter
    private int cnt;
    // pre[v] = order in which dfs examines v
    // dfs第几次访问v这个顶点
    private int[] pre;
    // low[v] = lowest preorder of any vertex connected to v
    // low[v]是所有与v相连的顶点中,pre最低的值
    private int[] low;
    public Bridge(Graph G) {
        low = new int[G.V()];
        pre = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            low[v] = -1;
            pre[v] = -1;
        }
        for (int v = 0; v < G.V(); v++) {
            if (pre[v] == -1)
                dfs(G, v, v);
        }
    }

    private void dfs(Graph G, int u, int v) {
        pre[v] = cnt++;
        low[v] = pre[v];
        for (int w : G.adj(v)) {
            // unmarked,未被访问过
            if (pre[w] == -1) {
                dfs(G, v, w);
                low[v] = Math.min(low[v], low[w]);
                if (low[w] == pre[w]) {
                    StdOut.println(v + "-" + w + " is a bridge");
                    bridges++;
                }
            }
            // update low number - ignore reverse of edge leading to v
            else if (w != u)
                low[v] = Math.min(low[v], pre[w]);
        }
    }

    public int components() {
        return bridges + 1;
    }

    public static void main(String[] args) {
        int V = Integer.parseInt(args[0]);
        int E = Integer.parseInt(args[1]);
        Graph G = GraphGenerator.simple(V, E);
        StdOut.println(G);

        Bridge bridge = new Bridge(G);
        StdOut.println("Edge connected components = " + bridge.components());
    }
}
