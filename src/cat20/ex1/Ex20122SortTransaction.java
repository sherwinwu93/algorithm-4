package cat20.ex1;

import cat10.P095Queue;
import cat10.ex2.Ex10213Transaction;
import cat20.P163Shell;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Ex20122SortTransaction {
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

    public static void main(String[] args) {
        Ex10213Transaction[] transactions =  readTransactions(args[0]);
        P163Shell.sort(transactions);
        for (Ex10213Transaction t: transactions)
            StdOut.println(t);
    }
}
