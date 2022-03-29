package cat10.ex1;

import edu.princeton.cs.algs4.StdOut;

public class Ex10127Binomial {
    public static void main(String[] args) {
        //二项分布
        StdOut.println(betterBinomial(100, 50, 0.25));
    }

    public static double binomial(int N, int k, double p) {
        // 2^N*k/N
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    public static double betterBinomial(int N, int k, double p) {
        double[][] b = new double[N + 1][k + 1];
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < b[i].length; j++)
                b[i][j] = -.1;
        b[0][0] = 1.0;
        return betterBinomial(N, k, p, b);
    }

    private static double betterBinomial(int N, int k, double p, double[][] b) {
        if (N < 0 || k < 0) return 0.0;
        if (b[N][k] > -0.1) return b[N][k];
        double b_Nk = (1. - p) * betterBinomial(N - 1, k, p, b) + p * betterBinomial(N - 1, k - 1, p, b);
        b[N][k] = b_Nk;
        return b_Nk;
    }
}
