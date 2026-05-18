package ch04;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Graph;

/**
 * 二色图: 把顶点分为true或false的颜色, 如果顶点v和w相邻,那么其颜色不能相同
 *  对于给定的图:
 *      1. 是否是二色图,(没有奇环)
 *      2. 返回某个点的颜色(归属阵营),注意颜色只会在同连通分量中比较
 *      3. 如果不是二色图,就返回奇环
 *  实现: dfs时,标注颜色,相邻的点且颜色相同,则说明其不是二色图
 */
public class Bipartite {
    // is the graph bipartite?
    private boolean isBipartite;
    // color[v] gives vertices on one sid eof bipartition
    private boolean[] color;
    // marked[v] = true if v has been visited in DFS
    private boolean[] marked;
    private int[] edgeTo;
    // odd-length cycle
    private Stack<Integer> cycle;
    /**
     * Determines whether an undirected graph is bipartite
     *  and finds either a bipartition or an odd-length cylce.
     * @param graph
     */
    public Bipartite(Graph graph) {
        isBipartite = true;
        color = new boolean[graph.V()];
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];

        for (int v = 0; v < graph.V(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
            }
        }
        assert check(graph);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            // short circuit if odd-length cycle found
            if (cycle != null) return;

            // found uncolored vertex, so recur
            if (!marked[w]) {
                // 路径
                edgeTo[w] = v;
                // 颜色
                color[w] = !color[v];
                dfs(graph, w);
            }
            // if v-w create and odd-length cycle, find it
            // 相邻颜色相同,则说明其是奇数环
            else if (color[w] == color[v]) {
                isBipartite = false;
                cycle = new Stack<>();
                cycle.push(w); // don't need this unless you want to include start vertex twice
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
            }
        }
    }

    /**
     * Returns true if the graph is bipartite.
     * @return
     */
    public boolean isBipartite() {
        return isBipartite;
    }

    /**
     * Returns the side of the bipartite that vertex is on
     * @param v
     * @return
     */
    public boolean color(int v) {
        validateVertex(v);
        if (!isBipartite)
            throw new UnsupportedOperationException("graph is not bipartite");
        return color[v];
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
        }
    }

    /**
     * Returns an odd-length cycle if the graph is not bipartite,
     *  and null otherwise.
     * @return
     */
    public Iterable<Integer> oddCycle() {
        return cycle;
    }

    private boolean check(Graph graph) {
        if (isBipartite) {
            for (int v = 0; v < graph.V(); v++) {
                for (int w : graph.adj(v)) {
                    if (color[v] == color[w]) {
                        System.err.printf("edge %d-%d with %d and %d in the same side of bipartition\n", v, w, v, w);
                        return false;
                    }
                }
            }
        }
        // graph has an odd-length cycle
        else {
            int first = -1, last = -1;
            for (int v : oddCycle()) {
                if (first == -1) first = v;
                last = v;
            }
            if (first != last) {
                System.err.printf("cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }
        return true;
    }

    /**
     * java 10 10 20 5: 10个点的color为true, 10个点的color为false, 20条边, 再随机连5条边
     *
     */
    public static void main(String[] args) {
        int V1 = Integer.parseInt(args[0]);
        int V2 = Integer.parseInt(args[1]);
        int E = Integer.parseInt(args[2]);
        int F = Integer.parseInt(args[3]);

        edu.princeton.cs.algs4.Graph graph = GraphGenerator.bipartite(V1, V2, E);
        for (int i = 0; i < F; i++) {
            int v = StdRandom.uniform(V1 + V2);
            int w = StdRandom.uniform(V1 + V2);
            graph.addEdge(v, w);
        }
        StdOut.println(graph);

        Bipartite b = new Bipartite(graph);
        if (b.isBipartite()) {
            StdOut.println("Graph is bipartite");
            for (int v = 0; v < graph.V(); v++) {
                StdOut.println(v + ": " + b.color(v));
            }
        } else {
            StdOut.print("Graph has an odd-length cycle:");
            for (int x : b.oddCycle()) {
                StdOut.print(x + " ");
            }
            StdOut.println();
        }
    }
}
