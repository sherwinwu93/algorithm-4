import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {
    private int times;
    private int total;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        times = trials;
        Percolation p = new Percolation(n);
        for (int t = 0; t < trials; t++) {
            while (!p.percolates()) {
                int i = StdRandom.uniform(0, n);
                int j = StdRandom.uniform(0, n);
                if (p.isOpen(i, j)) continue;
                p.open(i, j);
                total++;
            }
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return 1. * total / times;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {

    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {

    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {

    }

    // test client (see below)
    public static void main(String[] args) {

    }
}
