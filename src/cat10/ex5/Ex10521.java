package cat10.ex5;

import edu.princeton.cs.algs4.StdOut;

public class Ex10521 {
    public static void main(String[] args) {
        // 整数对数量约为~1/2NlnN
        // count/prev趋近于2
        int prev = Ex10517ErdosRenyi.count(512);
        for (int N = 1024; true; N += N) {
            int count = Ex10517ErdosRenyi.count(N);
            StdOut.printf("%6d %6d %7.2f\n", N, count, (count * 1.0) / prev);
            prev = count;
        }
    }
}
