package cat10.ex3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex10314ResizingArrayQueueOfStrings {
    private String[] a;
    private int N;
    private int head;
    private int tail;
    public Ex10314ResizingArrayQueueOfStrings() {
    }
    public void enqueue(String item) {
        a[N++] = item;
    }
    public String dequeue() {
        String item = a[--N];
        a[N] = null;
        return item;
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return N == 0;
    }

    public static void main(String[] args) {
        Ex10314ResizingArrayQueueOfStrings queue = new Ex10314ResizingArrayQueueOfStrings();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            queue.enqueue(s);
        }
        StdOut.println(queue);
    }
}
