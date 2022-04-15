import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addFirst("c");
        deque.addLast("d");
        for (String s : deque)
            StdOut.print(s + " ");
        StdOut.println();
        StdOut.println(deque.removeFirst());
        StdOut.println(deque.removeLast());
    }

    private Node firstSentry;
    private Node lastSentry;
    private int N;

    public Deque() {
        firstSentry = new Node(null);
        lastSentry = new Node(null);
        firstSentry.next = lastSentry;
        lastSentry.last = firstSentry;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void validateNotEmpty() {
        if (isEmpty()) throw new NoSuchElementException();
    }

    public void addFirst(Item item) {
        validateAdd(item);
        Node first = firstSentry.next;
        Node t = new Node(item);
        firstSentry.next = t;
        t.last = firstSentry;
        t.next = first;
        first.last = t;
        N++;
    }

    private void validateAdd(Item item) {
        if (item == null) throw new IllegalArgumentException();
    }

    public void addLast(Item item) {
        validateAdd(item);
        Node last = lastSentry.last;
        Node t = new Node(item);
        last.next = t;
        t.last = last;
        t.next = lastSentry;
        lastSentry.last = t;
        N++;
    }

    public Item removeFirst() {
        validateNotEmpty();
        Node first = firstSentry.next;
        Item item = first.item;
        Node second = first.next;
        firstSentry.next = second;
        second.last = firstSentry;
        N--;
        return item;
    }

    public Item removeLast() {
        validateNotEmpty();
        Node last = lastSentry.last;
        Item item = last.item;
        Node late = last.last;
        late.next = lastSentry;
        lastSentry.last = late;
        N--;
        return item;
    }

    private class Node {
        Item item;
        Node last;
        Node next;

        private Node(Item item) {
            this.item = item;
        }
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        Node currentNode = firstSentry.next;

        public boolean hasNext() {
            return currentNode != lastSentry;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = currentNode.item;
            currentNode = currentNode.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
