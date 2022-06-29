package cat30;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/6/29.
 * 查找出前后的词
 *
 **/
public class Concordance {
    public static void main(String[] args) {
        int CONTEXT = 5;

        In in = new In(args[0]);
        String[] words = in.readAllStrings();
        ST<String, SET<Integer>> st = new ST<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!st.contains(word)) st.put(word, new SET<>());
            st.get(word).add(i);
        }
        StdOut.println("build concordance done");

        while (!StdIn.isEmpty()) {
            String word = StdIn.readLine();
            SET<Integer> indexs = st.get(word);
            if (indexs == null) indexs = new SET<>();
            for (int k : indexs) {
                for (int i = k - CONTEXT + 1; i < k; i++) {
                    StdOut.print(words[i] + " ");
                }
                StdOut.print("*" + word + "* ");
                for (int i = k + 1; i < k + CONTEXT; i++) {
                    StdOut.print(words[i] + " ");
                }
                StdOut.println();
            }
            StdOut.println();
        }
    }
}
/***
 * %  java cat30.Concordance tale.txt
 * build concordance done
 * cities
 * tongues of the two *cities* that were blended in
 *
 * princeton
 *
 * majesty
 * their turnkeys and the *majesty* of the law fired
 * me treason against the *majesty* of the people in
 * of his most gracious *majesty* king george the third
 *
 */
