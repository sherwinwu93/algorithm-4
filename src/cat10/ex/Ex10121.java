package cat10.ex;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex10121 {
    // 姓名 得分 总分 得分率
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int score = StdIn.readInt();
            int total = StdIn.readInt();
            double rate = 1.0 * score / total;
            StdOut.printf("%s\t%d\t%d\t%.3f\n", name, score, total, rate);
        }
    }
}
