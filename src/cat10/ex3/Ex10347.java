package cat10.ex3;

import cat10.P094Stack;
import cat10.P095Queue;
import edu.princeton.cs.algs4.StdOut;

public class Ex10347 {
    public static void main(String[] args) {
        P094Stack<Integer> s1 = new P094Stack<Integer>();
        s1.push(1);
        s1.push(2);
        P094Stack<Integer> s2 = new P094Stack<Integer>();
        s2.push(3);
        s2.push(4);
        P094Stack<Integer> catenation = catenation(s1, s2);
        for (int i : catenation) StdOut.println(i);
    }
    public static <Item> P095Queue<Item> catenationQ(P095Queue<Item> q1, P095Queue<Item> q2) {
        P095Queue<Item> catenation = new P095Queue<Item>();
        int size1 = q1.size();
        for (int i = 0; i < size1; i++) {
            Item item = q1.dequeue();
            catenation.enqueue(item);
            q1.enqueue(item);
        }
        int size2 = q2.size();
        for (int i = 0; i < size2; i++) {
            Item item = q2.dequeue();
            catenation.enqueue(item);
            q2.enqueue(item);
        }
        return catenation;
    }

    public static <Item> P094Stack<Item> catenation(P094Stack<Item> s1, P094Stack<Item> s2) {
        P094Stack<Item> temp = new P094Stack<Item>();
        P094Stack<Item> catenation = new P094Stack<Item>();
        while (!s1.isEmpty())
            temp.push(s1.pop());
        while (!temp.isEmpty()) {
            Item item = temp.pop();
            s1.push(item);
            catenation.push(item);
        }
        while (!s2.isEmpty())
            temp.push(s2.pop());
        while (!temp.isEmpty()) {
            Item item = temp.pop();
            s2.push(item);
            catenation.push(item);
        }
        return catenation;
    }
}
