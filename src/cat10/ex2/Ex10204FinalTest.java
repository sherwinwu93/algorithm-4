package cat10.ex2;

import edu.princeton.cs.algs4.StdOut;

public class Ex10204FinalTest {
    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        // 指向内容,而不是指向指针
        // world
        StdOut.println(string1);
        // hello
        StdOut.println(string2);
    }
}
