package cat30;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/6/23.
 **/
public class EqualsTest {
    public static void main(String[] args) {
//        testEqualsFalse();
        testEqualsTrue();
    }

    // a == b, x.equals(y) is false;
    private static void testEqualsFalse() {
        double a= 0.0;
        double b = -0.0;
        Double x = 0.0;
        Double y = -0.0;
        StdOut.println(a == b);
        StdOut.println(x.equals(y));
    }
    private static void testEqualsTrue() {
        double a= Double.NaN;
        double b = Double.NaN;
        Double x = Double.NaN;
        Double y = Double.NaN;
        StdOut.println(a == b);
        StdOut.println(x.equals(y));

    }
}
