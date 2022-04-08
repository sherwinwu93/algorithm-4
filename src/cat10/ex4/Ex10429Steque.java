package cat10.ex4;

import cat10.P094Stack;
import edu.princeton.cs.algs4.StdOut;

public class Ex10429Steque {
    public static void main(String[] args) {
        Ex10429Steque steque = new Ex10429Steque();
        steque.push("1");
        steque.push("2");
        steque.push("3");
        steque.push("4");
        steque.push("5");
        steque.enqueue("6");
        steque.enqueue("7");
        StdOut.println(steque.pop());
        StdOut.println(steque.pop());
        StdOut.println(steque.pop());
        StdOut.println(steque.pop());
        StdOut.println(steque.pop());
        StdOut.println(steque.pop());
        StdOut.println(steque.pop());
    }
    private P094Stack<String> s1 = new P094Stack<String>();
    private P094Stack<String> s2 = new P094Stack<String>();
    public Ex10429Steque() {
    }
    public void push(String item) {
        s1.push(item);
    }
    public String pop() {
        if (s1.isEmpty()) s2Tos1();
        return s1.pop();
    }
    public void s2Tos1() {
        int N = s2.size();
        for (int i = 0; i < N; i++)
            s1.push(s2.pop());
    }
    public void enqueue(String item) {
        s2.push(item);
    }
    public int size() {
        return s1.size() + s2.size();
    }
    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
