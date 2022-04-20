package cat20.ex1;

import edu.princeton.cs.algs4.StdRandom;
import lib.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class Ex20137PartiallySorted {
    public static void main(String[] args) {
        // 逆序数 N(N-1)/4
        // 95%有序
        // 所有元素与正确位置的距离不超过10
        // 5%的元素随机分布在整个数组中,剩下数据都是有序的
        int[] a = distance10Array();
        PrintUtils.printArray(a);
    }
    // 95%有序
    private static int[] percentArray() {
        int N = 100;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = i;
        int[] b = new int[5];
        for (int i = 0; i < 5; i++)
            b[i] = i;
        StdRandom.shuffle(b);
        for (int i = 0; i < 5;i++)
            a[i] = i;
        return a;
    }
    private static int[] distance10Array() {
        int N = 100;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = i;
        List<Integer> exchedList = new ArrayList<Integer>();
        List<Integer> randomList = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            if (exchedList.contains(i)) continue;
            randomList.clear();
            int low = i - 10 >= 0? i-10: 0;
            int hi = i + 10 < N? i+10: N -1;
            for (int j = low; j <=hi; j++)
                if (exchedList.contains(j)) continue;
                else randomList.add(j);
            int exch = randomList.get(StdRandom.uniform(0, randomList.size()));
            int temp = a[i];
            a[i] = a[exch];
            a[exch] = temp;
            exchedList.add(a[i]);
            exchedList.add(a[exch]);
        }
        return a;
    }
    private static int[] uniform() {
        int N = 100;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = i;
        List<Integer> randomList= new ArrayList<Integer>();
        while (randomList.size() != 5) {
            int random = StdRandom.uniform(0, N);
            if (!randomList.contains(random)) randomList.add(random);
        }
        int M = 5;
        int[] b = new int[M];
        int[] rb = new int[N];
        for (int i = 0; i < M; i++)
            rb[i] = b[i] = randomList.get(i);
        StdRandom.shuffle(rb);
        for (int i = 0; i < M; i++)
            a[b[i]] = rb[i];
        return a;
    }
}
