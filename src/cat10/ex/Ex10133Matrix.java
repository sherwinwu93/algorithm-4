package cat10.ex;

import edu.princeton.cs.algs4.StdIn;

public class Ex10133Matrix {
    // x乘以yT
    public static double dot(double[] x, double[] y) {
        int N = x.length;
        double product = .0;
        for (int i = 0; i < N; i++)
            product += x[i] * y[i];
        return product;
    }
    // a * b
    public static double[][] mult(double[][] a, double[][] b) {
        int M = a.length;
        int N = b.length;
        double[][] bT = transpose(b);
        double[][] c = new double[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                c[i][j] = dot(a[i], bT[j]);
        return c;
    }
    public static double[][] transpose(double[][] a) {
        int M = a.length;
        int N = a[0].length;
        double[][] aT = new double[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                aT[i][j] = a[j][i];
        return aT;
    }
    public static double[] mult(double[][] a, double[] x)  {
        int M = a.length;
        double[] c = new double[M];
        for (int i = 0; i < M; i++)
            c[i] = dot(a[i], x);
        return c;
    }
    public static double[] mult(double[] y, double[][] a) {
        int M = a.length;
        double[] c = new double[M];
        double[][] aT = transpose(a);
        for (int i = 0; i < M; i++)
            c[i] = dot(aT[i], y);
        return c;
    }

    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            double e = StdIn.readDouble();
        }
    }
}
