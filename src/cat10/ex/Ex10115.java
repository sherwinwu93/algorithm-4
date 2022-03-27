package cat10.ex;

import lib.PrintUtils;

public class Ex10115 {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 0, 0};
        PrintUtils.printArray(histogram(a, 3));
    }
    // 直方图
    // a的长度与a的元素和相等
    public static int[] histogram(int[] a, int M) {
        int[] histogram = new int[M];
        for (int i = 0; i < a.length; i++)
            histogram[a[i]]++;
        return histogram;
    }
}
