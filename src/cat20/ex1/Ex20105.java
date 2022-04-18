package cat20.ex1;

import cat20.P157Insertion;

public class Ex20105 {
    // 正序
    // 插入排序内循环判断总是假
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]) ;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++)
            a[i] = i;
        P157Insertion.sort(a);
    }
}
