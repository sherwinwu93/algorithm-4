package cat10.ex2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex10203Interval2DTest {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);
        Interval1D xintevalOfBox = new Interval1D(min, max);
        Interval1D yintevalOfBox = new Interval1D(min, max);
        Interval2D box = new Interval2D(xintevalOfBox, yintevalOfBox);
        box.draw();
        Interval2D[] ds = new Interval2D[N];
        for (int i = 0; i < N; i++) {
            double xlo = StdRandom.uniform(min, max);
            double xhi = StdRandom.uniform(min, max);
            Interval1D xinterval;
            if (xlo < xhi) xinterval = new Interval1D(xlo, xhi);
            else xinterval = new Interval1D(xhi, xlo);
            double ylo = StdRandom.uniform(min, max);
            double yhi = StdRandom.uniform(min, max);
            Interval1D yinterval;
            if (ylo < yhi) yinterval = new Interval1D(ylo, yhi);
            else yinterval = new Interval1D(yhi, ylo);
            Interval2D interval2D = new Interval2D(xinterval, yinterval);
            ds[i] = interval2D;
            interval2D.draw();
        }

        for (int i = 0; i < N -1; i++)
            for (int j = i + 1; j < N; j++)
                if (ds[i].intersects(ds[j]))
                    StdOut.println(ds[i] + " " + ds[j]);
    }
}
