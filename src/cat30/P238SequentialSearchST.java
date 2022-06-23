package cat30;

import java.util.Stack;

/**
 * Created by Wusd on 2022/6/23.
 * 无序链表表现的Symbol Table
 **/
public class P238SequentialSearchST<Key, Value> {
    private Node first;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public P238SequentialSearchST() {
    }

    // 问题的关键在于,对node的迭代~循环,和数组的迭代循环一致,又与贝多芬的命运交响曲一般
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next)
            if (x.key.equals(key)) return x.val;
        return null;
    }

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next)
            if (x.key.equals(key)) {
                x.val = val;
                return;
            }
        first = new Node(key, val, first);
    }

    public void delete(Key key) {
        put(key, null);
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        int sz = 0;
        for (Node x = first; x != null; x = x.next)
            if (x.val != null) sz++;
        return sz;
    }

    public Iterable<Key> keys() {
        Stack<Key> s = new Stack<>();
        for (Node x = first; x != null; x = x.next)
            if (x.val != null) s.push(x.key);
        return s;
    }
}
