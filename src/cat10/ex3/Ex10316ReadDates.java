package cat10.ex3;

import cat10.P056Date;
import cat10.P095Queue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Ex10316ReadDates {
    public static void main(String[] args) {
        P056Date[] dates = readDates(args[0]);
        for (P056Date date : dates)
            StdOut.println(date);
    }
    public static P056Date[] readDates(String name) {
        In in = new In(name);
        P095Queue<P056Date> q = new P095Queue<P056Date>();
        while (!in.isEmpty()) {
            String dateString = in.readString();
            q.enqueue(P056Date.parseDate(dateString));
        }
        P056Date[] dates = new P056Date[q.size()];
        for (int i = 0; i < dates.length; i++)
            dates[i] = q.dequeue();
        return dates;
    }

}
