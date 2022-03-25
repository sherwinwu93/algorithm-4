package cat10.ex;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Ex10131RandomConnection {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        double x0 = .5;
        double y0 = .5;
        double r = .5;
        StdDraw.circle(x0, y0, r);
        for (int i = 0; i < N; i++) {
            double angle = 2 * Math.PI / N * (i + 1);
            double x = x0 + Math.sin(angle) * r;
            double y = y0 + Math.cos(angle) * r;
            StdDraw.filledCircle(x, y, .05);
            if (StdRandom.bernoulli(p)) {
                double angle2 = 2 * Math.PI / N * (i + 2);
                double x2 = x0 + Math.sin(angle2) * r;
                double y2 = y0 + Math.cos(angle2) * r;
                StdDraw.line(x, y, x2, y2);
            }
        }
    }
}
