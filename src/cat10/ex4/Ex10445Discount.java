package cat10.ex4;

import cat10.P098Bag;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

// todo
public class Ex10445Discount {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        P098Bag<Integer> bag = new P098Bag<Integer>();
        for (int i = 0; true; i++) {
            int x = StdRandom.uniform(0, N);
            if (!bag.contains(x)) bag.add(x);
            if (bag.size() == N) {
                StdOut.println(i + 1);
                break;
            }
        }
    }
}
