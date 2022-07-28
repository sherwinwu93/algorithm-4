package cat40;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/7/6.
 **/
public class Digraph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    // V个背包组成的数组,索引对应的背包都是相应点对应的可达到的顶点的集合.
    private Bag<Integer>[] adj;
    private int[] indegree;


    // create a V-vertex digraph with no edges
    public Digraph(int V) {
        if (V < 0)  throw new IllegalArgumentException();
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int i = 0; i < V; i++)
            adj[i] = new Bag<>();
        indegree = new int[V];
    }

    // read a digraph from input stream in
    public Digraph(In in) {
        int V = in.readInt();
        if (V < 0) throw new IllegalArgumentException();
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException();

        this.V = V;
        adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
        indegree = new int[V];
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }
    // number of vertices
    public  int V() {
        return V;
    }
    // number of edges
    public int E() {
        return E;
    }
    // add edge v->w to this digraph
    public void addEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        indegree[w]++;
        E++;
    }
    private void validateVertex(int v) {
        if (v < 0 || v >= V) throw new IllegalArgumentException();
    }
    // key method!!! from v to ...
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }
    public int outdegree(int v) {
        validateVertex(v);
        return adj[v].size();
    }
    public int indegree(int v) {
        validateVertex(v);
        return indegree[v];
    }

    // reverse digraph
    public Digraph reverse() {
        Digraph reverse = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj[v]) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v  + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph digraph = new Digraph(in);
        StdOut.println(digraph);
    }
}
/**
 * % java Digraph tinyDG.txt
 * 0: 5 1
 * 1:
 * 2: 0 3
 * 3: 5 2
 * 4: 3 2
 * 5: 4
 * 6: 9 4 8 0
 * 7: 6 9
 * 8: 6
 * 9: 11 10
 * 10: 12
 * 11: 4 12
 * 12: 9
 */
