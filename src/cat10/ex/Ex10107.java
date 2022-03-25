package cat10.ex;

import edu.princeton.cs.algs4.StdOut;

public class Ex10107 {
    public static void main(String[] args) {
        // 3.0009
        // 纠正: 3.00009
        a();
        // 499500
        b();
        // 1023
        // 纠正: 10000
        c();
    }
    private static void c() {
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < 1000; j++)
                sum++;
        StdOut.println(sum);
    }
    private static void b() {
        int sum = 0;
        for(int i = 1; i < 1000; i++)
            for(int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);
    }
    private static void a() {
        double t = 9.0;
        while(Math.abs(t - 9.0/ t) > .001)
            t = (9.0/t + t)/ 2.0;
        StdOut.printf("%.5f\n", t);
    }
}
