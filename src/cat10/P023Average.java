package cat10;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class P023Average {
    public static void main(String[] args) {
        double sum = 0.0;
        int cnt = 0;
        // 如果输入时Ctrl-D, StdIn.isEmpty(), 那么就结束循环
        while (!StdIn.isEmpty()) {
            sum += StdIn.readDouble();
            cnt++;
        }
        double avg = sum / cnt;
        StdOut.printf("Average is %.5f\n", avg);
    }
}
