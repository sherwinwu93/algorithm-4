package cat20;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/6/15.
 * 多项归并问题: 将多个有序输入流归并成一个有序输入流打印出来
 * 如果空间足够,直接写入数组,排序,然后打印
 * 输入是无限的,使用优先队列,将它们全部读入并排序
 **/
public class P205Multiway {

    public static void main(String[] args) {
        int N = args.length;
        In[] streams = new In[N];
        for (int i = 0; i < N; i++)
            streams[i] = new In(args[i]);
        merge(streams);
    }
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
}
/**
 * java Multiway m1.txt m2.txt m3.txt
 * 有序打印出合并的流
 */
