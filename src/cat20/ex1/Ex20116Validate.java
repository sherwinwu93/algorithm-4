package cat20.ex1;

import cat20.P157Insertion;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Ex20116Validate {
    static public boolean check(Comparable[] a) {
        int N = a.length;
        Comparable[] b = new Comparable[N];
        for (int i = 0; i < N; i++)
            b[i] = a[i];
        Arrays.sort(b);
        for (int i = 0; i < N; i++)
            if (!a[i].equals(b[i])) return false;
        return true;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        StdOut.println(check(a));
        P157Insertion.sort(a);
        StdOut.println(check(a));
    }
}
