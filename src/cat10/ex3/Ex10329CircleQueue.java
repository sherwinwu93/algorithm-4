package cat10.ex3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex10329CircleQueue {
    public static void main(String[] args) {
        Ex10329CircleQueue q = new Ex10329CircleQueue();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }
    private Node last;
    private int N;

    public Ex10329CircleQueue() {
    }

    public void enqueue(String item) {
        if (last == null) {
            last = new Node();
            last.item = item;
            last.next = last;
        } else {
            Node t = new Node();
            t.item = item;

            t.next = last.next;
            last.next = t;
            last = t;
        }
        N++;
    }
    public String dequeue() {
        if (last.next == last) {
            String item = last.item;
            last = null;
            N--;
            return item;
        } else {
            String item = last.next.item;
            last.next = last.next.next;
            N--;
            return item;
        }
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public Node reverse(Node x) {
        Node first = x;
        Node reverse = null;
        while (first != null) {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }
    public Node reverseRecur(Node first) {
        if (first == null) return null;
        if (first.next == null) return first;
        Node second = first.next;
        Node rest = reverseRecur(second);
        second.next = first;
        first.next= null;
        return rest;
    }

    private class Node {
        private String item;
        private Node next;
    }
}
