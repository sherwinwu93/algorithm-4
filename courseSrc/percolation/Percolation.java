import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[] sites;
    private final int N;
    private int count;
    private final WeightedQuickUnionUF uf;
    private final WeightedQuickUnionUF fullUf;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        N = n;
        int M = N * N;
        uf = new WeightedQuickUnionUF(M + 2);
        fullUf = new WeightedQuickUnionUF(M + 1);
        sites = new boolean[M];
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validateRowCol(row, col);
        int i = realIndex(row, col);
        if (sites[i]) return;
        sites[i] = true;
        count++;
        unionAround(row, col);
    }
    private void validateRowCol(int row, int col) {
        if (outOfBound(row) || outOfBound(col)) {
            StdOut.println(row +"-" + col);
            throw new IllegalArgumentException();
        }
    }

    private void unionAround(int row, int col) {
        if (row == 1) unionTop(col);
        if (row == N) unionDown(col);
        unionOther(row, col, row - 1, col);
        unionOther(row, col, row, col - 1);
        unionOther(row, col, row + 1, col);
        unionOther(row, col, row, col + 1);
    }

    private void unionOther(int row, int col, int nextRow, int nextCol) {
        if (outOfBound(nextRow) || outOfBound(nextCol)) return;
        int i = realIndex(row, col);
        int nextI = realIndex(nextRow, nextCol);
        if (sites[i] && sites[nextI]) {
            uf.union(i, nextI);
            fullUf.union(i, nextI);
        }
    }

    private boolean outOfBound(int no) {
        return no < 1 || no > N;
    }

    private void unionTop(int col) {
        int i = realIndex(1, col);
        uf.union(i, N * N);
        fullUf.union(i, N * N);
    }

    private void unionDown(int col) {
        int i = realIndex(N, col);
        uf.union(i, N * N + 1);
    }

    private int realIndex(int row, int col) {
        return (row - 1) * N + col - 1;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateRowCol(row, col);
        return sites[realIndex(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validateRowCol(row, col);
        int i = realIndex(row, col);
        if (!sites[i]) return false;
        else return fullUf.find(N * N) == fullUf.find(i);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return count;
    }

    // does the system percolate?
    public boolean percolates() {
        int M = N * N;
        return uf.find(M) == uf.find(M + 1);
//        return uf.connected(M, M + 1);
    }

    // test client (optional)
    public static void main(String[] args) {
        int N = StdIn.readInt();
        Percolation p = new Percolation(N);
        while (!StdIn.isEmpty()) {
            int row = StdIn.readInt() + 1;
            int col = StdIn.readInt() + 1;
            p.open(row, col);
        }
        StdOut.println("true:" + p.isFull(3, 1));
    }
}
