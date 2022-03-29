package cat10.ex1;

import edu.princeton.cs.algs4.StdOut;

public class Ex10106 {
    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }
}
/**
 * 打印出斐波那契序列 16项
 **/