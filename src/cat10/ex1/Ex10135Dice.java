package cat10.ex1;

import edu.princeton.cs.algs4.StdRandom;
import lib.PrintUtils;

public class Ex10135Dice {
    private static int SIDES = 6;

    // 1亿
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] times = new int[2 * SIDES + 1];
        for (int i = 0; i < N; i++) {
            int a = StdRandom.uniform(SIDES) + 1;
            int b = StdRandom.uniform(SIDES) + 1;
            times[a + b] += 1;
        }
        int sum = sum(times);
        double[] rates = new double[2 * SIDES + 1];
        for (int i = 2; i < rates.length; i++)
            rates[i] = 1. * times[i] / sum;
        PrintUtils.printArray(dist());
        PrintUtils.printArray(rates);
    }
    private static int sum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++)
            sum += a[i];
        return sum;
    }

    private static double[] dist() {
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i + j] += 1.0;
        for (int k = 2; k <= 2 * SIDES; k++)
            dist[k] /= 36.0;
        return dist;
    }
}
