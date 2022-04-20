package cat20.ex1;

import cat10.P110Stopwatch;
import cat20.P156Selection;
import cat20.P157Insertion;
import cat20.P163Shell;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex20136SortCompare {
    public static void main(String[] args) {
        String alg = args[0];
        int T = Integer.parseInt(args[1]);
        for (int N = 125; true; N += N) {
            double half = time(alg, N, T, "half");
            double quarter = time(alg, N, T, "quarter");
            double halfRandom = time(alg, N, T, "halfRandom");
            StdOut.printf("%6d %7.4f %7.4f %7.4f\n", N, half, quarter, halfRandom);
        }
    }
    public static double time(String alg, int N, int T, String arrayType) {
        double total = .0;
        for (int t = 0; t < T; t++) {
            Comparable[] a = array(N, arrayType);
            total += time(alg, a);
        }
        return total / T;
    }
    public static double time(String alg, Comparable[] a) {
        P110Stopwatch timer = new P110Stopwatch();
        if (alg.equals("selection")) P156Selection.sort(a);
        if (alg.equals("insertion")) P157Insertion.sort(a);
        if (alg.equals("shell")) P163Shell.sort(a);
        return timer.elapsedTime();
    }
    private static Comparable[] array(int N, String arrayType) {
        if (arrayType.equals("half")) return halfArray(N);
        else if (arrayType.equals("quarter")) return quarterArray(N);
        else return halfRandomArray(N);
    }
    private static Comparable[] halfArray(int N) {
        Comparable[] a = new Comparable[N];
        int mid = N / 2;
        for (int i = 0; i < mid; i++)
            a[i] = 0;
        for (int i = mid; i < N; i++)
            a[i] = 1;
        return a;
    }
    private static Comparable[] quarterArray(int N) {
        Comparable[] a = new Comparable[N];
        int mid = N / 2;
        int quarter = 3 * N / 4;
        for (int i = 0; i < mid; i++)
            a[i] = 0;
        for (int i = mid; i< quarter; i++)
            a[i] = 1;
        for (int i = quarter; i < N; i++)
            a[i] = 2;
        return a;
    }
    private static Comparable[] halfRandomArray(int N) {
        Comparable[] a = new Comparable[N];
        int mid = N / 2;
        for (int i = 0; i < mid; i++)
            a[i] = 0;
        for (int i = mid; i < N; i++)
            a[i] = StdRandom.uniform(mid, N);
        return a;
    }
}
/**
 * selection
 *    125  0.0005  0.0001  0.0001
 *    250  0.0002  0.0000  0.0001
 *    500  0.0003  0.0004  0.0002
 *   1000  0.0007  0.0005  0.0006
 *   2000  0.0040  0.0026  0.0027
 *   4000  0.0102  0.0107  0.0103
 *   8000  0.0407  0.0393  0.0395
 *  16000  0.1516  0.1541  0.1546
 *  与输入无关
 *  insertion
 *     125  0.0001  0.0000  0.0000
 *    250  0.0000  0.0000  0.0001
 *    500  0.0000  0.0000  0.0002
 *   1000  0.0000  0.0000  0.0001
 *   2000  0.0000  0.0000  0.0005
 *   4000  0.0000  0.0000  0.0024
 *   8000  0.0000  0.0000  0.0101
 *  16000  0.0000  0.0000  0.0386
 *  32000  0.0000  0.0000  0.1492
 *  64000  0.0000  0.0001  0.7073
 *  数组1,数组2很快,数组3较慢
 *  shell
 *     125  0.0001  0.0000  0.0000
 *    250  0.0001  0.0000  0.0001
 *    500  0.0001  0.0000  0.0002
 *   1000  0.0001  0.0001  0.0002
 *   2000  0.0002  0.0001  0.0003
 *   4000  0.0002  0.0002  0.0002
 *   8000  0.0002  0.0002  0.0006
 *  16000  0.0002  0.0002  0.0010
 *  32000  0.0006  0.0004  0.0023
 *  64000  0.0011  0.0010  0.0059
 * 128000  0.0022  0.0023  0.0134
 * 256000  0.0048  0.0049  0.0334
 * 512000  0.0100  0.0098  0.0690
 * 1024000  0.0210  0.0211  0.1838
 * 数组1, 数组2 较快(但没有insertion快),数组3较慢(但比insertion快)
 */
