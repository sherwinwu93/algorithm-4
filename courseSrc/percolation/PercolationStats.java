import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final double[] x;
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();
        x = new double[trials];
        for (int t = 0; t < trials; t++) {
            int openSiteNum = 0;
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                int i = StdRandom.uniform(1, n + 1);
                int j = StdRandom.uniform(1, n + 1);
                if (p.isOpen(i, j)) continue;
                p.open(i, j);
                openSiteNum++;
            }
            x[t] = 1. * openSiteNum / (n * n);
        }
    }

    // averageX: x就是渗滤阈值
    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(x);
    }

    // s
    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(x);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(x.length);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(x.length);
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(n, T);
        StdOut.printf("%-23s = %f\n", "mean", stats.mean());
        StdOut.printf("%-23s = %f\n", "stddev", stats.stddev());
        StdOut.printf("%-23s = [%f, %f]\n",
                "95% confidence interval", stats.confidenceLo(), stats.confidenceHi());
    }
}
