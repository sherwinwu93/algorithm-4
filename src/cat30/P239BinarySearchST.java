package cat30;

import java.util.Stack;

/**
 * Created by Wusd on 2022/6/23.
 **/
public class P239BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public P239BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public void put(Key key, Value val) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        else return null;
    }

    // 基于有序数组的二分查找
    public int rank(Key key) {
        int lo = 0;
        int hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public void delete(Key key) {
        // 找rank
        // 确定是否存在
        // 不存在return
        // 存在则需要迁移数组,并N--
        int i = rank(key);
        if (i >= N || keys[i].compareTo(key) != 0) return;
        for (int j = N - 1; j > i; j--) {
            keys[j - 1] = keys[j];
            vals[j - 1] = vals[j];
        }
        N--;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }

    public Key select(int k) {
        return keys[k];
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    public Key floor(Key key) {
        int i = rank(key);
        // 命中
        if (i < N && keys[i].compareTo(key)== 0) return key;
        // 比最小元素还小
        if (i == 0) return null;
        return keys[i - 1];
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Iterable<Key> keys() {
        Stack<Key> s = new Stack<>();
        for (int i = 0; i < N; i++) s.push(keys[i]);
        return s;
    }
}
