package cat40;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/7/19.
 * pre: 每个点的preorder序号
 * post: 每个点的postorder序号
 * preorder: 记录递归程序展开的轨迹
 * postorder: 记录递归程序收缩的轨迹
 **/
public class DepthFirstOrder {
    private boolean[] marked;
    private int[] pre;
    private int[] post;
    private Queue<Integer> preorder;
    private Queue<Integer> postorder;
    private int preCounter;
    private int postCounter;

    public DepthFirstOrder(Digraph G) {
        marked = new boolean[G.V()];
        pre = new int[G.V()];
        post = new int[G.V()];
        preorder = new Queue<>();
        postorder = new Queue<>();
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);
    }
    private void dfs(Digraph G, int v) {
        marked[v] = true;
        pre[v] = preCounter++;
        preorder.enqueue(v);
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        post[v] = postCounter++;
        postorder.enqueue(v);
    }
    public int pre(int v) {
        validateVertex(v);
        return pre[v];
    }
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V) throw new IllegalArgumentException();
    }
    public int post(int v) {
        validateVertex(v);
        return post[v];
    }
    public Iterable<Integer> post() {
        return postorder;
    }
    public Iterable<Integer> pre() {
        return preorder;
    }
    public Iterable<Integer> reversePost() {
        Stack<Integer> reverse = new Stack<>();
        for (int v : postorder) {
            reverse.push(v);
        }
        return reverse;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);

        DepthFirstOrder dfs = new DepthFirstOrder(G);
        StdOut.println(" v pre post");
        StdOut.println("-----------");
        for (int v = 0; v < G.V(); v++) {
            StdOut.printf("%4d %4d %4d\n", v, dfs.pre(v), dfs.post(v));
        }

        StdOut.print("Preorder: ");
        for (int v : dfs.pre()) {
            StdOut.print(v + " ");
        }
        StdOut.println();

        StdOut.print("Postorder: ");
        for (int v : dfs.post()) {
            StdOut.print(v + " ");
        }
        StdOut.println();

        StdOut.print("Reverse postorder: ");
        for (int v : dfs.reversePost()) {
            StdOut.print(v + " ");
        }
        StdOut.println();
    }
}
/**
 * java DepthFirstOrder tinyDAG.txt
 *  v pre post
 * -----------
 *    0    0    8
 *    1    3    2
 *    2    9   10
 *    3   10    9
 *    4    2    0
 *    5    1    1
 *    6    4    7
 *    7   11   11
 *    8   12   12
 *    9    5    6
 *   10    8    5
 *   11    6    4
 *   12    7    3
 * Preorder: 0 5 4 1 6 9 11 12 10 2 3 7 8
 * Postorder: 4 5 1 12 11 10 9 6 0 3 2 7 8
 * Reverse postorder: 8 7 2 3 0 6 9 10 11 12 1 5 4
 **/