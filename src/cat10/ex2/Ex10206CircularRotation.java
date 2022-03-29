package cat10.ex2;

import edu.princeton.cs.algs4.StdOut;

public class Ex10206CircularRotation {
    // eg. ACTGACG TGACGAC
    public static void main(String[] args) {
        StdOut.println(isCircularRotation("ABCDE", "EABCD"));
        StdOut.println(isCircularRotation("ABCDE", "EACCD"));
    }

    public static boolean isCircularRotation(String s, String t) {
        return s.length() == t.length() && (s + s).indexOf(t) != -1;
    }
}