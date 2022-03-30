package cat10.ex3;

import cat10.P094Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex10304Parentheses {
    public static void main(String[] args) {
        P094Stack<String> ops = new P094Stack<String>();
        while (!StdIn.isEmpty()) {
            String op = StdIn.readString();
            if (ops.isEmpty()) ops.push(op);
            else {
                String opV = ops.pop();
                if (match(opV, op));
                else {
                    ops.push(opV);
                    ops.push(op);
                }
            }
        }
        StdOut.println(ops.isEmpty());
    }

    private static boolean match(String left, String right) {
        if (left.equals("(") && right.equals(")")) return true;
        else if (left.equals("[") && right.equals("]")) return true;
        else if (left.equals("{") && right.equals("}")) return true;
        else return false;
    }
}
