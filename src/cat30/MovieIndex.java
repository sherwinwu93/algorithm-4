package cat30;

import edu.princeton.cs.algs4.*;

/**
 * Created by Wusd on 2022/6/29.
 **/
public class MovieIndex {
    public static void main(String[] args) {
        ST<String, Bag<String>> st = new ST<>();

        In in = new In(args[0]);
        while (!in.isEmpty()) {
            String line = in.readLine();
            String[] tokens = line.split("/");
            String movie = tokens[0];
            for (int i = 1; i < tokens.length; i++) {
                String actor = tokens[i];
                if (!st.contains(actor)) st.put(actor, new Bag<>());
                if (!st.contains(movie)) st.put(movie, new Bag<>());
                st.get(actor).add(movie);
                st.get(movie).add(actor);
            }
        }

        StdOut.println("Done indexing files");
        StdOut.println();
        StdOut.println("Type the name of a performer or movie");
        while (!StdIn.isEmpty()) {
            String word = StdIn.readLine();
            if (!st.contains(word)) {
                StdOut.println("not found");
            } else {
                Bag<String> bag = st.get(word);
                for (String s : bag) {
                    StdOut.println(s);
                }
            }
            StdOut.println();
        }
    }
}
/**
 * %  java cat30.MovieIndex movies.txt
 * Done indexing files
 *
 * Type the name of a performer or movie
 * DiCaprio, Leonardo
 *  What's Eating Gilbert Grape (1993)
 *  Total Eclipse (1995)
 *  Titanic (1997)
 *  This Boy's Life (1993)
 *  Romeo + Juliet (1996)
 *  Quick and the Dead, The (1995)
 *  Poison Ivy (1992)
 *  Marvin's Room (1996)
 *  Man in the Iron Mask, The (1998 I)
 *  Gangs of New York (2002)
 *  Departed, The (2006)
 *  Celebrity (1998)
 *  Catch Me If You Can (2002)
 *  Beach, The (2000 I)
 *  Basketball Diaries, The (1995)
 *  Aviator, The (2004)
 */
