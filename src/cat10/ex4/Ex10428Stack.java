package cat10.ex4;

import cat10.P095Queue;
import edu.princeton.cs.algs4.StdOut;

public class Ex10428Stack {
    public static void main(String[] args) {
        Ex10428Stack stack = new Ex10428Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
    }
    private P095Queue<Integer> queue = new P095Queue<Integer>();

    public Ex10428Stack() {
    }
    public void push(Integer item) {
        queue.enqueue(item);
    }
    public Integer pop() {
        int N = queue.size();
        for (int i = 0; i < N - 1; i++)
            queue.enqueue(queue.dequeue());
        return queue.dequeue();
    }
    public int size() {
        return queue.size();
    }
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
