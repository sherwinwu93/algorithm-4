package cat10.ex3;

import edu.princeton.cs.algs4.StdOut;

public class Ex10331LinkedList {
    private Node firstSentry;
    private Node lastSentry;
    private int N;

    public static void main(String[] args) {
        Ex10331LinkedList list = new Ex10331LinkedList();
        list.insertLast("a");
        list.insertLast("b");
        list.insertLast("c");
        list.insertLast("d");
        list.insertAfter("e", 1);
        list.insertBefore("o", 0);
        while (!list.isEmpty())
            StdOut.print(list.removeFirst() + " ");
    }

    public Ex10331LinkedList() {
        firstSentry = new Node();
        lastSentry = new Node();
        firstSentry.next = lastSentry;
        lastSentry.last = firstSentry;
    }

    public void insertFirst(String item) {
        Node t = new Node();
        t.item = item;
        t.next = firstSentry.next;
        firstSentry.next.last = t;
        firstSentry.next = t;
        t.last = firstSentry;
        N++;
    }

    public void insertLast(String item) {
        Node t = new Node();
        t.item = item;
        t.last = lastSentry.last;
        lastSentry.last.next = t;
        t.next = lastSentry;
        lastSentry.last = t;
        N++;
    }

    public String removeFirst() {
        if (isEmpty()) throw new RuntimeException("the list is empty!");
        Node first = firstSentry.next;
        String item = first.item;
        firstSentry.next = first.next;
        first.next.last = firstSentry;
        N--;
        return item;
    }

    public String removeLast() {
        if (isEmpty()) throw new RuntimeException("the list is empty!");
        Node last = lastSentry.last;
        String item = last.item;
        lastSentry.last = last.last;
        last.last.next = lastSentry;
        N--;
        return item;
    }

    public void insertBefore(String item, int index) {
        validateIndex(index);
        Node currentNode = firstSentry.next;
        for (int i = 0; i < index; i++) currentNode = currentNode.next;
        Node t = new Node();
        t.item = item;
        Node previous = currentNode.last;
        previous.next = t;
        t.last = previous;
        t.next = currentNode;
        currentNode.last = t;
        N++;
    }

    public void insertAfter(String item, int index) {
        validateIndex(index);
        Node currentNode = firstSentry.next;
        for (int i = 0; i < index; i++) currentNode = currentNode.next;
        Node t = new Node();
        t.item = item;
        Node late = currentNode.next;
        currentNode.next = t;
        t.last = currentNode;
        t.next = late;
        late.last = t;
        N++;
    }

    private void validateIndex(int index) {
        if (index >= N) throw new ArrayIndexOutOfBoundsException();
    }

    public void remove(int index) {
        if (isEmpty()) throw new RuntimeException("the list is empty!");
        validateIndex(index);
        Node currentNode = firstSentry.next;
        for (int i = 0; i < index; i++) currentNode = currentNode.next;
        Node previous = currentNode.last;
        Node late = currentNode.next;
        previous.next = late;
        late.last = late;
        N--;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private class Node {
        String item;
        Node last;
        Node next;
    }
}
