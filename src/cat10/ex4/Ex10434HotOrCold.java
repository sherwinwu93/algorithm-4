package cat10.ex4;

import edu.princeton.cs.algs4.BinarySearch;

public class Ex10434HotOrCold {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = i + 1;
        BinarySearch.indexOf(a, 1);
    }
}
