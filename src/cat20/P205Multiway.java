package cat20;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/6/15.
 **/
public class P205Multiway {
    // 这种merge方法,流可以是无限的
    public static void merge(In[] streams) {
        int N = streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ<>(N);

        for (int i = 0; i < N; i++)
            if (!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());

        while (!pq.isEmpty()) {
            StdOut.println(pq.minKey());
            int i = pq.delMin();

            if (!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());
        }
    }

    public static void main(String[] args) {
        int N = args.length;
        In[] streams = new In[N];
        for (int i = 0; i < N; i++)
            streams[i] = new In(args[i]);
        merge(streams);
    }
}
/**
 * java Multiway m1.txt m2.txt m3.txt
 */
