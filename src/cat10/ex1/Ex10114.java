package cat10.ex1;

import edu.princeton.cs.algs4.StdOut;

public class Ex10114 {
    public static void main(String[] args) {
        int y = lg(1024);
        StdOut.print(y);
        testFor();
    }

    public static int lg(int N) {
        int x = 0;
        for (int y = 1; y < N; x++) {
            y *= 2;
        }
        return x;
    }
    private static void testFor() {
        int i = 0;
        for (; i < 10; i++)
            StdOut.println();
        StdOut.println(i);
    }
}
