package cat40;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/7/5.
 **/
public class SymbolGraph {
    private ST<String, Integer> st;
    private String[] keys;
    private Graph graph;

    // build graph specified in filename using delimiter to separate vertex names
    public SymbolGraph(String filename, String delimiter) {
        st = new ST<>();
        In in = new In(filename);
        while (!in.isEmpty()) {
            String[] a = in.readLine().split(delimiter);
            for (String key : a) {
                if (!st.contains(key))
                    st.put(key, st.size());
            }
        }

        keys = new String[st.size()];
        for (String key : st.keys()) {
            keys[st.get(key)] = key;
        }

        graph = new Graph(st.size());
        in = new In(filename);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                int w = st.get(a[i]);
                graph.addEdge(v, w);
            }
        }
    }
    // is key a vertex?
    public boolean contains(String s) {
        return st.contains(s);
    }
    // index associated with key
    public int index(String s) {
        if (!st.contains(s)) return -1;
        return st.get(s);
    }
    // key associated with index v
    public String name(int v) {
        validateVertex(v);
        return keys[v];
    }
    private void validateVertex(int v) {
        if (v < 0 || v >= st.size()) throw new IllegalArgumentException();
    }
    // underlying Graph
    public Graph G() {
        return graph;
    }

    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph graph = sg.G();

        while (StdIn.hasNextLine()) {
            String s = StdIn.readLine();
            if (sg.contains(s)) {
                int v = sg.index(s);
                for (int w: graph.adj(v)) {
                    StdOut.println(" " + sg.name(w));
                }
            } else {
                StdOut.println("input not contain '" + s + "'");
            }
        }
    }
}
/**
 * %  java SymbolGraph routes.txt " "
 * JFK
 *
 */
