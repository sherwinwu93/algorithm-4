package ch04;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * 连通分量:
 *  对给定的Graph图,
 *      返回连通分量的个数,
 *      对给定的点,返回其连通分量的id
 *      对给定的点,返回其所在连通分量的大小
 *      对给定的两点,返回其是否相连,即在同一连通分量中
 *  实现: 对每个点dfs, 如果没有被marked,则说明是新的连通分量,count+1,id+1
 */
public class CC {
    // marked[v] = has vertex v been marked?
    private boolean[] marked;
    // id[v] = id of connected component containing v
    private int[] id;
    // size[id] = number of vertices in given component
    private int[] size;
    // number of connected components
    private int count;
    /**
     * Computes the connected components of the undirected graph.
     */
    public CC(Graph graph) {
        marked = new boolean[graph.V()];
        id = new int[graph.V()];
        size = new int[graph.V()];
        // 这里的逻辑是,前面已经marked了,只要没有被marked,就是新的连通分量,就进行dfs
        for (int v = 0; v < graph.V(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
                // 为什么在这里count++,因为如果没有marked[v]时,说明有新的联通分量,这时候才+1
                count++;
            }
        }
    }
//    public CC(Edge) {}
    private void dfs(Graph graph, int v) {
        marked[v] = true;
        // 这时候count就是id,从0开始
        id[v] = count;
        size[count]++;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    /**
     * Returns the id of the connected component containing vertex v.
     */
    public int id(int v) {
        validateVertex(v);
        return id[v];
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
        }
    }

    /**
     * Return the number of vertices in the connected component containing vertex v.
     */
    public int size(int v) {
        validateVertex(v);
        // 先获取component,再获取component的size
        return size[id[v]];
    }

    /**
     * Return the number of connected components in the graph.
     */
    public int count() {
        return count;
    }

    /**
     * Returns true if v and w are in the same connected component.
     */
    public boolean connected(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return id[v] == id[w];
    }

    /**
     * java mediumG.txt
     * @param args
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph graph = new Graph(in);
        CC cc = new CC(graph);

        int m = cc.count();
        StdOut.println(m + " components");

        // compute list of vertices in each connected component
        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[m];
        for (int i = 0; i < m; i++) {
            components[i] = new Queue<>();
        }
        for (int v = 0; v < graph.V(); v++) {
            components[cc.id(v)].enqueue(v);
        }
        // print results
        for (int i = 0; i < m; i++) {
            StdOut.print(i + ": ");
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
    }
}
