package ch04;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph graph, int s) {
        marked = new boolean[graph.V()];
        validateVertex(s);
        dfs(graph, s);
    }

    // dfs: 深度优先搜索
    private void dfs(Graph graph, int v) {
        // 搜到了代表连接是通的
        count++;
        // 只会搜索之前不通的点
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                // 递归搜索相邻点
                dfs(graph, w);
            }
        }
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V) throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public boolean marked(int v) {
        validateVertex(v);
        return marked[v];
    }

    public int count() {
        return count;
    }

    /**
     * java largeG.txt 10 内存不够...
     * java mediumG.txt 10
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph graph = new Graph(in);
        int s = Integer.parseInt(args[1]);
        DepthFirstSearch search = new DepthFirstSearch(graph, s);

        for (int v = 0; v < graph.V(); v++) {
            if (search.marked(v))
                StdOut.println(v + " ");
        }
        StdOut.println();
        // 如果连通点数和顶点数相同,则图整体是联通的
        if (search.count() != graph.V()) StdOut.println("NOT connected");
        else StdOut.println("connected");
    }
}
