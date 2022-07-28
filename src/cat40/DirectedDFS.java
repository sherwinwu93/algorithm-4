package cat40;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/7/7.
 * Single-source reachability?
 * Multiple-source reachability? 从多个点出发能到达的点
 **/
public class DirectedDFS {
    private boolean[] marked;
    private int count;

    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        validateVertex(s);
        dfs(G, s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        validateVertices(sources);
        for (int s : sources) {
            dfs(G, s);
        }
    }

    private void validateVertices(Iterable<Integer> vertices) {
        for (Integer vertex : vertices) {
            if (vertex == null) throw new IllegalArgumentException();
            validateVertex(vertex);
        }
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V) throw new IllegalArgumentException();
    }

    private void dfs(Digraph G, int v) {
        count++;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    public int count() {
        return count;
    }

    public boolean marked(int v) {
        validateVertex(v);
        return marked[v];
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);

        Bag<Integer> sources = new Bag<>();
        for (int i = 1; i < args.length; i++) {
            sources.add(Integer.valueOf(args[i]));
        }

        DirectedDFS dfs = new DirectedDFS(G, sources);
        for (int v = 0; v < G.V(); v++) {
            if (dfs.marked(v)) StdOut.print(v + " ");
        }
        StdOut.println();
    }
}
/**
 * % java DirectedDFS tinyDG.txt 1
 **/
