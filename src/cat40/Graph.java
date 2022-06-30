package cat40;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by Wusd on 2022/6/30.
 **/
public class Graph {
    private final static String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException();
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++)
            adj[i] = new Bag<>();
    }

    public Graph(In in) {
        if (in == null) throw new IllegalArgumentException();
        int V = in.readInt();
        if (V < 0) throw new IllegalArgumentException();
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++)
            adj[i] = new Bag<>();
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            validateVertex(v);
            validateVertex(w);
            addEdge(v, w);
        }
    }

    public Graph(Graph G) {
        this.V = G.V;
        this.E = G.E;

        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++)
            adj[i] = new Bag<>();
        for (int v = 0; v < G.V; v++) {
            Stack<Integer> reverse = new Stack<>();
            for (int w : G.adj(v)) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }
    private void validateVertex(int v) {
        if (v < 0 || v >= V) throw new IllegalArgumentException();
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int degree(int v) {
        return adj[v].size();
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("number of vertices : " + V + ",");
        s.append("number of edges : " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + " : ");
            for (int w : adj[v])
                s.append(w + " ");
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        StdOut.println(G);
    }
}
