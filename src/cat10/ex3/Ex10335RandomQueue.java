package cat10.ex3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class Ex10335RandomQueue<Item> implements Iterable<Item> {
    public static void main(String[] args) {
        Ex10335RandomQueue<Integer> queue = new Ex10335RandomQueue<Integer>();
        for (int i = 0 ; i < 32; i++)
            queue.enqueue(i);
        for (int i = 0; i < 10; i++)
            StdOut.print(queue.dequeue() + " ");
        StdOut.println();
        for (int i = 0; i < 10; i++)
            StdOut.print(queue.sample() + " ");
        StdOut.println();
        for (Integer integer : queue)
            StdOut.print(integer + " ");
    }
    private Item[] a = (Item[]) new Object[100];
    private int N = 0;
    public Ex10335RandomQueue(){}
    public boolean isEmpty() {
        return N == 0;
    }
    public void enqueue(Item item) {
        a[N++] = item;
    }
    public Item dequeue() {
        exchange();
        return a[--N];
    }
    private void exchange() {
        int random = StdRandom.uniform(N);
        Item last = a[N - 1];
        a[N - 1] = a[random];
        a[random] = last;
    }
    public Item sample() {
        exchange();
        return a[N - 1];
    }
    public Iterator<Item> iterator() {
        return new RandomQueueIterator();
    }
    public class RandomQueueIterator implements Iterator<Item> {
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
            return b[index++];
        }

        public void remove() {

        }
    }
}
