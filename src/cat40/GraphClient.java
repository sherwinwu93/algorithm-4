package cat40;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/6/30.
 * java GraphClient tinyG.txt
 **/
public class GraphClient {
    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++)
            if (G.degree(v) > max) max = G.degree(v);
        return max;
    }

    public static int avgDegree(Graph G){
//        int sum = 0;
//        int V = G.V();
//        for (int i = 0; i < V; i++)
//            sum += G.degree(i);
//        return V == 0 ? 0: sum / G.V();
        return 2 * G.E() / G.V();// each edge incident on two vertices
    }
    public static int numberOfSelfLoops(Graph G){
        int count = 0;
        for (int v = 0; v < G.V(); v++)
            for (int w : G.adj(v))
                if (v == w) count++;
//            if (G.degree(v) == 0) count++;
        return count / 2;// why self loop appears in adjacency list twice? Because bag[v].add(v) twice
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        StdOut.println(G);

        StdOut.println("vertex of maximum degree = " + maxDegree(G));
        StdOut.println("average degree = " + avgDegree(G));
        StdOut.println("number of self loops = " + numberOfSelfLoops(G));
    }
}
