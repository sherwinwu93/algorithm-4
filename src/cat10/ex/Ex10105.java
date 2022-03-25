package cat10.ex;

import edu.princeton.cs.algs4.StdOut;

import static lib.CompareUtils.between;

public class Ex10105 {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        StdOut.println(between(x, 0.0, 1.0) && between(y, .0, 1.0));
    }
}
