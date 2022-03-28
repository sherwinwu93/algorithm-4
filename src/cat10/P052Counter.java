package cat10;

import edu.princeton.cs.algs4.StdOut;

public class P052Counter {
    private final String name;
    private int count;
    public P052Counter(String id) {
        name = id;
    }
    public void increment() {
        count++;
    }
    public int tally() {
        return count;
    }
    public String toString() {
        return count + " " + name;
    }

    public static void main(String[] args) {
        P052Counter heads = new P052Counter("heads");
        P052Counter tails = new P052Counter("tails");

        heads.increment();
        heads.increment();
        tails.increment();

        StdOut.println(heads + " " + tails);
        StdOut.println(heads.tally() + tails.tally());
    }
}
