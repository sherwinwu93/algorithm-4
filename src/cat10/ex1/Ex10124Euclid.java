package cat10.ex1;

import edu.princeton.cs.algs4.StdOut;

public class Ex10124Euclid {
    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        euclid(p, q);
    }

    public static int euclid(int p, int q) {
        StdOut.printf("%d\t%d\n", p, q);
        return gcd(p, q);
    }

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        else return euclid(q, p % q);
    }
}
