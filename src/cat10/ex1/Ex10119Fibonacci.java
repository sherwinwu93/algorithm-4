package cat10.ex1;

import edu.princeton.cs.algs4.StdOut;

public class Ex10119Fibonacci {
    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 1) + F(N - 2);
    }

    public static void main(String[] args) {
        for (int N = 0; N < 100; N++)
            StdOut.println(N + " " + F(N));
        for (int N = 0; N < 100; N++)
            StdOut.println(N + " " + betterF(N));
    }

    // 用数组保存
    public static long betterF(int N) {
        long[] fibs = new long[N + 2];
        for (int i = 0; i < fibs.length; i++) {
            fibs[i] = -1;
        }
        fibs[0] = 0;
        fibs[1] = 1;
        return betterF(N, fibs);
    }

    private static long betterF(int N, long[] fibs) {
        if (fibs[N] != -1) return fibs[N];
        else {
            long fibN = betterF(N - 1, fibs) + betterF(N - 2, fibs);
            fibs[N] = fibN;
            return fibN;
        }
    }
}
