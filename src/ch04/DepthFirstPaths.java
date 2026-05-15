package ch04;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class DepthFirstPaths {
    // marked[v] = is there an s-v path?
    private boolean[] marked;
    // edgeTo[w],去w的线段,哈哈哈
    // edgeTo[v] = last edge on s-v path
    private int[] edgeTo;
    // source vertex
    private final int s;

    public DepthFirstPaths(Graph graph, int s) {
        this.s = s;
        edgeTo = new int[graph.V()];
        marked = new boolean[graph.V()];
        validateVertex(s);
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        // 找到所有相邻点
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V) throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    /**
     * java largeG.txt 10 内存不够...
     * java mediumG.txt 10
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph graph = new Graph(in);
        int s = Integer.parseInt(args[1]);
        DepthFirstPaths dfs = new DepthFirstPaths(graph, s);

        for (int v = 0; v < graph.V(); v++) {
            if (dfs.hasPathTo(v)) {
                StdOut.printf("%d to %d: ", s, v);
                for (int x : dfs.pathTo(v)) {
                    if (x == s) StdOut.print("-" + x);
                    else StdOut.print("-" + x);
                }
                StdOut.println();
            } else {
                StdOut.printf("%d to %d: not connected\n", s, v);
            }
        }
    }
}
