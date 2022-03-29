package lib;

public class ArrayUtils {
    public double max(double[] a) {
        double max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max) max = a[i];
        return max;
    }

    public double average(double[] a) {
        int N = a.length;
        double sum = 0.0;
        for (int i = 0; i < N; i++)
            sum += a[i];
        double average = sum / N;
        return average;
    }

    public double[] copy(double[] a) {
        int N = a.length;
        double[] b = new double[N];
        for (int i = 0; i < a.length; i++)
            b[i] = a[i];
        return b;
    }
    public void reverse(double[] a) {
        int N = a.length;
        for (int i = 0; i < N / 2; i++) {
            double temp = a[i];
            a[i] = a[N - 1 -i];
            a[N - 1 -i] = temp;
        }
    }
    public double[][] matrixMul(double[][] a, double[][] b) {
        int N = a.length;
        double[][] c = new double[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++)
                    c[i][j] += a[i][k] * b[k][j];
            }
        return c;
    }
    public static boolean contains(int[] a, int x) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == x) return true;
        return false;
    }
}
