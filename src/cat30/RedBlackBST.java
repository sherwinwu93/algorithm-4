package cat30;

import cat10.P095Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/6/28.
 * 手动实现红黑二叉树
 **/
public class RedBlackBST<Key extends Comparable, Value> {
    private final static boolean RED = true;
    private final static boolean BLACK = true;

    private Node root;

    private class Node {
        Key key;
        Value val;
        Node left, right;
        boolean color;
        int n;

        public Node(Key key, Value val, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
            n = 1;
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public int size() {
        return size(root);
    }

    private int size(Node h) {
        if (h == null) return 0;
        return h.n;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node h, Key key) {
        if (h == null) return null;
        int cmp = key.compareTo(h.key);
        if (cmp < 0) return get(h.left, key);
        else if (cmp > 0) return get(h.right, key);
        else return h.val;
    }

    private boolean isRed(Node h) {
        if (h == null) return false;
        return h.color;
    }

    public void put(Key key, Value val) {
//        if (val == null) delete(key);
        root = put(root, key, val);
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null) return new Node(key, val, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        if (!isRed(h.left) && isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        return h;
    }

//    public void delete(Key key) {
//        if (!contains(key)) return;
//        root = delete(root, key);
//    }
//    private Node delete(Node h, Key key) {
//
//    }

    public void deleteMin() {
        if (!isRed(root)) root.color = RED;
        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node deleteMin(Node h) {
        if (h.left == null) return null;
        if (!isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);
        h.left = deleteMin(h.left);
        return balance(h);
    }

    private Node moveRedLeft(Node h) {
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        return h;
    }

    private Node balance(Node h) {
        if (!isRed(h.left) && isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        h.n = size(h.left) + size(h.right) + 1;
        return h;
    }

    private void validateKey(Key key) {
        if (key == null) throw new IllegalArgumentException("key couldn't be null");
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = size(h.left) + 1 + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = size(h.left) + 1 + size(h.right);
        return x;
    }

    private void flipColors(Node h) {
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
        h.color = !h.color;
    }

    public Iterable<Key> keys() {
        P095Queue<Key> q = new P095Queue<>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node h, P095Queue<Key> q) {
        if (h == null) return;
        inorder(h.left, q);
        q.enqueue(h.key);
        inorder(h.right, q);
    }


    public static void main(String[] args) {
        RedBlackBST<String, Integer> bst = new RedBlackBST<>();
        for (int i = 0; !StdIn.isEmpty(); i++)
            bst.put(StdIn.readString(), i);

        for (String key : bst.keys())
            StdOut.println(key + " " + bst.get(key) + "  ");
    }
}
