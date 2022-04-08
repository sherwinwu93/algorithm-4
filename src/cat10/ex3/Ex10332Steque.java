package cat10.ex3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex10332Steque<Item> {
    public static void main(String[] args) {
        Ex10332Steque<String> steque = new Ex10332Steque<String>();
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

    public void push(Item item) {
        if (isEmpty()) last = first = new Node(item);
        else {
            Node t = new Node(item);
            t.next = first;
            first = t;
        }
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = first;
        return item;
    }

    public void enqueue(Item item) {
        if (isEmpty()) first = last = new Node(item);
        else {
            Node t = new Node(item);
            last.next = t;
            last = t;
        }
        N++;
    }
    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private class Node {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
        }
    }
}
