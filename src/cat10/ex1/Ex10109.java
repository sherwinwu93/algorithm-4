package cat10.ex1;

import edu.princeton.cs.algs4.StdOut;

public class Ex10109 {
    public static void main(String[] args) {
        String s = "";
        int N = Integer.parseInt(args[0]);
        for (; N > 0; N /= 2)
            s = (N % 2) + s;
        StdOut.println(s);
    }
}
