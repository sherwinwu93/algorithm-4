package cat40;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/7/1.
 **/
public class BreadthFirstPaths {
    private final static int INFINITY = Integer.MAX_VALUE;

    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];

        validateVertex(s);
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = INFINITY;
        }
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        marked[s] = true;
        distTo[s] = 0;
        Queue<Integer> q = new Queue<>();
        q.enqueue(s);

        while (!q.isEmpty()) {
            int v = q.dequeue();
            marked[v] = true;
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    distTo[w] = distTo[v] + 1;
                    edgeTo[w] = v;
                    q.enqueue(w);
                }
            }
        }
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V) throw new IllegalArgumentException();
    }

    public BreadthFirstPaths(Graph G, Iterable<Integer> sources) {
    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
    }

    public Iterable<Integer> path(int v) {
        Stack<Integer> s = new Stack<>();
        int x;
        for (x = v; distTo(x) != 0; x = edgeTo[x])
            s.push(x);
        s.push(x);
        return s;
    }

    public int distTo(int v) {
        return distTo[v];
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);

        int s = Integer.parseInt(args[1]);
        BreadthFirstPaths bfp = new BreadthFirstPaths(G, s);
        for (int v = 0; v < G.V(); v++) {
            if (bfp.hasPathTo(v)) {
                StdOut.printf("%d to %d (%d): ", s, v, bfp.distTo(v));
                for (int w : bfp.path(v)) {
                    StdOut.print("-" + w);
                }
                StdOut.println();
            } else {
                StdOut.printf("%d to %d: NOT connected\n", s, v);
            }
        }
    }
}