package cat10;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 数组中元素顺序与被插入顺序相同
 * 当N为0时栈为空
 * 栈的顶部位于a[N-1]
 */
public class P082FixedCapacityStack<Item> {
    private Item[] a;//stack entries
    private int N; //size

    public P082FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        return a[--N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public boolean isFull() {
        return N == a.length;
    }

    //测试用例
    public static void main(String[] args) {
        P082FixedCapacityStack<String> s;
        s = new P082FixedCapacityStack<String>(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
