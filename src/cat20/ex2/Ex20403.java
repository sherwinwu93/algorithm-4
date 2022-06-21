package cat20.ex2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/6/21.
 * 用以下数据结构实现优先队列,支持insert()和delMax()的操作: 无序数组,有序数组,无序链表和链表
 * 将4种实现worst-case time列成表格
 **/
public class Ex20403 {
    public static void main(String[] args) {
//        Ex20403UnorderedArrayMaxPQ<String> pq = new Ex20403UnorderedArrayMaxPQ<>(10000);
        Ex20403OrderedArrayMaxPQ<String> pq = new Ex20403OrderedArrayMaxPQ<>(10000);
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("*")) {
                StdOut.print(pq.delMax() + " ");
            } else pq.insert(s);
        }
    }
}
/**
 * java < Ex20301.txt
 * Unordered array Insert 1
 *                 delMax N
 *  Ordered array Insert N
 *                 delMax 1
 */
