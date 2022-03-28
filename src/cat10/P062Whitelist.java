package cat10;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class P062Whitelist {
    public static void main(String[] args) {
        int[] w = In.readInts(args[0]);
        P061StaticSETofInts set = new P061StaticSETofInts(w);
        while (!StdIn.isEmpty()) {
            int key =StdIn.readInt();
            if (!set.contains(key))
                StdOut.println(key);
        }
    }
}
