package cat10.ex3;

import cat10.P094Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex10314ResizingArrayQueueOfStrings {
    private String[] a = new String[1];
    private int N;
    private int head;
    private int tail;

    public Ex10314ResizingArrayQueueOfStrings() {
    }
    private void resize(int max) {
        String[] temp = a;
        a = new String[max];
        for (int i = 0; i < N; i++)
            a[i] = temp[head + i];
        head = 0;
        tail = N;
    }

    public void enqueue(String item) {
        if (tail == a.length) resize(N * 2);
        a[tail++] = item;
        N++;
    }

    public String dequeue() {
        if (N == a.length / 4) resize(N * 2);
        String item = a[head++];
        N--;
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
            String item = StdIn.readString();
            if (!item.equals("-"))
                queue.enqueue(item);
            else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }
}
