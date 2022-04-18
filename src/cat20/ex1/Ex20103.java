package cat20.ex1;

import cat20.P156Selection;

public class Ex20103 {
    public static void main(String[] args) {
        // 倒序
        int N = Integer.parseInt(args[0]);
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++)
            a[i] = N - 1 - i;
        P156Selection.sort(a);
    }
}
