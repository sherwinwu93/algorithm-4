package cat10.ex3;

import cat10.P095Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex10341CopyQueue {
    // 见P095Queue
    public static void main(String[] args) {
        P095Queue<String> r = new P095Queue<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            r.enqueue(s);
        }
        P095Queue<String> q = new P095Queue<String>(r);
        for (String s : r)
            StdOut.print(s + " ");
        StdOut.println();
        for (String s : q)
            StdOut.print(s + " ");
    }
}
