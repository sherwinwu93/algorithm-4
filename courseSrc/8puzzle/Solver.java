import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/6/22.
 **/
public class Solver {
    private class GameNode implements Comparable<GameNode> {
        Board board;
        int moves;
        int priority;
        GameNode previousNode;

        public GameNode(Board board, GameNode previousNode) {
            this.board = board;
            this.moves = previousNode == null ? 0 : previousNode.moves + 1;
            this.previousNode = previousNode;
            priority = this.board.manhattan() + this.moves;
        }

        @Override
        public int compareTo(GameNode that) {
            if (priority < that.priority) return -1;
            else if (priority > that.priority) return 1;
            else return 0;
        }
    }
    private GameNode node;
    private GameNode twin;
    private boolean solvable;
    // find a solution to the initial board (using the A* algos)
    // 全局性的，可以现在构造里面算好
    public Solver(Board initial) {
        // if initial is null, thr
        if (initial == null) throw new IllegalArgumentException();
        node = new GameNode(initial, null);
        MinPQ<GameNode> pq = new MinPQ<>();
        pq.insert(node);

        twin = new GameNode(initial.twin(), null);
        MinPQ<GameNode> twinPQ = new MinPQ<>();
        twinPQ.insert(twin);
        while (!node.board.isGoal() && !twin.board.isGoal()) {
            node = pq.delMin();
            for (Board neighbor : node.board.neighbors()) {
                if (node.previousNode != null && neighbor.equals(node.previousNode.board)) continue;
                pq.insert(new GameNode(neighbor, node));
            }

            twin = twinPQ.delMin();
            for (Board neighbor : twin.board.neighbors()) {
                if (twin.previousNode != null && neighbor.equals(twin.previousNode.board)) continue;
                twinPQ.insert(new GameNode(neighbor, twin));
            }
        }
        if (node.board.isGoal()) solvable = true;

    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return solvable;
    }

    // min number of moves to solve initial board: -1 if unsolvable
    public int moves() {
        // -1 if unsolvable
        if (!solvable) return -1;
        else return node.moves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!solvable) return null;
        Stack<Board> s = new Stack<>();
        GameNode temp = node;
        while (temp.previousNode != null) {
            s.push(temp.board);
            temp = temp.previousNode;
        }
        return s;
    }

    public static void main(String[] args) {

        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
