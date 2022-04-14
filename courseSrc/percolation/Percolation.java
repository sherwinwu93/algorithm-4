import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[] sites;
    private int N;
    private int count;
    private WeightedQuickUnionUF uf;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        N = n;
        int M = N * N;
        uf = new WeightedQuickUnionUF(M + 2);
        sites = new boolean[M + 2];
        sites[M] = true;
        sites[M + 1] = true;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        int i = realIndex(row, col);
        if (sites[i]) return;
        sites[i] = true;
        count++;
        unionAround(row, col);
    }

    private void unionAround(int row, int col) {
        if (row == 0) unionTop(col);
        if (row == N - 1) unionDown(col);
        unionOther(row, col, row - 1, col);
        unionOther(row, col, row, col - 1);
        unionOther(row, col, row + 1, col);
        unionOther(row, col, row, col + 1);
    }

    private void unionOther(int row, int col, int nextRow, int nextCol) {
        if (outOfBound(row) || outOfBound(col) || outOfBound(nextRow) || outOfBound(nextCol)) return;
        int i = realIndex(row, col);
        int nextI = realIndex(nextRow, nextCol);
        if (sites[i] && sites[nextI])
            uf.union(i, nextI);
    }

    private boolean outOfBound(int no) {
        return no < 0 || no >= N;
    }

    private void unionTop(int col) {
        uf.union(realIndex(0, col), N * N);
    }

    private void unionDown(int col) {
        uf.union(realIndex(N - 1, col), N * N + 1);
    }

    private int realIndex(int row, int col) {
        return row * N + col;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return sites[realIndex(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        int i = realIndex(row, col);
        if (!sites[i]) return false;
        else return uf.connected(N * N, i);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return count;
    }

    // does the system percolate?
    public boolean percolates() {
        int M = N * N;
        return uf.connected(M, M + 1);
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation p = new Percolation(4);
        p.open(0, 0);
        p.open(1, 0);
        p.open(1, 2);
        p.open(2, 0);
        p.open(2, 1);
        p.open(3, 1);
        StdOut.println("true:" + p.isOpen(1, 2));
        StdOut.println("false:" + p.isFull(1, 2));
        StdOut.println("6:" + p.numberOfOpenSites());
        StdOut.println("true:" + p.percolates());
    }
}
