package cat10.ex3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Ex10333ResizingArrayDeque<Item> implements Iterable<Item>{
    public static void main(String[] args) {
        Ex10333ResizingArrayDeque<String> deque = new Ex10333ResizingArrayDeque<String>();
        for (int i = 0; i < 10; i++)
            deque.pushRight(i + "");
        for (int i = 10; i < 20; i++)
            deque.pushLeft(i + " ");
        for (String s : deque)
            StdOut.print(s + " ");
        StdOut.println();
        for (int i = 0; i < 3; i++)
            StdOut.print(deque.popLeft() + " ");
        StdOut.println();
        for (int i = 0; i < 3; i++)
            StdOut.print(deque.popRight() + " ");
    }
    private Item[] a = (Item[]) new Object[1];
    private int N;
    private int head;
    private int tail;
    public Ex10333ResizingArrayDeque() {

    }
    private void resize(int max) {
        Item[] temp = a;
        a = (Item[]) new Object[max];
        int start= max / 4;
        for (int i = 0; i < N; i++)
            a[i + start] = temp[head + i];
        head = start;
        tail = head + N;
    }
    public int size() {
        return N;
    }
    public void pushLeft(Item item) {
        if (head == 0) resize(2 * N);
        a[--head] = item;
        N++;
    }
    public void pushRight(Item item) {
        if (tail == a.length) resize(2 * N);
        a[tail++] = item;
        N++;
    }
    public Item popLeft() {
        if (N == a.length / 4) resize(2 * N);
        Item item = a[head++];
        N--;
        return item;
    }
    public Item popRight() {
        if (N == a.length / 4) resize(2 * N);
        Item item = a[--tail];
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }
    public class DequeIterator implements Iterator<Item> {
        private int index = head;

        public boolean hasNext() {
            return index != tail;
        }

        public Item next() {
            Item item = a[index++];
            return item;
        }

        public void remove() {

        }
    }
}
