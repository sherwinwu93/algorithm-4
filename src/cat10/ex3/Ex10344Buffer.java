package cat10.ex3;


import cat10.P094Stack;
import edu.princeton.cs.algs4.StdOut;

// 使用两个栈
public class Ex10344Buffer {
    public static void main(String[] args) {
        char s = 's';
        char x = 'x';
        char y = 'y';
        char z = 'z';
        Ex10344Buffer buffer = new Ex10344Buffer();
        buffer.insert(s);
        buffer.insert(x);
        buffer.insert(y);
        buffer.insert(z);
        buffer.left(2);
        StdOut.println(buffer.delete());
        StdOut.println(buffer.delete());
    }
    private P094Stack<Character> l = new P094Stack<Character>();
    private P094Stack<Character> r = new P094Stack<Character>();

    public Ex10344Buffer() {
    }

    // 在光标位置插入字符c
    public void insert(char c) {
        l.push(c);
    }

    //删除并返回光标位置的字符
    public char delete() {
        if (l.isEmpty()) throw new RuntimeException("error");
        else return l.pop();
    }

    // 光标向左移动k个位置
    public void left(int k) {
        for (int i = 0; i < k && !l.isEmpty(); i++)
            r.push(l.pop());
    }

    //光标向右移动k个位置
    public void right(int k) {
        for (int i = 0; i < k && !r.isEmpty(); i++)
            l.push(r.pop());
    }

    //缓存区中的字符数量
    public int size() {
        return l.size() + r.size();
    }
}
