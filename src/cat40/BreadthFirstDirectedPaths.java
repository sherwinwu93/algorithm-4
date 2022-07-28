package cat40;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/7/18.
 * Single-source shortest directed paths
 **/
public class BreadthFirstDirectedPaths {
    private final static int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;

    public BreadthFirstDirectedPaths(Digraph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
            distTo[v] = INFINITY;
        validateVertex(s);
        bfs(G, s);
    }
    public BreadthFirstDirectedPaths(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
            distTo[v] = INFINITY;
        validateVertices(sources);
        bfs(G, sources);
    }
    private void validateVertices(Iterable<Integer> sources) {
        for (Integer s : sources) {
            if (s == null) throw new IllegalArgumentException();
            validateVertex(s);
        }
    }
    private void bfs(Digraph G, Iterable<Integer> sources) {
        Queue<Integer> q = new Queue<>();
        for (int s : sources) {
            marked[s] = true;
            distTo[s] = 0;
            q.enqueue(s);
        }
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    q.enqueue(w);
                }
            }
        }
    }
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V) throw new IllegalArgumentException();
    }
    private void bfs(Digraph G, int s) {
        Queue<Integer> q = new Queue<>();
        marked[s] = true;
        distTo[s] = 0;
        q.enqueue(s);
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w]= distTo[v] + 1;
                    q.enqueue(w);
                }
            }
        }
    }
    public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
    }
    // 从s到v的最短距离,也就是线段的数量
    public int distTo(int v){
        validateVertex(v);
        return distTo[v];
    }
    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);

        int s = Integer.parseInt(args[1]);
        BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (bfs.hasPathTo(v)) {
                StdOut.printf("%d to %d (%d): ", s, v, bfs.distTo(v));
                for (int x : bfs.pathTo(v)) {
                    if (x == s) StdOut.print(x);
                    else StdOut.print("->" + x); // 不愧是大师
                }
                StdOut.println();
            }
            else {
                StdOut.printf("%d to %d (-): not connected\n", s, v);
            }
        }
    }
}
