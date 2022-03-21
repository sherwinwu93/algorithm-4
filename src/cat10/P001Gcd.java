package cat10;

import edu.princeton.cs.algs4.StdOut;

public class P001Gcd {
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        StdOut.println(gcd(6, 4));
    }
}
