package cat10.ex2;

public class Ex10218Accumulator {
    private double m;
    private double s;
    private int N;

    public void addDataValue(double x) {
        N++;
        s = s + 1. * (N - 1) / N * (x - m) * (x - m);
        m = m + (x - m) / N;
    }

    // 平均值
    public double mean() {
        return m;
    }

    // 平方差
    public double var() {
        return s / (N - 1);
    }

    // 标准差
    public double stddev() {
        return Math.sqrt(this.var());
    }
}
