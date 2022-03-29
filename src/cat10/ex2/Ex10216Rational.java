package cat10.ex2;

import cat10.P001Gcd;
import edu.princeton.cs.algs4.StdOut;

public class Ex10216Rational {
    private final long numer;
    private final long denom;

    public Ex10216Rational(int numerator, int denominator) {
        int g = P001Gcd.gcd(numerator, denominator);
        numer = numerator / g;
        denom = denominator / g;
    }

    public Ex10216Rational plus(Ex10216Rational b) {
        long n = numer * b.denom + b.numer * denom;
        assert n <= Integer.MAX_VALUE && n >= Integer.MIN_VALUE;
        long d = denom * b.denom;
        assert d <= Integer.MAX_VALUE && d >= Integer.MIN_VALUE;
        return new Ex10216Rational((int) n, (int) d);
    }

    public Ex10216Rational minus(Ex10216Rational b) {
        return new Ex10216Rational((int) (numer * b.denom - b.numer * denom),
                (int) (denom * b.denom));
    }

    public Ex10216Rational times(Ex10216Rational b) {
        return new Ex10216Rational((int) (numer * b.numer),
                (int) (denom * b.denom));
    }

    public Ex10216Rational divides(Ex10216Rational b) {
        return new Ex10216Rational((int) (numer * b.denom),
                (int) (denom * b.numer));
    }

    public boolean equals(Ex10216Rational that) {
        if (this == that) return true;
        if (that == null) return false;
        if (numer == that.numer && denom == that.denom) return true;
        return false;
    }

    public String toString() {
        return numer + "/" + denom;
    }

    public static void main(String[] args) {
        Ex10216Rational oneDivideTwo = new Ex10216Rational(1, Integer.MAX_VALUE);
        Ex10216Rational oneDivideThree = new Ex10216Rational(1, 3);
        StdOut.println(oneDivideTwo.plus(oneDivideThree));
        StdOut.println(oneDivideTwo.minus(oneDivideThree));
        StdOut.println(oneDivideTwo.times(oneDivideThree));
        StdOut.println(oneDivideTwo.divides(oneDivideThree));
    }
}
