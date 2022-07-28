package cat40;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

/**
 * Created by Wusd on 2022/7/19.
 **/
public class SymbolDigraph {
    private ST<String, Integer> st;
    private String[] keys;
    private Digraph G;

    public SymbolDigraph(String filename, String delimiter) {
        In in = new In(filename);
        st = new ST<String, Integer>();
        while (in.hasNextLine()) {
            String[] keys = in.readLine().split(delimiter);
            for (String key : keys) {
                if (!st.contains(key)) {
                    st.put(key, st.size());
                }
            }
        }

        keys = new String[st.size()];
        for (String key : st.keys()) {
            keys[st.get(key)] = key;
        }

        in = new In(filename);
        G = new Digraph(st.size());
        while (in.hasNextLine()) {
            String[] keys = in.readLine().split(delimiter);
            int v = st.get(keys[0]);
            for (int i = 1; i < keys.length; i++)
                G.addEdge(v, st.get(keys[i]));
        }
    }
    public boolean contains(String s) {
        if (st == null) throw new IllegalArgumentException();
        return st.contains(s);
    }
    public int index(String s) {
        if (!contains(s)) return -1;
        return st.get(s);
    }
    public String name(int v) {
        validateVertex(v);
        return keys[v];
    }
    private void validateVertex(int v) {
        if (v <0 || v >= st.size()) throw new IllegalArgumentException();
    }
    public Digraph digraph() {
        return G;
    }
}
