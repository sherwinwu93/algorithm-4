package cat10.ex4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import lib.PrintUtils;

import java.util.Arrays;

public class Ex10424ThrowEgg {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double key = Double.parseDouble(args[1]);
        double[] a = new double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(0, 100.0);
        Arrays.sort(a);
        PrintUtils.printArray(a);

        int g = findG(key, a);
        int rank = rank(key, a, g / 2, g);
        if (rank == -1) rank = g/2 + 1;
        StdOut.println(rank);
    }
    public static int findG(double key,double[] a) {
        int N = a.length;
        int x = 1;
        while (a[x] < key && x * 2 < N)
        // 当while的某个数是增加的时候,这个数会得到与循环条件相反的结果
        // 比如: a[x] < key, 经过循环后就是a[x] >= key, 我们认为鸡蛋>=key就会碎
            x += x;
        return x;
    }

    public static int rank(double key, double[] a, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) /2;
        if (isMaxLayer(key, mid, a)) return mid;
        else if (key < a[mid]) return rank(key, a, lo, mid - 1);
        else return rank(key, a, mid + 1, hi);
    }

    private static boolean isMaxLayer(double key, int layer, double[] a) {
        int N = a.length;
        if (layer  == N - 1) return true;
        else return a[layer] < key && a[layer + 1] >= key;
    }
}
