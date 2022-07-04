package cat40;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * Created by Wusd on 2022/7/1.
 **/
public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo; // s = edgeTo[v] means s to v
    private final int s;  // source vertex

    public DepthFirstPaths(Graph G, int s) {
        this.s = s;
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        validateVertex(s);
        dfs(G, s);
    }
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V) throw new IllegalArgumentException();
    }
    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
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
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        int s = Integer.parseInt(args[1]);
        DepthFirstPaths dfp = new DepthFirstPaths(G, s);
        for (int v = 0; v < G.V(); v++) {
            StdOut.printf("%d to %d: ", s, v);
            if (dfp.hasPathTo(v)) {
                for (int x : dfp.pathTo(v)) {
                    StdOut.print("-" + x);
                }
                StdOut.println();
            } else {
                StdOut.println("NOT connected");
            }
        }
    }
}
