package cat10.ex3;

import cat10.P094Stack;
import edu.princeton.cs.algs4.StdOut;

public class Ex10345StackGenerative {
    // 是否会数组向下溢出. 访问比0小的数
    private static boolean overflowDown(String[] a) {
        P094Stack<String> stack = new P094Stack<String>();
        for (String s : a) {
            if (s.equals("-")) {
                if (stack.isEmpty()) return true;
                else stack.pop();
            } else stack.push(s);
        }
        return false;
    }

    private static boolean canBeGenerated(int[] a) {
        P094Stack<Integer> stack = new P094Stack<Integer>();
        int max = 0;
        for (int x : a) {
            if (x > max) {
                for (int i = max; i < x; i++)
                    stack.push(i);
                max = x + 1;
            } else if (x == max) {
                max = x + 1;
            } else{
                if (x == stack.peek()) stack.pop();
                else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String o1 = "0 1 2 - - -";
        String[] a1 = o1.split("\\s");
        String o2 = "0 1 2 - - - -";
        String[] a2 = o2.split("\\s");
        StdOut.println("false?:" + overflowDown(a1));
        StdOut.println("true?:" + overflowDown(a2));
        int[] b = {4, 6, 8, 7, 5, 3, 2, 9, 0, 1};
        int[] c = {2, 5, 6, 7, 4, 8, 9, 3, 1, 0};
        StdOut.println("false?:" + canBeGenerated(b));
        StdOut.println("true?:" + canBeGenerated(c));
    }
}
