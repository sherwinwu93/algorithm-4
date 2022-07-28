package cat40;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/7/19.
 **/
public class KosarajuSharirSCC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSharirSCC(Digraph G) {
        DepthFirstOrder dfs = new DepthFirstOrder(G.reverse());

        marked = new boolean[G.V()];
        id = new int[G.V()];
        // 反向G的拓扑序
        for (int v : dfs.reversePost()) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }
    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for(int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }
    public int count() {
        return count;
    }
    public boolean stronglyConnected(int v, int w){
        validateVertex(v);
        validateVertex(w);
        return id[v] == id[w];
    }
    private void validateVertex(int v) {
        if (v < 0 || v >= marked.length) throw new IllegalArgumentException();
    }
    public int id(int v) {
        validateVertex(v);
        return id[v];
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        KosarajuSharirSCC scc = new KosarajuSharirSCC(G);

        int m = scc.count();
        StdOut.println(m + " strong components");

        Queue<Integer>[] components = new Queue[m];
        for (int i = 0; i < m; i++) {
            components[i]= new Queue<>();
        }
        for (int v = 0; v < G.V(); v++) {
            components[scc.id(v)].enqueue(v);
        }
        for (int i = 0; i < m; i++) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
    }
}
