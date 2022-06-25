package cat30;

/**
 * Created by Wusd on 2022/6/24.
 * 算法3.4 红黑树的插入算法
 **/
public class P281RedBlackBST<Key extends Comparable, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node {
        Key key;
        Value val;
        Node left, right;
        int N;
        boolean color;// parentNode -> node's color

        Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    public int size() {
        return size(root);
    }

    // key is changes
//    Node rotateLeft(Node h) {
//        Node x = h.right;
//        h.right = x.left;
//        x.left = h;
//        x.color = h.color;
//        h.color = RED;
//        x.N = h.N;
//        h.N = size(h.left) + 1 + size(h.right);
//        return x;
//    }

    // key is changes
//    Node rotateRight(Node h) {
//        Node x = h.left;
//        h.left = x.right;
//        x.right = h;
//        x.N = h.N;
//        h.N = size(h.left) + 1 + size(h.right);
//        x.color = h.color;
//        h.color = RED;
//        return x;
//    }

    // h的父节点颜色只可能是黑色, 因为操作是不允许出现两个红链的情况
    // 根节点由红转黑,黑色高度增加1
//    void flipColors(Node h) {
//        h.color = RED;
//        h.left.color = BLACK;
//        h.right.color = BLACK;
//    }

//    public void put(Key key, Value val) {
//        root = put(root, key, val);
//        root.color = BLACK;
//    }
//    private Node put(Node h,Key key, Value val) {
//        // 在递归中h== null,表示没有找到.没有找到则新建
//        // RED,表面父节点是红链接
//        if (h == null) return new Node(key, val, 1, RED);
//
//        int cmp = key.compareTo(h.key);
//        // 小于则去左边put. h.left = put(h.left,key,val) 因为有可能h.left本来是null
//        if (cmp < 0) h.left = put(h.left, key, val);
//        // 同右边
//        else if (cmp > 0) h.right = put(h.right, key, val);
//        // 等于则赋值
//        else h.val = val;
//
//        // 上面已经是从root -> root.sub -> root.sub.sub -> root.sub.sub.sub ...递归链是展开的
//        // 到这里递归链是收缩的 即从root.sub.sub.sub... -> root.sub.sub... -> root.sub... -> 直到root
//        // 我们针对当前点, 有几种情况需要处理
//        // 右红左黑,h = 左旋后的h,会得到左红右黑, 可能指向h的链接是红.那么h的parent就是左红左左红,在下一步处理
//        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
//        // 左红左左红,右转,会得到左右红,等下一步处理
//        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
//        // 左红且右红,变换颜色, 得到左右黑,上头红
//        if (isRed(h.left) && isRed(h.right)) flipColors(h);
//
//        // 递归连收缩
//        h.N = size(h.left) + size(h.right) + 1;
//        return h;
//    }

    // 只有一个关键,左倾一次红黑树
    // 左转
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.N = h.N;
        h.N = size(h.left) + 1 + size(h.right);
        x.color = h.color;
        h.color = RED;
        return x;
    }

    // 右转
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.N = h.N;
        h.N = size(h.left) + 1 + size(h.right);
        x.color = h.color;
        h.color = RED;
        return x;
    }

    // flipColors
    // 只有颜色对称的情况下,flipColors才平衡
    private void flipColors(Node h) {
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
        h.color = !h.color;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null) return new Node(key, val, 1, RED);

        // 递归沿树向下
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        // 递归沿树向上
        // 右倾, 左转
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    private boolean isEmpty() {
        return root == null;
    }

//    private Node moveRedLeft(Node h) {
//        // 自顶向下父节点没有2-node了,h.color一定是红色
//        // h.left是黑色,所以h.right一定也是黑色
//        // 所以h可以flipColors
//        flipColors(h);
//        // 右边的左链接是红的,先将h.right rotateRight, 再h rotateLeft
//        if (isRed(h.right.left)) {
//            h.right = rotateRight(h.right);
//            h = rotateLeft(h);
//            flipColors(h);
//        }
//        return h;
//    }

//    public void deleteMin() {
//        // 如果root的左右都是红链接,那么设置指向root的为红链,为flipColors做准备
//        if (!isRed(root.left) && !isRed(root.right))
//            root.color = RED;
//        // root = root删除最小的
//        root = deleteMin(root);
//        // 如果root不是null,将指向root的链接设为红的
//        if (!isEmpty()) root.color = BLACK;
//    }

//    private Node deleteMin(Node h) {
//        // 如果h.left是null, 则只有h node, 删除h返回null
//        if (h.left == null) return null;
//        // h的左链是黑色,h的左子树的左链也是黑的,那么从右边拉一个过来,变红左边, 左边一定是3-node或4-node
//        // 如果h.left是黑色的,那么h.right也一定是黑的, 所以才能moveRedLeft. 只有h.left.left是黑色,h.left才不是3-node,才有只需要moveRedLeft
//        if (!isRed(h.left) && !isRed(h.left.left))
//            h = moveRedLeft(h);
//        // 当前节点是3-node或4-node, 删除递归链展开
//        h.left = deleteMin(h.left);
//        // 递归链回归时, 重新左倾黑平衡,并设置好大小
//        return balance(h);
//    }

//    private Node balance(Node h) {
//
//        // 三操作,可以使得左倾黑平衡
//        // 右红左黑, 左拉
//        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
//        // 左红左子树左红, 右拉
//        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
//        // 左红,右红,着色
//        if (isRed(h.left) && isRed(h.right)) flipColors(h);
//        // 维护高度
//        h.N = size(h.left) + size(h.right) + 1;
//        return h;
//    }

    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
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
            flipColors(h);
        }
        return h;
    }

    private Node balance(Node h) {
        if (!isRed(h.left) && isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.left)) flipColors(h);
        h.N = size(h.left) + 1 + size(h.right);
        return h;
    }

//    private Node moveRedRight(Node h) {
//        flipColors(h);
//        // 因为本来就是左倾的,可以不用h.left = rotateLeft(h.left);
//        if (isRed(h.left.left)) {
//            h = rotateRight(h);
//            flipColors(h);
//        }
//        return h;
//    }
//
//    public void deleteMax() {
//        if (!isRed(root.left) && !isRed(root.right))
//            root.color = RED;
//        root = deleteMax(root);
//        if (!isEmpty()) root.color = BLACK;
//    }
//
//    private Node deleteMax(Node h) {
//        if (isRed(h.left))
//            h = rotateRight(h);
//        if (h.right == null)
//            return null;
//        if (!isRed(h.right) && !isRed(h.right.left))
//            h = moveRedRight(h);
//        h.right = deleteMax(h.right);
//        return balance(h);
//    }

    public void deleteMax() {
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = deleteMax(root);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node deleteMax(Node h) {
        if (isRed(h.left)) h = rotateRight(h);
        if (h.right == null) return null;
        if (!isRed(h.right) && !isRed(h.right.left))
            h = moveRedRight(h);
        h.right = deleteMax(h.right);
        return balance(h);
    }

    private Node moveRedRight(Node h) {
        flipColors(h);
        if (isRed(h.left.left)) {
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }

//    public void delete(Key key) {
//        if (!isRed(root.left) && isRed(root.right))
//            root.color = RED;
//        root = delete(root, key);
//        if (!isEmpty()) root.color = BLACK;
//    }
//
//    private Node delete(Node h, Key key) {
//        if (key.compareTo(h.key) < 0) {
//            if (!isRed(h.left) && !isRed(h.left.left))
//                h = moveRedLeft(h);
//            h.left = delete(h.left, key);
//        } else {
//            if (isRed(h.left)) h = rotateRight(h);
//            if (key.compareTo(h.key) == 0 && (h.right == null))
//                return null;
//            if (!isRed(h.right) && !isRed(h.right.left))
//                h = moveRedRight(h);
//            if (key.compareTo(h.key) == 0) {
//                h.val = get(h.right, min(h.right).key);
//                h.key = min(h.right).key;
//                h.right = deleteMin(h.right);
//            } else h.right = delete(h.right, key);
//        }
//        return balance(h);
//    }

    public void delete(Key key) {
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node delete(Node h, Key key) {
        if (key.compareTo(h.key) < 0) {
            if (!isRed(h.left) && !isRed(h.left.left))
                h = moveRedLeft(h);
            h.left = delete(h.left, key);
        } else {
            if (isRed(h.left)) h = rotateRight(h);
            if (key.compareTo(h.key) == 0 && h.right == null) return null;
            if (!isRed(h.right) && !isRed(h.right.left))
                h = moveRedRight(h);
            if (key.compareTo(h.key) == 0) {
                h.val = get(h.right, min(h.right).key);
                h.key = min(h.right).key;
                h.right = deleteMax(h.right);
            } else h.right = delete(h.right, key);
        }

        return balance(h);
    }

    private Node min(Node x) {
        if (x == null) return null;
        while (x.left != null)
            x = x.left;
        return x;
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

    public static void main(String[] args) {
        P281RedBlackBST<String, Integer> st = new P281RedBlackBST<>();

//        String s = "bac";
        String s = "badc";
        for (String key : s.split(""))
            st.put(key, 1);
        st.deleteMin();
        System.out.println();
    }
}
