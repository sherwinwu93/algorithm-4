package cat10.ex4;

import cat10.P094Stack;
import cat10.ex3.Ex10332Steque;
import edu.princeton.cs.algs4.StdOut;

public class Ex10430Deque {
    public static void main(String[] args) {
        Ex10430Deque deque = new Ex10430Deque();
        deque.pushLeft(4);
        deque.pushLeft(3);
        deque.pushRight(5);
        deque.pushRight(6);
        StdOut.println(deque.popLeft());
        StdOut.println(deque.popLeft());
        deque.pushLeft(2);
        StdOut.println(deque.popRight());
        StdOut.println(deque.popRight());
    }
    private P094Stack<Integer> stack = new P094Stack<Integer>();
    private Ex10332Steque<Integer> steque = new Ex10332Steque<Integer>();
    public void pushLeft(int item) {
        steque.push(item);
    }
    public void pushRight(int item) {
        stack.push(item);
    }
    public int popLeft()  {
        if (steque.isEmpty()) {
            int N = stack.size();
            if (N == 1) return stack.pop();
            for (int i = 0; i < N/2; i++)
                steque.push(stack.pop());
            for (int i = N / 2; i< N; i++)
                steque.enqueue(stack.pop());
            for (int i = N/ 2; i < N; i++ )
                steque.enqueue(steque.pop());
            for (int i = 0; i < N/2; i++)
                stack.push(steque.pop());
        }
        int item = steque.pop();
        return item;
    }
    public int popRight() {
        if (stack.isEmpty()) {
            int N = steque.size();
            if (N==1) return steque.pop();
            for (int i = 0; i <N/2;i++)
                steque.enqueue(steque.pop());
            for (int i = N/2; i <N;i++)
                stack.push(steque.pop());
        }
        int item = stack.pop();
        return item;
    }
}
