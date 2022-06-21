package cat20;

import edu.princeton.cs.algs4.*;

/**
 * Created by Wusd on 2022/6/21.
 * 找出前M名
 * 这里的解决方案关键是,输入可以是无限的
 **/
public class P196TopM {

    public static void main(String[] args) {
        // 获取
        int M = Integer.parseInt(args[0]);
        MinPQ<Transaction> pq = new MinPQ<>(M + 1);
        while (!StdIn.isEmpty()) {
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size() > M)
                pq.delMin();
        }
        Stack<Transaction> stack = new Stack<>();
        while (!pq.isEmpty()) stack.push(pq.delMin());
        for (Transaction t : stack) StdOut.println(t);
    }
}
/**
 * % java TopM 5 < tinyBatch.txt
 */
