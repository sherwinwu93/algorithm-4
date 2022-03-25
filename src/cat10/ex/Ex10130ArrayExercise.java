package cat10.ex;

import cat10.P001Gcd;
import lib.PrintUtils;

public class Ex10130ArrayExercise {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        boolean[][] a = new boolean[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                a[i][j] = primes(i, j);
        PrintUtils.print2DArray(a);
    }

    private static boolean primes(int a, int b) {
        return P001Gcd.gcd(a, b) == 1;
    }
}
