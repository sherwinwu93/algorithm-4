package cat10.ex4;

import cat10.P094Stack;
import edu.princeton.cs.algs4.StdOut;

public class Ex10431Deque {
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
    private P094Stack<Integer> reverseStack = new P094Stack<Integer>();
    private P094Stack<Integer> exchangeStack = new P094Stack<Integer>();
    private P094Stack<Integer> stack = new P094Stack<Integer>();
    public void pushLeft(int item) {
        reverseStack.push(item);
    }
    public int popLeft() {
        if (reverseStack.isEmpty()) //todo
            averageFromStack();
        return reverseStack.pop();
    }
    private void averageFromStack() {
        int N = stack.size();
        if (N == 1) {
            reverseStack.push(stack.pop());
            return;
        }
        for (int i = 0; i < N / 2; i++)
            exchangeStack.push(stack.pop());
        for (int i = 0; i < N / 2; i++)
            reverseStack.push(exchangeStack.pop());
        for (int i = N / 2; i < N; i++)
            exchangeStack.push(stack.pop());
        P094Stack<Integer> tempReverseStack = reverseStack;
        P094Stack<Integer> tempExchangeStack = exchangeStack;
        P094Stack<Integer> tempStack = stack;
        reverseStack = tempExchangeStack;
        exchangeStack = tempStack;
        stack = tempReverseStack;
    }

    public void pushRight(int item) {
        stack.push(item);
    }
    public int popRight() {
        if (stack.isEmpty()) // todo
            averageFromReverseStack();
        return stack.pop();
    }
    private void averageFromReverseStack() {
        int N = reverseStack.size();
        if (N == 1) {
            stack.push(reverseStack.pop());
        }
        for (int i = 0; i < N / 2; i++)
            exchangeStack.push(reverseStack.pop());
        for (int i = 0; i < N / 2; i++)
            stack.push(exchangeStack.pop());
        for (int i = N/2; i < N; i++)
            exchangeStack.push(reverseStack.pop());
        P094Stack<Integer> tempReverseStack = reverseStack;
        P094Stack<Integer> tempExchangeStack = exchangeStack;
        P094Stack<Integer> tempStack = stack;
        reverseStack = tempStack;
        exchangeStack = tempReverseStack;
        stack = tempExchangeStack;
    }
    public int size() {
        return reverseStack.size() + stack.size();
    }
    public boolean isEmpty() {
        return reverseStack.isEmpty() && stack.isEmpty();
    }
}
