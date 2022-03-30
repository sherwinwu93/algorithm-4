package cat10;

import java.util.Iterator;

/**
 * 算法1.1 下压栈(能够动态调整数组大小的实现)
 * 几乎达到了(但还没有)
 *      每项操作的用时都与集合大小无关
 *      空间需求总是不超过集合大小乘以一个常数
 * @param <Item>
 */
public class P088ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }
    public void push(Item item) {
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }
    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length/4) resize(a.length /2);
        return item;
    }
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;
        public boolean hasNext() {
            return i > 0;
        }
        public Item next() {
            return a[--i];
        }
        public void remove() {}
    }
}
