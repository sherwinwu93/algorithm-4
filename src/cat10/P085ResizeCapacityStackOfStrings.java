package cat10;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 使用率在1/4到1/2之间
 * 沙曼罗蛇
 */
public class P085ResizeCapacityStackOfStrings {
    private String[] a;//stack entries
    private int N; //size
    public P085ResizeCapacityStackOfStrings() {
        a = new String[1];
    }
    //检查数组是否太小,就长度加倍
    void push(String item) {
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }
    //检查数组是否太大,太大就长度减半
    String pop() {
        // 栈顶删除元素
        String item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return item;
    }
    boolean isEmpty() {
        return N == 0;
    }
    int size() {
        return N;
    }
    private void resize(int max) {
        String[] temp = new String[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }
    //测试用例
    public static void main(String[] args) {
        P085ResizeCapacityStackOfStrings s;
        s = new P085ResizeCapacityStackOfStrings();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
