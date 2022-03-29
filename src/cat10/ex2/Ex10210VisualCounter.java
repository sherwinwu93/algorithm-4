package cat10.ex2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class Ex10210VisualCounter {
    private final int maxTimes;
    private final int maxCount;
    private int count;
    private int times;
    private final String name;

    public Ex10210VisualCounter(String id, int N, int max) {
        maxTimes = N;
        maxCount = max;
        name = id;
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        StdDraw.setPenRadius(.005);
    }

    public void increment() {
        validateTimes();
        if (count == maxCount) throw new RuntimeException("maxCount:" + maxCount);
        count++;
        times++;
        draw();
    }

    public void decrement() {
        validateTimes();
        if (count == -maxCount) throw new RuntimeException("maxCount:" + maxCount);
        count--;
        times++;
        draw();
    }

    private void draw() {
        StdDraw.clear();
        StdDraw.text(.5, .5, this.toString());
    }

    private void validateTimes() {
        if (times == maxTimes) throw new RuntimeException("maxTimes:" + maxTimes);
    }

    public int tally() {
        return count;
    }

    public String toString() {
        return name + " " + count;
    }

    public static void main(String[] args) {
        Ex10210VisualCounter counter = new Ex10210VisualCounter("ex10210", 10, 10);
        while (!StdIn.isEmpty()) {
            if (StdIn.readBoolean()) counter.increment();
            else counter.decrement();
        }
    }
}
