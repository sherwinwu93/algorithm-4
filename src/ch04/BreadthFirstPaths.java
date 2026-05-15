package ch04;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class BreadthFirstPaths {
    public BreadthFirstPaths(Graph graph, int s) {

    }
    public BreadthFirstPaths(Graph graph, Iterable<Integer> sources) {

    }

    public boolean hasPathTo(int v) {

    }

    public int distTo(int v) {

    }

    public Iterable<Integer> pathTo(int v) {

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

}
