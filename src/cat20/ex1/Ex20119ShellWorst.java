package cat20.ex1;

import cat20.P163Shell;
import lib.PrintUtils;

public class Ex20119ShellWorst {
    public static void main(String[] args) {
        int N = 100;
        Integer[] a = new Integer[N];
        int h = 40;
        int k = N / h;
        int prev = k;
        for (int i = 0; i < N; i++) {
            if (i % h == 0) a[i] = i / h;
            else a[i] = ++prev;
        }
        PrintUtils.printArray(a);
        P163Shell.sort(a);
    }
}
