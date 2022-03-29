package cat10.ex2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex10202Interval1DTest {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Interval1D[] is = new Interval1D[N];
        for (int i = 0; i < N; i++) {
            double l = StdIn.readDouble();
            double r = StdIn.readDouble();
            if (l <= r) is[i] = new Interval1D(l, r);
            else is[i] = new Interval1D(r, l);
        }
        for (int i = 0; i < N - 1; i++)
            for (int j = i + 1; j < N; j++)
                if (is[i].intersects(is[j]))
                    StdOut.println(is[i] + " " + is[j]);
    }
}
