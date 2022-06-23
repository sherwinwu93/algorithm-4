package cat30;


import edu.princeton.cs.algs4.Queue;

/**
 * Created by Wusd on 2022/6/23.
 **/
public class BST <Key extends Comparable, Value>{
    private Node root;
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int count;
        public Node(Key key, Value val, int count) {
            this.key = key;
            this.val = val;
            this.count = count;
        }
    }
    // Hibbard deletion
//    public void delete(Key key) {
//        // case 0. 0 child! Delete t by setting parent link to null
//        //          1. replace with null link
//        //          2. update counts after recursive calls
//        // case 1. 1 child! Delete t by replacing parent link
//        //          1. replace with child link
//        //          2. update counts after recursive calls
//        // case 2. 2 children!.
//        //          1. find successor x of t. successor: 继承人
//        //          2. delete the minimum in t's right subtree
//        //          3. Put x in t's spot
//        root = delete(root, key);
//    }
//    private Node delete(Node x, Key key) {
//        if (x == null) return null;
//        int cmp = key.compareTo(x.key);
//        // search for key
//        if (cmp < 0) x.left = delete(x.left, key);
//        // search for key
//        else if (cmp > 0) x.right = delete(x.right, key);
//        // get key
//        else {
//            // no right child, x-tree - x = x.left
//            if (x.right == null) return x.left;
//            // no left child, x-tree - x = x.right
//            if (x.left == null) return x.right;
//
//            Node t = x;
//            // x变为successor
//            x = min(t.right);
//            // x.right = 原来的tree.deleteMin();
//            x.right = deleteMin(t.right);
//            // x.left 不变
//            x.left = t.left;
//        }
//        // update subtree counts. 递归地增加
//        x.count = size(x.left) + size(x.right) + 1;
//        return x;
//    }
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) delete(x.left, key);
        else if (cmp > 0) delete(x.right, key);
        else {
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.count = size(x.left) + 1 + size(x.right);
        return x;
    }

    private Node min(Node x) {
        if (x == null) return null;
        while (x.left != null)
            x = x.left;
        return x;
    }
    public void deleteMin() {
        root = deleteMin(root);
    }
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = size(x.left) + 1 + size(x.right);
        return x;
    }
    // How many keys < k?
    public int rank(Key key) {
        return rank(key, root);
    }
    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }

    public int size() {
        return size(root);
    }
    private int size(Node x) {
        if (x == null) return 0;
        else return x.count;
    }
    public void put(Key key, Value val) {
        // 为什么要用root = , 因为可能为null的情况
        root = put(root, key, val);
    }
    public Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.count = size(x.left) + size(x.right);
        return x;
    }
    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    public Key min() {
        if (root == null) return null;
        Node x = root;
        while (x.left != null)
            x = x.left;
        return x.key;
    }
    public Key max() {
        if (root == null) return null;
        Node x = root;
        while (x.right != null)
            x = x.right;
        return x.key;
    }
    public Iterable<Key> iterator() {
        return null;
    }
    public Key floor(Key key) {
        // 三种情况
        //  1. root.key == key, 在root
        //  2. key < root.key, 一定在左树,也可能没有
        //  3. key > root.key, 如果右树存在 key <= k, 那么在右树,这里要重新定义查询的root了. 否则就是 root了.
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }
    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) floor(x.left, key);

        Node t = floor(x.right, key);
        // 可能在右边,也可能在root上
        if (t != null) return t;
        else return x;
    }
    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        return x.key;
    }
    public Node ceiling(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);

        if (cmp == 0) return x;
        if (cmp > 0) return ceiling(x.right, key);

        Node t = ceiling(x.left, key);
        if (t != null) return t;
        else return x;
    }
    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<>();
        inorder(root, q);
        return q;
    }
    private void inorder(Node x, Queue<Key> q) {
        if (x == null) return;
        inorder(x.left, q);
        q.enqueue(x.key);
        inorder(x.right, q);
    }
}
