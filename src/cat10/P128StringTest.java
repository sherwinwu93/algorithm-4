package cat10;

import edu.princeton.cs.algs4.StdOut;

public class P128StringTest {
    public static void main(String[] args) {
        String s = "abcdef";
        String subS = s.substring(0, 2);
        String anotherS = "abcdef";
        StdOut.println(s == subS);
        StdOut.println(s == anotherS);
        s = "abcdef";
        StdOut.println(s == anotherS);
    }
}
