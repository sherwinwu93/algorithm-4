package cat10.ex3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex10311EvaluatePostfix {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                double s2 = vals.pop();
                double s1 = vals.pop();
                if (op.equals("+")) vals.push(s1 + s2);
                else if (op.equals("-")) vals.push(s1 - s2);
                else if (op.equals("*")) vals.push(s1 * s2);
                else if (op.equals("/")) vals.push(s1 / s2);
            } else vals.push(Double.valueOf(s));
        }
        StdOut.println(vals.pop());
    }
}
