package cat10.ex3;

import cat10.P094Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex10309CompleteInfixOrder {
    public static void main(String[] args) {
        P094Stack<String> stack = new P094Stack<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (!s.equals(")")) stack.push(s);
            else {
                String s2 = stack.pop();
                String op = stack.pop();
                String s1 = stack.pop();
                String exp = "( " + s1 + " " + op + " " + s2 + " " + s;
                stack.push(exp);
            }
        }
        StdOut.println(stack.pop());
    }
}
