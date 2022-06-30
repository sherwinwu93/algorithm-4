package cat40;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/6/30.
 * matrix representation.
 **/
public class AdjMatrixGraph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private boolean[][] adj;
    public AdjMatrixGraph(int V) {
        if (V < 0) throw new IllegalArgumentException();
        this.V = V;
        this.E = 0;
        this.adj = new boolean[V][V];
    }

    public AdjMatrixGraph(int V, int E) {
        this(V);
        if (E > (long) V * (V - 1)/2 + V) throw new IllegalArgumentException();
        if (E < 0) throw new IllegalArgumentException();


    }

    public int V() {

    }
    public int E() {

    }
    public void addEdge(int v, int w) {

    }
    public boolean contains(int v, int w) {

    }
    public Iterable<Integer> adj(int v) {

    }
    public String toString() {

    }

    public static void main(String[] args) {
        int V = Integer.parseInt(args[0]);
        int E = Integer.parseInt(args[1]);
        AdjMatrixGraph G = new AdjMatrixGraph(V, E);
        StdOut.println(G);
    }
}
