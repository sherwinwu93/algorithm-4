package cat10.ex3;

import cat10.P095Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex10315QueueUseCase {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        P095Queue<String> queue = new P095Queue<String>();
        while (!StdIn.isEmpty())
            queue.enqueue(StdIn.readString());
        for (int i = 1; i <= k; i++)
            if (i == k) StdOut.println(queue.dequeue());
            else queue.dequeue();
    }
}
