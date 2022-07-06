package cat40;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/7/5.
 **/
public class DegreesOfSeparation {
    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        String source = args[2];

        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        if (!sg.contains(source)) {
            StdOut.println(source +" not in database. ");
            return;
        }
        Graph G = sg.G();
        int s = sg.index(source);
        BreadthFirstPaths bfp = new BreadthFirstPaths(G, s);
        while (!StdIn.isEmpty()) {
            String search = StdIn.readLine();
            if (sg.contains(search)) {
                int e = sg.index(search);
                if (bfp.hasPathTo(e)) {
                    for (int v : bfp.path(e)) {
                        StdOut.println(" " + sg.name(v));
                    }
                } else {
                    StdOut.println(search + " not connected");
                }
            } else {
                StdOut.println(search + " not in database");
            }
        }
    }
}
/**
 * % java DegreesOfSeparation movies.txt "/" "Bacon, Kevin"
 * Kidman, Nicole
 *  Bacon, Kevin
 *  Woodsman, The (2004)
 *  Grier, David Alan
 *  Bewitched (2005)
 *  Kidman, Nicole
 */
