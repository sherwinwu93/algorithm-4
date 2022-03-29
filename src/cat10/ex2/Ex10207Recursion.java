package cat10.ex2;

import edu.princeton.cs.algs4.StdOut;

public class Ex10207Recursion {
    public static void main(String[] args) {
        // 返回自身
        StdOut.println(mystery("abcef"));
    }

    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return mystery(a) + mystery(b);
    }
}
