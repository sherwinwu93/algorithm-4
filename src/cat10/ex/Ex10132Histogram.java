package cat10.ex;

import edu.princeton.cs.algs4.StdIn;
import lib.PrintUtils;

public class Ex10132Histogram {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double l = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);
        double delta = (r - l) / N;
        int[] nums = new int[N];
        while (!StdIn.isEmpty()) {
            double value = StdIn.readDouble();
            int k = (int) ((value - l) / delta);
            if (k > N - 1) nums[k]++;
        }
    }

}
