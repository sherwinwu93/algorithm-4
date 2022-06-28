package cat30;

import cat10.P095Queue;
import edu.princeton.cs.algs4.SequentialSearchST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/6/28.
 * 分散链接符号表
 **/
public class P297SeparateChainingHashST<Key, Value> {
    private final static int INIT_CAPACITY = 4;

    private int n;
    private int m;
    private SequentialSearchST<Key, Value>[] st;

    /**
     * Initializes an empty symbol table
     */
    public P297SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }

    public P297SeparateChainingHashST(int m) {
        this.m = m;
        st = new SequentialSearchST[n];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<>();
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(Key key) {
        validateKey(key);
        return get(key) != null;
    }

    private void validateKey(Key key) {
        if (key == null) throw new IllegalArgumentException("key couldn't be null");
    }

    public Value get(Key key) {
        validateKey(key);
        int i = hash(key);
        return st[i].get(key);
    }

    private int hash(Key key) {
        return key.hashCode() & 0x7fffffff % m;
    }

    public void put(Key key, Value val) {
        validateKey(key);
        if (val == null) {
            delete(key);
            return;
        }

        if (n >= 10 * m) resize(2 * m);
        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, val);
    }

    private void resize(int chains) {
        P297SeparateChainingHashST<Key, Value> temp = new P297SeparateChainingHashST<>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.n = temp.n;
        this.m = temp.m;
        this.st = temp.st;
    }

    public void delete(Key key) {
        validateKey(key);

        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);
        if (m > INIT_CAPACITY && n <= 2*m) resize(m / 2);
    }

    public Iterable<Key> keys() {
        P095Queue<Key> q = new P095Queue<>();
        for (int i = 0; i < m; i++)
            for (Key key : st[i].keys())
                q.enqueue(key);
        return q;
    }

    public static void main(String[] args) {
        P297SeparateChainingHashST<String, Integer> st = new P297SeparateChainingHashST<>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
