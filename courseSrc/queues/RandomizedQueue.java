import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N;

    public RandomizedQueue() {
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (N == a.length) resize(2 * N);
        a[N++] = item;
    }

    private void resize(int max) {
        Item[] temp = a;
        a = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            a[i] = temp[i];
    }

    public Item dequeue() {
        validateNotEmpty();
        if (N == a.length / 4) resize(2 * N);
        exchange();
        Item item = a[--N];
        a[N] = null;
        return item;
    }

    private void exchange() {
        int random = StdRandom.uniform(N);
        Item last = a[N - 1];
        a[N - 1] = a[random];
        a[random] = last;
    }

    private void validateNotEmpty() {
        if (isEmpty()) throw new NoSuchElementException();
    }

    public Item sample() {
        validateNotEmpty();
        exchange();
        return a[N - 1];
    }

    public Iterator<Item> iterator() {
        return new RandomQueueIterator();
    }

    private class RandomQueueIterator implements Iterator<Item> {
        private int index;
        private Item[] b;

        public RandomQueueIterator() {
            b = (Item[]) new Object[N];
            for (int i = 0; i < N; i++)
                b[i] = a[i];
            StdRandom.shuffle(b);
        }

        public boolean hasNext() {
            return index != N;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return b[index++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> q = new RandomizedQueue<Integer>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(4);
        q.enqueue(5);
        StdOut.println("4:" + q.size());
        StdOut.println("5?:" + q.sample());
        StdOut.println("4:" + q.size());
        StdOut.println("5?:" + q.dequeue());
        StdOut.println("3:" + q.size());
        for (int i : q)
            StdOut.println(i);
    }
}
