package cat10.ex3;

import cat10.P095Queue;
import edu.princeton.cs.algs4.StdOut;

public class Ex10337Josephus {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        P095Queue<Integer> q = new P095Queue<Integer>();
        for (int i = 0; i < N; i++)
            q.enqueue(i);
        int slogan = 1;
        while (!q.isEmpty()) {
            if (slogan++ == M) {
                StdOut.print(q.dequeue() + " ");
                slogan = 1;
            } else q.enqueue(q.dequeue());
        }
    }
}
