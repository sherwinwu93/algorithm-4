import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * created by wusd
 */
public class RandomWord {
    public static void main(String[] args) {
        String champion = StdIn.readString();
        for (int i = 2; !StdIn.isEmpty(); i++) {
            String x = StdIn.readString();
            if (StdRandom.bernoulli(1.0 / i))
                champion = x;
        }
        StdOut.println(champion);
    }
}
