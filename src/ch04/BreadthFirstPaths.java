package ch04;

import edu.princeton.cs.algs4.*;

/**
 * 宽度优先路径
 * 对于给的图G和点s
 *  distTo[v]: s到v的距离
 *  hasPathTo[v]: s到v有路径
 *  pathTo[v]: s到v的最短路径
 * 实现方式:
 *  1. 把v加入队列
 *  2. v出列, 再把v的没有被访问过的相邻点加入队列,为这些相邻点设定距离,和到s的路径
 *      !!!v的没有被访问过的相邻点,这样才能保证路径最短. 因为被访问过,则说明这个点有更短的路径
 *  3. 循环,直到所有点都被遍历了
 */
public class BreadthFirstPaths {
    private static final int INFINITY = Integer.MAX_VALUE;
    // marked[v] = is there a s-v path?
    private boolean[] marked;
    // edgeTo[v] = previous edge on shortest s-v path
    private int[] edgeTo;
    // distTo = distanceTo
    // distTo[v] = number of edges shortest s-v path
    private int[] distTo;

    public BreadthFirstPaths(Graph graph, int s) {
        marked = new boolean[graph.V()];
        distTo = new int[graph.V()];
        edgeTo = new int[graph.V()];
        validateVertex(s);
        bfs(graph, s);

//        assert check(graph, s);
    }

    // breadth-first search from a single source
    private void bfs(Graph graph, int s) {
        Queue<Integer> queue = new Queue<>();
        for (int v = 0; v < graph.V(); v++) {
            distTo[v] = INFINITY;
        }
        distTo[s] = 0;
        marked[s] = true;
        queue.enqueue(s);

        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w: graph.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V) throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public BreadthFirstPaths(Graph graph, Iterable<Integer> sources) {

    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
    }

    public int distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }

    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        int x;
        for(x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph graph = new Graph(in);

        int s = Integer.parseInt(args[1]);
        BreadthFirstPaths bfs = new BreadthFirstPaths(graph, s);

        for (int v = 0; v < graph.V(); v++) {
            if (bfs.hasPathTo(v)) {
                StdOut.printf("%s to %d (%d): ", s, v, bfs.distTo(v));
                for (int x : bfs.pathTo(v)) {
                    StdOut.printf("-" + x);
                }
                StdOut.println();
            } else {
                StdOut.printf("%s to %d: not connected\n", s, v);
            }
        }
    }

//    private boolean check(Graph graph, int s) {
//        if (distTo[s] != 0) {
//            StdOut.println("distance of source " + s + " to itself = " + distTo[s]);
//            return false;
//        }
//        return false;
//    }
}
