package cat10;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * 算法1.4 背包
 * @param <Item>
 */
public class P098Bag<Item> implements Iterable<Item> {
    public static void main(String[] args) {
        P098Bag<String> b = new P098Bag<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                b.add(item);
        }
        for (String s : b) {
            StdOut.println(s);
        }
    }
    private Node first;
    private int N;
    private class Node {
        Item item;
        Node next;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public int size() {
        return N;
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node currentNode = first;

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
