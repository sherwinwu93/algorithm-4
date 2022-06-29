package cat30;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/6/29.
 **/
public class AllowFilter {
    public static void main(String[] args) {
        SET<String> set = new SET<>();
        In in = new In(args[0]);
        while (!in.isEmpty()) {
            set.add(in.readString());
        }

        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (set.contains(key)) StdOut.println(key);
        }
    }
}
/**
 * % java cat30.AllowFilter list.txt < tinyTale.txt
 * it
 * was
 * the
 * of
 * it
 * was
 * the
 * of
 * it
 * was
 * the
 * of
 * it
 * was
 * the
 * of
 * it
 * was
 * the
 * of
 * it
 * was
 * the
 * of
 * it
 * was
 * the
 * of
 * it
 * was
 * the
 * of
 * it
 * was
 * the
 * of
 * it
 * was
 * the
 * of
 */
