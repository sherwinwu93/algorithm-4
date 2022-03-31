package cat10.ex3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Ex10333Deque<Item> implements Iterable<Item> {
    public static void main(String[] args) {
        Ex10333Deque<String> deque = new Ex10333Deque<String>();
        deque.pushRight("a");
        deque.pushRight("b");
        deque.pushLeft("c");
        deque.pushRight("d");
        for (String s : deque)
            StdOut.print(s + " ");
        StdOut.println();
        StdOut.println(deque.popLeft());
        StdOut.println(deque.popRight());
    }
    private Node firstSentry;
    private Node lastSentry;
    private int N;
    public Ex10333Deque() {
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
    private void validateEmpty() {
        if (isEmpty()) throw new RuntimeException("deque is empty!");
    }
    public void pushLeft(Item item) {
        Node first = firstSentry.next;
        Node t = new Node(item);
        firstSentry.next = t;
        t.last = firstSentry;
        t.next = first;
        first.last = t;
        N++;
    }
    public void pushRight(Item item) {
        Node last = lastSentry.last;
        Node t = new Node(item);
        last.next = t;
        t.last = last;
        t.next = lastSentry;
        lastSentry.last = t;
        N++;
    }
    public Item popLeft() {
        validateEmpty();
        Node first = firstSentry.next;
        Item item = first.item;
        Node second = first.next;
        firstSentry.next = second;
        second.last = firstSentry;
        N--;
        return item;
    }
    public Item popRight() {
        validateEmpty();
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

    public class DequeIterator implements Iterator<Item> {
        Node currentNode = firstSentry.next;

        public boolean hasNext() {
            return currentNode != lastSentry;
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
