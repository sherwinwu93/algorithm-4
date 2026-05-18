package ch04;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 使用dfs解决图是否存在环
 *  返回是否存在环
 *  返回环
 */
public class Cycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;

    public Cycle(Graph graph) {
        // need special case to identify parallel edges as a cycle
        // 平行边: e1: v-w, e2: v-w
        if (hasParallelEdges(graph)) return;

        // don't need special case to identify self-loops as a cycle
        // 自环: e1: v-v
//        if (hasSelfLoop(graph)) return;

        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        for (int v = 0; v < graph.V(); v++) {
            if (!marked[v])
                dfs(graph, -1, v);
        }
    }

    private void dfs(Graph graph, int u, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            // short circuit if cycle already found
            if (cycle != null) return;

            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, v, w);
            }
            // check for cycle(but disregard reverse of edge leading to v)
            else if (w != u) {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
    }

    private boolean hasSelfLoop(Graph graph) {
        for (int v = 0; v < graph.V(); v++) {
            for (int w: graph.adj(v)) {
                if (v == w) {
                    cycle = new Stack<>();
                    cycle.push(v);
                    cycle.push(v);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 是否有平行边
     *  挨个检查每个点,对这个点,检查相邻点并标记,如果遇到重复的点,则说明平行边,返回true
     */
    private boolean hasParallelEdges(Graph graph) {
        marked = new boolean[graph.V()];

        for (int v = 0; v < graph.V(); v++) {
            // check for parallel edges incident(相连) to v
            for (int w : graph.adj(v)) {
                if (marked[w]) {
                    cycle = new Stack<>();
                    cycle.push(v);
                    cycle.push(w);
                    cycle.push(v);
                    return true;
                }
                marked[w] = true;
            }

            // reset so marked[v = false for all v
            for (int w : graph.adj(v)) {
                marked[w] = false;
            }
        }
        return false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    /**
     * 读取图,如果有环,则输出环;没有则告知
     * @param args
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph graph = new Graph(in);
        Cycle finder = new Cycle(graph);
        if (finder.hasCycle()) {
            for (int v : finder.cycle()) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        } else {
            StdOut.println("Graph is acyclic");
        }
    }
}
