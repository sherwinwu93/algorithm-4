package cat10.ex1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex10111 {
    public static void main(String[] args) {
        boolean[][] x = new boolean[10][10];
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < x[i].length; j++)
                x[i][j] = StdRandom.bernoulli();
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                StdOut.print(i + "-" + j);
                StdOut.print(x[i][j] ? '*' : ' ');
            }
            StdOut.println();
        }
    }
}
