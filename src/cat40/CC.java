package cat40;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/7/4.
 * connected components
 **/
public class CC {
    private boolean[] marked;
    private int count;
    private int[] id;
    private int[] size;

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        size = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return id[v] == id[w];
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= marked.length) throw new IllegalArgumentException();
    }

    public int count() {
        return count;
    }

    public int id(int v) {
        validateVertex(v);
        return id[v];
    }

    public int size(int v) {
        validateVertex(v);
        return size[v];
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        CC cc = new CC(G);

        int m = cc.count();
        StdOut.println(m + " components");

        Queue<Integer>[] queues = new Queue[m];
        for (int i = 0; i < m; i++) {
            queues[i] = new Queue<>();
        }

        for (int v = 0; v < G.V(); v++) {
            queues[cc.id(v)].enqueue(v);
        }

        for (int i = 0; i < m; i++) {
            Queue<Integer> queue = queues[i];
            for (int v : queue) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
    }
}
