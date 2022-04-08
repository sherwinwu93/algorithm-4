package cat10.ex4;

import cat10.P094Stack;
import edu.princeton.cs.algs4.StdOut;

public class Ex10427Queue {
    public static void main(String[] args) {
        Ex10427Queue queue = new Ex10427Queue();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        StdOut.println(queue.dequeue());
        queue.enqueue("5");
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
    }
    // s1正序 4 3 2 1 0 ,入队列由q1
    private P094Stack<String> inStack = new P094Stack<String>();
    // s2逆序 0 1 2 3 4, 出队列由q2
    private P094Stack<String> outStack = new P094Stack<String>();
    public Ex10427Queue() {
    }
    public void enqueue(String item) {
        inStack.push(item);
    }
    public String dequeue() {
        if (outStack.isEmpty()) inToOut();
        String item = outStack.pop();
        return item;
    }
    private void inToOut() {
        int inN = inStack.size();
        for (int i = 0; i < inN; i++)
            outStack.push(inStack.pop());
    }
    public int size() {
        return inStack.size() + outStack.size();
    }
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
