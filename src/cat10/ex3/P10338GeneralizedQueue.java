package cat10.ex3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class P10338GeneralizedQueue<Item> {
    public static void main(String[] args) {
        P10338GeneralizedQueue<Integer> queue = new P10338GeneralizedQueue<Integer>();
        while (!StdIn.isEmpty())
            queue.insert(StdIn.readInt());
        StdOut.println(queue.delete(2));
        while (!queue.isEmpty())
            StdOut.print(queue.delete(0) + " ");
    }
    private Item[] a = (Item[]) new Object[100];
    private int N;

    public P10338GeneralizedQueue() {
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Item x) {
        a[N++] = x;
    }

    public Item delete(int k) {
        Item item = a[k];
        remove(k);
        N--;
        return item;
    }

    private void remove(int k) {
        Item[] temp = a;
        a = (Item[]) new Object[a.length];
        for (int i = 0; i < k; i++)
            a[i] = temp[i];
        for (int i = k; i < N; i++)
            a[i] = temp[i + 1];
    }
}
