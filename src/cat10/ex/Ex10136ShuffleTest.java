package cat10.ex;

import edu.princeton.cs.algs4.StdRandom;
import lib.PrintUtils;

public class Ex10136ShuffleTest {
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        int[][] times = new int[M][M];
        int[] a = new int[M];
        for (int i = 0; i < N; i++) {
            initArray(a);
            StdRandom.shuffle(a);
            for (int j = 0; j < M; j++)
                times[j][a[j]] += 1;
        }
        PrintUtils.print2DArray(times);
    }
    private static int[] initArray(int[] a) {
        int M = a.length;
        for (int i = 0; i < M; i++)
            a[i] = i;
        return a;
    }
}
