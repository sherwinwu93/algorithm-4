package cat30;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/6/29.
 * 去除重复的键
 **/
public class DeDup {
    private DeDup() {}

    public static void main(String[] args) {
        SET<String> set = new SET<>();

        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (!set.contains(key)) {
                set.add(key);
                StdOut.println(key);
            }
        }
    }
}
/**
 * % java cat30.DeDup < tinyTale.txt
 * it
 * was
 * the
 * best
 * of
 * times
 * worst
 * age
 * wisdom
 * foolishness
 * epoch
 * belief
 * incredulity
 * season
 * light
 * darkness
 * spring
 * hope
 * winter
 * despair
 */
