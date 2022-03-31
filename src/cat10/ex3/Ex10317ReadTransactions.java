package cat10.ex3;

import cat10.P095Queue;
import cat10.ex2.Ex10213Transaction;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Ex10317ReadTransactions {
    public static void main(String[] args) {
        Ex10213Transaction[] transactions = readTransactions(args[0]);
        for (Ex10213Transaction transaction : transactions)
            StdOut.println(transaction);
    }
    public static Ex10213Transaction[] readTransactions(String name) {
        In in = new In(name);
        P095Queue<Ex10213Transaction> q = new P095Queue<Ex10213Transaction>();
        while (!in.isEmpty()) {
            String transactionString = in.readLine();
            q.enqueue(Ex10213Transaction.parseTransaction(transactionString));
        }
        int N = q.size();
        Ex10213Transaction[] transactions = new Ex10213Transaction[N];
        for (int i = 0; i < N; i++)
            transactions[i] = q.dequeue();
        return transactions;
    }

}
