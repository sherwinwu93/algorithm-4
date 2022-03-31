package cat10.ex3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex10332Steque {
    public static void main(String[] args) {
        Ex10332Steque steque = new Ex10332Steque();
        while (!StdIn.isEmpty()) {
            steque.push(StdIn.readString());
            steque.enqueue(StdIn.readString());
        }
        while (!steque.isEmpty())
            StdOut.print(steque.pop());
    }

    private Node first;
    private Node last;
    private int N;

    public void push(String item) {
        if (isEmpty()) last = first = new Node(item);
        else {
            Node t = new Node(item);
            t.next = first;
            first = t;
        }
        N++;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = first;
        return item;
    }

    public void enqueue(String item) {
        if (isEmpty()) first = last = new Node(item);
        else {
            Node t = new Node(item);
            last.next = t;
            last = t;
        }
        N++;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private class Node {
        String item;
        Node next;

        public Node(String item) {
            this.item = item;
        }
    }
}
