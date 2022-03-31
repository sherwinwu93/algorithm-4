package cat10.ex3;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class Ex10334RandomBag<Item> implements Iterable<Item> {
    public static void main(String[] args) {
        Ex10334RandomBag<String> bag = new Ex10334RandomBag<String>();
        for (int i = 0 ; i < 32; i++)
            bag.add(i + "");
        for (String s: bag)
            StdOut.print(s + " ");
        StdOut.println();
    }
    private Item[] a = (Item[]) new Object[1];
    private int N;
    public Ex10334RandomBag() {
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    public void add(Item item) {
        if (N == a.length) resize(2 * N);
        a[N++] = item;
    }
    private void resize(int max) {
        Item[] temp = a;
        a = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            a[i] = temp[i];
    }
    public Iterator<Item> iterator() {
        return new RandomBagIterator();
    }
    public class RandomBagIterator implements Iterator<Item> {
        private Item[] b;
        private int index;

        public RandomBagIterator() {
            b = (Item[]) new Object[N];
            for (int i = 0; i < N; i++)
                b[i] = a[i];
            StdRandom.shuffle(b);
        }

        public boolean hasNext() {
            return index != N;
        }

        public Item next() {
            Item item = b[index++];
            return item;
        }

        public void remove() {

        }
    }
}
