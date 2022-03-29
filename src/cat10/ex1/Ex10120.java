package cat10.ex1;

import edu.princeton.cs.algs4.StdOut;

public class Ex10120 {
    public static void main(String[] args) {
        StdOut.println(lnFactorial(3));
    }

    public static int lnFactorial(int N) {
        int fac = factorial(N);
        return ln(0, 1, fac);
    }

    private static int ln(int x, double y, int fact) {
        if (y > fact) return x - 1;
        else return ln(x + 1, y * Math.E, fact);
    }


    private static int factorial(int N) {
        if (N == 1) return 1;
        else return N * factorial(N - 1);
    }
}
