package cat10.ex3;

import cat10.P094Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex10342CopyStack {
    // 复制栈
    // 见P094Stack
    public static void main(String[] args) {
        P094Stack<String> r = new P094Stack<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            r.push(s);
        }
        P094Stack<String> q = new P094Stack<String>(r);
        for (String s : r)
            StdOut.print(s + " ");
        StdOut.println();
        for (String s : q)
            StdOut.print(s + " ");
    }
}
