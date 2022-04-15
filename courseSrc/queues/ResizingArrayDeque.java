import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayDeque<Item> implements Iterable<Item> {
    // unit testing (required)
    public static void main(String[] args) {
        ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<Integer>();
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);
        StdOut.println("3:" + deque.size());
        StdOut.println("false:" + deque.isEmpty());
        StdOut.println("1:" + deque.removeFirst());
        StdOut.println("3:" + deque.removeLast());
        StdOut.println("1:" + deque.size());
        deque.removeFirst();
        StdOut.println("true:" + deque.isEmpty());
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        for (Integer s : deque) StdOut.println(s);
        StdOut.println("1:" + deque.removeFirst());
        StdOut.println("3:" + deque.removeLast());
    }

    private Item[] a;
    private int N;
    private int head;
    private int tail;

    public ResizingArrayDeque() {
        a = (Item[]) new Object[1];
    }

    private void resize(int max) {
        if (max < 4) max = 4;
        Item[] temp = a;
        a = (Item[]) new Object[max];
        int start = (max - N) / 2;
        for (int i = 0; i < N; i++)
            a[i + start] = temp[head + i];
        head = start;
        tail = head + N;
    }

    public int size() {
        return N;
    }

    public void addFirst(Item item) {
        validateItem(item);
        if (head == 0) resize(2 * N);
        a[--head] = item;
        N++;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void validateItem(Item item) {
        if (item == null) throw new IllegalArgumentException();
    }

    public void addLast(Item item) {
        validateItem(item);
        if (tail == a.length) resize(2 * N);
        a[tail++] = item;
        N++;
    }

    public Item removeFirst() {
        validateIsNotEmptyWhenRemove();
        if (N == a.length / 4) resize(2 * N);
        Item item = a[head];
        a[head++] = null;
        N--;
        return item;
    }

    public Item removeLast() {
        validateIsNotEmptyWhenRemove();
        if (N == a.length / 4) resize(2 * N);
        Item item = a[--tail];
        a[tail] = null;
        N--;
        return item;
    }

    private void validateIsNotEmptyWhenRemove() {
        if (N == 0) throw new NoSuchElementException();
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private int index = head;

        public boolean hasNext() {
            return index != tail;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = a[index++];
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
