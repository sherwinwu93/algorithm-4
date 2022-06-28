package cat30;

import cat10.P095Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/6/28.
 **/
public class P301LinearProbingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;
    private int m;
    private Key[] keys;
    private Value[] vals;

    public P301LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    public P301LinearProbingHashST(int capacity) {
        m = capacity;
        keys = (Key[]) new Object[m];
        vals = (Value[]) new Object[m];
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

    public void put(Key key, Value val) {
        validateKey(key);
        if (val == null) {
            delete(key);
            return;
        }

        if (n >= m / 2) resize(m * 2);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }
    private void resize(int capacity) {
        P301LinearProbingHashST<Key, Value> temp = new P301LinearProbingHashST<>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        n = temp.n;
        m = temp.m;
        keys = temp.keys;
        vals = temp.vals;
    }
    private int hash(Key key) {
        return key.hashCode() & 0x7fffffff % m;
    }

    public Value get(Key key) {
        validateKey(key);
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) return vals[i];
        }
        return null;
    }

    public void delete(Key key) {
        validateKey(key);
        if (!contains(key)) return;

        int i = hash(key);
        while (!keys[i].equals(key)) i = (i + 1) % m;

        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % m;
        while (keys[i] != null) {
            Key keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            put(keyToRehash, valToRehash);
            i = (i + 1) %m;
        }

        if (n > 0 && n < m / 8) resize(m / 2);
    }

    public Iterable<Key> keys() {
        P095Queue<Key> q = new P095Queue<>();
        for (int i = 0; i < m; i++) {
            if (keys[i] == null) continue;
            q.enqueue(keys[i]);
        }
        return q;
    }

    public static void main(String[] args) {
        P301LinearProbingHashST<String, Integer> st = new P301LinearProbingHashST<>();
        for (int i = 0; !StdIn.isEmpty(); i++)
            st.put(StdIn.readString(), i);

        for (String s : st.keys())
            StdOut.println(s);
    }
}
