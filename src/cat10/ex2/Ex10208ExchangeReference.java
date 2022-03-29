package cat10.ex2;

import edu.princeton.cs.algs4.StdOut;

public class Ex10208ExchangeReference {
    public static void main(String[] args) {
        int[] a = {1};
        int[] b = {2};
        exchange(a, b);
        StdOut.println(a[0]);
        StdOut.println(b[0]);
    }
    public static void exchange(int[] a, int[] b) {
        int[] t = a;
        a = b;
        b = t;
        StdOut.println(a[0]);
        StdOut.println(b[0]);
    }
}
