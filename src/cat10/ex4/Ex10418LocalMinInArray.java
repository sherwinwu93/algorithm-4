package cat10.ex4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex10418LocalMinInArray {
    public static void main(String[] args) {
        double[] a = {4, 3, 6, 7, 5, 8, 2};
        int i = localMin(a);
        if (i != -1)
            StdOut.println(a[i]);
    }

    public static int localMin(double[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)  {
            int mid = lo + (hi - lo)/ 2;
            if (mid >= a.length - 1) break;
            double left = a[mid -1];
            double right = a[mid + 1];
            double middle = a[mid];
            if (middle < left && middle < right) return mid;
            else if (left < middle && left < right) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
    }
}
