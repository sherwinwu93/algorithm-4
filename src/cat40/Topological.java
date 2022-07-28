package cat40;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/7/19.
 * use dfs
 **/
public class Topological {
    private Iterable<Integer> order;
    private int[] rank;

    public Topological(Digraph G) {
        DirectedCycle finder = new DirectedCycle(G);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
            rank = new int[G.V()];
            int counter = 0;
            for (int v : order) {
                rank[v] = counter++;
            }
        }
    }
    public Iterable<Integer> order() {
        return order;
    }
    public boolean hasOrder() {
        return order != null;
    }

    public boolean isDAG() {
        return hasOrder();
    }

    public int rank(int v) {
        validateVertex(v);
        return rank[v];
    }
    private void validateVertex(int v) {
        if (v < 0 || v >= rank.length) throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        SymbolDigraph sg = new SymbolDigraph(filename, delimiter);
        Topological topological = new Topological(sg.digraph());
        for (int v : topological.order()) {
            StdOut.println(sg.name(v));
        }
    }
}
