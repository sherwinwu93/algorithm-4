package cat10.ex4;

import cat10.P098Bag;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

// todo
public class Ex10444Birthday {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        P098Bag<Integer> bag = new P098Bag<Integer>();
        boolean containSame = false;
        while (true) {
            int x = StdRandom.uniform(0, N);
            for (int item : bag)
                if (item == x) {
                    StdOut.println(bag.size());
                    containSame = true;
                }
            bag.add(x);
            if (containSame) break;
        }
    }
}
