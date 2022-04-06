package cat10.ex4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex10418MinElementInArray {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] a = new double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(0.0, 10.0);
        int minInSome = minInSome(a);
        if (minInSome != -1)
            StdOut.println(a[minInSome]);
    }

    public static int minInSome(double[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/ 2;
            if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1]) return mid;
            else if (a[mid - 1] < a[mid + 1]) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
    }
}
