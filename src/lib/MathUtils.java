package lib;

public class MathUtils {
    public static boolean threeSum(int x, int y, int z) {
        int xy = x + y;
        if (x > 0 && y > 0 && xy < 0) return false;
        else if (x < 0 && y < 0 && xy > 0) return false;
        else return xy == -z;
    }
    public static int abs(int x) {
        if (x < 0) return -x;
        else return x;
    }

    public static double abs(double x) {
        if (x < 0) return -x;
        else return x;
    }

    public static boolean isPrime(int N) {
        if (N < 2) return false;
        for (int i = 2; i * i <= N; i = i + 2)
            if (N % i == 0) return false;
        return true;
    }

    public static double sqrt(double c) {
        if (c < 0) return Double.NaN;
        // 科学计数法
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c/ t) > err * t)
            t = (c / t + t) / 2.0;
        return t;
    }

    public static double hypotenuse(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }

    public static double H(int N) {
        double sum = 0.0;
        for (int i = 1; i <= N; i++)
            sum += 1.0 / i;
        return sum;
    }
    public static double log2(double x) {
        return Math.log(x) / Math.log(2);
    }
}
