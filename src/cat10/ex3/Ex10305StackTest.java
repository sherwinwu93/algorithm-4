package cat10.ex3;

import cat10.P094Stack;
import edu.princeton.cs.algs4.StdOut;

public class Ex10305StackTest {
    // N的二进制表示
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        P094Stack<Integer> stack = new P094Stack<Integer>();
        while (N > 0) {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d : stack) StdOut.print(d);
        StdOut.println();
    }
}
