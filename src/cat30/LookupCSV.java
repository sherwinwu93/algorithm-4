package cat30;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/6/29.
 * 在CSV中查找信息
 * 这个程序的优点就在于,key和value可以指定
 **/
public class LookupCSV {
    public static void main(String[] args) {
        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);

        ST<String, String> st = new ST<>();

        In in = new In(args[0]);
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] tokens = line.split(",");
            String key = tokens[keyField];
            String val = tokens[valField];
            st.put(key, val);
        }

        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (st.contains(key)) StdOut.println(st.get(key));
            else StdOut.println("Not found");
        }
    }
}
/**
 * % java LookupCSV ip.csv 0 1
 * www.google.com
 * 216.239.41.99
 *
 * % java LookupCSV ip.csv 1 0
 * 216.239.41.99
 * www.google.com
 */
