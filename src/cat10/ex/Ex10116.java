package cat10.ex;

import edu.princeton.cs.algs4.StdOut;

public class Ex10116 {
    public static void main(String[] args) {
        // 311361142246
        StdOut.print(exR1(6));
    }
    public static String exR1(int n) {
        if (n <= 0) return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }
}
