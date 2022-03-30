package cat10.ex3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex10310InfixToPostfix {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (!s.equals(")")) stack.push(s);
            else {
                String s2 = stack.pop();
                String op = stack.pop();
                String s1 = stack.pop();
                String left = stack.pop();
                String exp = left + " " + s1 + " " + s2 + " " + op + " " + s;
                stack.push(exp);
            }
        }
        StdOut.println(stack.pop());
    }
}
