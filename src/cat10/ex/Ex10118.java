package cat10.ex;

import edu.princeton.cs.algs4.StdOut;

public class Ex10118 {
    public static void main(String[] args) {
        // 50
        StdOut.println(mystery(2, 25));
        // 33
        StdOut.println(mystery(3, 11));
        // 2^25
        StdOut.println(mystery2(2, 25));
        // 3^11
        StdOut.println(mystery2(3, 11));
    }
    // 乘法,路径折半乘法
    public static int mystery(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }
    // 指数,路径折半指数
    public static int mystery2(int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 0) return mystery2(a * a, b / 2);
        return mystery2(a * a, b / 2) * a;
    }
}
