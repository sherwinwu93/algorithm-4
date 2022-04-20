package cat20.ex1;

import cat10.P110Stopwatch;
import cat20.P156Selection;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Ex20133DistributionDiagram {
    public static void main(String[] args) {
        String alg = args[0];
        int T = Integer.parseInt(args[1]);
        int N = Integer.parseInt(args[2]);
        double standard = timeRandomInput(alg, N, T);
        StdDraw.setXscale(0, 2 * N);
        StdDraw.setYscale(0, standard * 2);
        StdDraw.setPenRadius(.005);
        while (true) {
            double time = timeRandomInput(alg, N, T);
            StdDraw.point(N, time);
        }
    }
    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.;
        for (int t = 0; t<T; t++) {
            Double[] a = new Double[N];
            for (int i = 0; i < a.length; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total / T;
    }

    public static double time(String alg, Double[] a) {
        P110Stopwatch timer = new P110Stopwatch();
        if (alg.equals("selection")) P156Selection.sort(a);
        return timer.elapsedTime();
    }
}
