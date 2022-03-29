package cat10.ex2;

import edu.princeton.cs.algs4.In;
import lib.PrintUtils;

public class Ex10215In {
    public static void main(String[] args) {
        int[] a = Ex10215In.readInts(args[0]);
        PrintUtils.printArray(a);
    }
    public static int[] readInts(String name) {
        In in = new In(name);
        String all = in.readAll();
        String[] strings = all.split("\\s+");
        int N = strings.length - 1;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = Integer.parseInt(strings[i]);
        return a;
    }
}
