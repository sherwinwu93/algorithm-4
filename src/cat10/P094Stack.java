package cat10;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * 算法1.2 下压堆栈 (链表实现)
 */
public class P094Stack<Item> implements Iterable<Item>{

    public static void main(String[] args) {
        P094Stack<String> s= new P094Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
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
    // O(c)
    public void push(Item item) {
        Node oldFirst = first;
        // 这个也是O(c)
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    public P094Stack() {
    }
    public P094Stack(P094Stack<Item> s) {
        P094Stack<Item> reverse = new P094Stack<Item>();
        while (!s.isEmpty())
            reverse.push(s.pop());
        while (!reverse.isEmpty()) {
            Item item = reverse.pop();
            s.push(item);
            push(item);
        }
    }
    public Item peek() {
        return first.item;
    }
    public int size() {
        return N;
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node curr = first;
        private int M = N;

        public boolean hasNext() {
            if (changed()) throw new ConcurrentModificationException();
            return curr != null;
        }

        private boolean changed() {
            return M != N;
        }

        public Item next() {
            if (changed()) throw new ConcurrentModificationException();
            Item item = curr.item;
            curr = curr.next;
            return item;
        }

        public void remove() {

        }
    }
}
