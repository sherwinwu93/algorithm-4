import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/6/22.
 * Board: 整个棋盘(包括瓷片)
 * tile: 瓷片,0:不是瓷片
 **/
public class Board {
    private final int[][] tiles;
    private int blankRow;
    private int blankCol;

    // create a board from an n-by-n array of tiles.
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        int n = tiles.length;
        this.tiles = new int[n][n];
        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++) {
                this.tiles[row][col] = tiles[row][col];
                if (this.tiles[row][col] == 0) {
                    blankRow = row;
                    blankCol = col;
                }
            }
    }

    // string representation of this board
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int n = dimension();
        sb.append(n);
        sb.append("\n");
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                sb.append("\t");
                sb.append(tiles[col][row]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // board dimension n
    public int dimension() {
        return tiles.length;
    }

    // number of tiles out of place
    // 没有在指定位置的瓷片位置数量
    public int hamming() {
        int hamming = 0;
        int n = dimension();
        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                if (!isBlankTile(row, col) && tiles[row][col] != row * n + col + 1)
                    hamming++;
        return hamming;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int manhattan = 0;
        int n = dimension();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int tile = tiles[row][col];
                if (isBlankTile(row, col)) continue;
                int expectedRow = (tile - 1) / n;
                int expectedCol = (tile - 1) % n;
                manhattan += abs(row - expectedRow) + abs(col - expectedCol);
            }
        }
        return manhattan;
    }

    private boolean isBlankTile(int row, int col) {
        return tiles[row][col] == 0;
    }

    private int abs(int a) {
        if (a < 0) return -a;
        else return a;
    }

    // is this board the goal board?
    public boolean isGoal() {
        int n = dimension();
        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                if (!isBlankTile(row, col) && tiles[row][col] != row * n + col + 1)
                    return false;
        return true;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (!y.getClass().equals(Board.class)) return false;
        Board that = (Board) y;
        if (this.dimension() != that.dimension()) return false;
        int n = this.dimension();
        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                if (this.tiles[row][col] != that.tiles[row][col])
                    return false;
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        Stack<Board> s = new Stack<>();
        int n = dimension();
        // row - 1
        if (blankRow - 1 >= 0)
            s.push(new Board(movedTiles(blankRow - 1, blankCol)));
        if (blankRow + 1 < n)
            s.push(new Board(movedTiles(blankRow + 1, blankCol)));
        // col - 1
        if (blankCol - 1 >= 0)
            s.push(new Board(movedTiles(blankRow, blankCol - 1)));
        if (blankCol + 1 < n)
            s.push(new Board(movedTiles(blankRow, blankCol + 1)));
        return s;
    }

    private int[][] movedTiles(int movedRow, int movedCol) {
        return movedTiles(movedRow, movedCol, blankRow, blankCol);
    }

    private int[][] movedTiles(int movedRow, int movedCol, int otherRow, int otherCol) {
        int n = dimension();
        int[][] movedTiles = new int[n][n];
        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                movedTiles[row][col] = tiles[row][col];
        int t = movedTiles[movedRow][movedCol];
        movedTiles[movedRow][movedCol] = movedTiles[otherRow][otherCol];
        movedTiles[otherRow][otherCol] = t;
        return movedTiles;
    }


    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        int n = dimension();

        int row1 = -1;
        int col1 = -1;
        int row2 = -1;
        int col2 = -1;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (isBlankTile(i, j)) continue;
                if (row1 < 0) {
                    row1 = i;
                    col1 = j;
                    continue;
                }
                if (row1 >= 0 && row2 < 0) {
                    row2 = i;
                    col2 = j;
                    continue;
                }
                if (row2 >= 0) return new Board(movedTiles(row1, col1, row2, col2));
            }
        return null;
    }

    // unit testing (not graded)
    public static void main(String[] args) {
//        testToString();
//        testHamming();
//        testManhattan();
//        testIsGoal();
//        testEquals();
//        testNeighbors();
        testTwin();
    }
    private static void testTwin() {
        int[] a = {1, 0, 3, 4, 2, 5, 7, 8, 6};
        Board b = new Board(transferToTiles(a));
        StdOut.println(b.twin());
    }

    private static void testNeighbors() {
        int[] a = {1, 0, 3, 4, 2, 5, 7, 8, 6};
        Board b = new Board(transferToTiles(a));
        Iterable<Board> neighbors = b.neighbors();
        for (Board board : neighbors)
            StdOut.println(board);
    }

    private static void testEquals() {
        int[] a = {8, 1, 3, 4, 0, 2, 7, 6, 5};
        Board b = new Board(transferToTiles(a));
        Board b2 = new Board(transferToTiles(a));
        int[] a2 = {1, 2, 3, 4, 5, 6, 7, 8, 0};
        Board b3 = new Board(transferToTiles(a2));
        StdOut.println(b.equals(b2));
        StdOut.println(b.equals(b3));
    }

    private static void testIsGoal() {
        testIsGoalFalse();
        testIsGoalTrue();
    }

    private static void testIsGoalFalse() {
        int[] a = {8, 1, 3, 4, 0, 2, 7, 6, 5};
        int[][] tiles = transferToTiles(a);
        Board b = new Board(tiles);
        StdOut.println(b.isGoal());
    }

    private static void testIsGoalTrue() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 0};
        int[][] tiles = transferToTiles(a);
        Board b = new Board(tiles);
        StdOut.println(b.isGoal());
    }

    // expected 10
    private static void testManhattan() {
        int[] a = {8, 1, 3, 4, 0, 2, 7, 6, 5};
        int[][] tiles = transferToTiles(a);
        Board b = new Board(tiles);
        StdOut.println(b.manhattan());
    }

    // expected 5
    private static void testHamming() {
        int[] a = {8, 1, 3, 4, 0, 2, 7, 6, 5};
        int[][] tiles = transferToTiles(a);
        Board b = new Board(tiles);
        StdOut.println(b.hamming());
    }

    private static void testToString() {
        int n = 3;
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = 3 * i + j;
        Board board = new Board(a);
        StdOut.println(board.toString());
    }

    private static int[][] transferToTiles(int[] a) {
        int n = 3;
        int[][] tiles = new int[n][n];
        for (int row = 0, i = 0; row < n; row++)
            for (int col = 0; col < n; col++, i++)
                tiles[row][col] = a[i];
        return tiles;
    }
}
