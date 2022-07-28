package cat40;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/7/7.
 * Single-source directed paths?
 **/
public class DepthFirstDirectedPaths {
    // 每个点的已访问标记
    private boolean[] marked;
    // 点edgeTo[v]到v组成一条线段.这条线段是从s到v有向路径的最后一条
    // 相当于s是水源,水从s留到v. edgeTo[v],是这条路径的上一个节点.
    // edgeTo默认值是0,那么岂不认为没有访问过上一个点都是0?
    // 可以通过marked避免这个问题!!!
    private int[] edgeTo;
    private final int s;

    public DepthFirstDirectedPaths(Digraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        validateVertex(s);
        dfs(G, s);
    }

    private void validateVertex(int v){
        int V = marked.length;
        if (v < 0 || v >= V) throw new IllegalArgumentException();
    }

    private void dfs(Digraph G, int v) {
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
        Digraph G = new Digraph(in);

        int s = Integer.parseInt(args[1]);
        DepthFirstDirectedPaths dfs = new DepthFirstDirectedPaths(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (dfs.hasPathTo(v)) {
                StdOut.printf("%d to %d: ", s, v);
                for (int x : dfs.pathTo(v)) {
                    if (x == s) StdOut.print(x);
                    else StdOut.print("-" + x);
                }
                StdOut.println();
            } else {
                StdOut.printf("%d to %d: not connected\n", s, v);
            }
        }
    }
}
/**
 * % java DepthFirstDirectedPaths tinyDG.txt 3
 */
