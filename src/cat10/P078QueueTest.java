package cat10;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import lib.PrintUtils;

public class P078QueueTest {
    public static void main(String[] args) {
        int[] a = readInts(args[0]);
        PrintUtils.printArray(a);
    }
    public static int[] readInts(String name) {
        In in = new In(name);
        Queue<Integer> q = new Queue<Integer>();
        while (!in.isEmpty())
            q.enqueue(in.readInt());
        int N = q.size();
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = q.dequeue();
        return a;
    }
}
