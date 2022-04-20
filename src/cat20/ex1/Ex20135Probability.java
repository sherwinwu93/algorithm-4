package cat20.ex1;

import cat10.P110Stopwatch;
import cat20.P156Selection;
import cat20.P157Insertion;
import cat20.P163Shell;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex20135Probability {
    public static void main(String[] args) {
        String alg = args[0];
        int N = Integer.parseInt(args[1]);
        int T = Integer.parseInt(args[2]);
        double gaussianPrev = timeRandomInput(alg, "gaussian", N / 2);
        for (int t = 0, temp = N; t < T; t++, temp += temp) {
            double time = timeRandomInput(alg, "gaussian", temp);
            StdOut.println(time / gaussianPrev);
            gaussianPrev = time;
        }
        StdOut.println();
        double poissonPrev = timeRandomInput(alg, "poisson", N / 2);
        for (int t = 0, temp = N; t < T; t++, temp += temp) {
            double time = timeRandomInput(alg, "poisson", temp);
            StdOut.println(time / poissonPrev);
            poissonPrev = time;
        }
        StdOut.println();
        double geometricPrev = timeRandomInput(alg, "geometric", N / 2);
        for (int t = 0, temp = N; t < T; t++, temp += temp) {
            double time = timeRandomInput(alg, "geometric", temp);
            StdOut.println(time / geometricPrev);
            geometricPrev = time;
        }
        StdOut.println();
        double dis = timeRandomInput(alg, "dis", N / 2);
        for (int t = 0, temp = N; t < T; t++, temp += temp) {
            double time = timeRandomInput(alg, "dis", temp);
            StdOut.println(time / dis);
            dis = time;
        }
    }

    private static double timeRandomInput(String alg, String method, int N) {
        Comparable[] a;
        if (method.equals("gaussian")) a = gaussian(N);
        else if (method.equals("poisson")) a = poisson(N);
        else if (method.equals("geometric")) a = geometric(N);
        else a = discrete(N);
        return time(alg, a);
    }

    private static double time(String alg, Comparable[] a) {
        P110Stopwatch timer = new P110Stopwatch();
        if (alg.equals("selection")) P156Selection.sort(a);
        if (alg.equals("insertion")) P157Insertion.sort(a);
        if (alg.equals("shell")) P163Shell.sort(a);
        return timer.elapsedTime();
    }

    public static Comparable[] gaussian(int N) {
        Comparable[] a = new Comparable[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.gaussian();
        return a;
    }

    public static Comparable[] poisson(int N) {
        Comparable[] a = new Comparable[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.poisson(2);
        return a;
    }

    public static Comparable[] geometric(int N) {
        Comparable[] a = new Comparable[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.geometric(0.3);
        return a;
    }

    public static Comparable[] discrete(int N) {
        Comparable[] a = new Comparable[N];
        for (int i = 0; i < N; i++)
            a[i] = i % 2 == 0 ? 0 : 1;
        return a;
    }
}

/**
 * 选择排序
 * 0.75
 * 0.8333333333333334
 * 4.0
 * 4.1
 * 4.512195121951219
 *
 * 2.5
 * 1.6
 * 2.125
 * 4.294117647058823
 * 4.219178082191781
 *
 * Infinity
 * 4.5
 * 4.333333333333334
 * 4.487179487179487
 * 3.6171428571428574
 *
 * 1.0
 * 4.0
 * 4.5
 * 3.7222222222222228
 * 4.850746268656716
 */
/**
 * 插入
 * 1.0
 * 0.888888888888889
 * 3.625
 * 2.793103448275862
 * 4.666666666666667
 *
 * 1.0
 * 2.6666666666666665
 * 2.875
 * 3.695652173913044
 * 3.576470588235294
 *
 * Infinity
 * 4.0
 * 4.0
 * 3.875
 * 5.290322580645162
 *
 * Infinity
 * 3.0
 * 3.3333333333333335
 * 5.5
 * 3.2545454545454544
 **/
/**
 * 希尔排序
 * 0.6666666666666666
 * 1.5
 * 1.0
 * 1.6666666666666667
 * 1.0
 *
 * NaN
 * NaN
 * Infinity
 * 0.3333333333333333
 * 1.0
 *
 * NaN
 * NaN
 * NaN
 * Infinity
 * 1.0
 *
 * NaN
 * NaN
 * NaN
 * NaN
 * Infinity
 **/