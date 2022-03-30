package cat10.ex3;

import cat10.P094Stack;
import cat10.P095Queue;
import edu.princeton.cs.algs4.StdOut;

public class Ex10306StackTest {
    public static void main(String[] args) {
        P095Queue<String> q = new P095Queue<String>();
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        q.enqueue("d");
        for (String s : q)
            StdOut.print(s + " ");
        StdOut.println();
        reverse(q);
        for (String s : q)
            StdOut.print(s + " ");
        StdOut.println();
    }
    public static void reverse(P095Queue<String> q) {
        P094Stack<String> stack = new P094Stack<String>();
        while (!q.isEmpty())
            stack.push(q.dequeue());
        while (!stack.isEmpty())
            q.enqueue(stack.pop());
    }
}
