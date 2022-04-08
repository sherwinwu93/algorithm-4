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
        steque.enqueue(item);
    }
    public void pushRight(int item) {
        if (!stack.isEmpty()) stackToSteque();;
        steque.push(item);
    }
    public int popLeft()  {
        if (!steque.isEmpty()) stequeToStack();
        return stack.pop();
    }
    public int popRight() {
        if (!stack.isEmpty()) stackToSteque();
        return steque.pop();
    }
    private void stackToSteque() {
        int N = stack.size();
        for (int i = 0; i < N; i++)
            steque.push(stack.pop());
    }
    private void stequeToStack() {
        int N = steque.size();
        for (int i = 0; i < N; i++)
            stack.push(steque.pop());
    }
}
