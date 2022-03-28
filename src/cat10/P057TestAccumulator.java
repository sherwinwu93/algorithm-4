package cat10;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class P057TestAccumulator {
    // ? 1000
    // ? 1000000
    // ? 1000000
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        P058Accumulator a = new P058Accumulator();
        for (int t = 0; t < T; t++)
            a.addDataValue(StdRandom.uniform());
        StdOut.println(a);
    }
}
