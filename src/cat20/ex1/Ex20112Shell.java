package cat20.ex1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import lib.PrintUtils;

/**
 */
public class Ex20112Shell {
    private static int compareTimes;
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1;
        while (h >= 1) {
            compareTimes = 0;
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j-=h)
                    exch(a, j, j-h);
            }
            StdOut.println(1.0 * compareTimes / N);
            h = h /3;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        compareTimes++;
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    /**
     * % more words3.txt
     * % java Example < words.txt
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int N = 100; true; N*=10)
            rateTrial(N);
    }
    private static void rateTrial(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        sort(a);
    }
}
/*
0.74
1.57
2.13
2.74
0.806
1.637
2.229
2.774
3.356
2.676
0.0159
0.8996
1.7453
2.3717
2.9741
3.5049
4.8026
3.9891
2.7994
0.11427
0.97908
1.76044
2.41378
3.02175
3.69436
4.96787
5.96
7.2816
4.65121
2.7518
0.202839
1.050106
1.830435
2.454563
3.074579
3.86317
5.074654
6.770192
9.641418
13.112006
10.590425
4.729616
2.759335
0.2825547
1.120868
1.8972959
2.502368
3.118812
3.9360689
5.1136568
7.0353313
比较次数<=k * N*递增序列的长度
 */
