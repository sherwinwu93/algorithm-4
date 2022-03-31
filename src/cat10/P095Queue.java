package cat10;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * 算法1.3 先进先出队列
 *
 * @param <Item>
 */
public class P095Queue<Item> implements Iterable<Item> {
    public static void main(String[] args) {
        P095Queue<String> q = new P095Queue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }

    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public P095Queue() {
    }
    public P095Queue(P095Queue<Item> q) {
        int M = q.size();
        for (int i = 0; i < M; i++) {
            Item item = q.dequeue();
            enqueue(item);
            q.enqueue(item);
        }
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {
        Node currentNode = first;

        public boolean hasNext() {
            return currentNode != null;
        }

        public Item next() {
            Item item = currentNode.item;
            currentNode = currentNode.next;
            return item;
        }

        public void remove() {

        }
    }
}
