package cat20.ex1;

import cat20.P163Shell;
import lib.PrintUtils;

public class Ex20119ShellWorst {
    // h有序数组的完全倒序且间隔为1
    public static void main(String[] args) {
        int N = 100;
        Integer[] a = new Integer[N];
        int h = 40;
        int item = N;
        for (int i = 0; i < h; i++)
            for (int j = i; j < N; j+=h)
                a[j] = --item;
        PrintUtils.printArray(a);
        P163Shell.sort(a);
    }
}
