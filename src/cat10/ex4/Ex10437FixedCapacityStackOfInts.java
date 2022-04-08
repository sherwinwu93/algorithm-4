package cat10.ex4;

import cat10.P082FixedCapacityStack;
import cat10.P110Stopwatch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex10437FixedCapacityStackOfInts {

    // 自动装箱大概是直接比直接用基本类型多了几十倍的代价
    // 创建对象的消耗,大概是基本操作的几十倍
    public static void main(String[] args) {
        double prev = timeTrialInts(125);
        for (int N = 250; true; N += N) {
            double time = timeTrialInts(N);
            StdOut.printf("%6d %7.1f %5.1f\n", N, time, time / prev);
            prev = time;
        }
    }

    public static double timeTrialInts(int N) {
        int MAX = 100000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        Ex10437FixedCapacityStackOfInts stackOfInts = new Ex10437FixedCapacityStackOfInts(N);
        P110Stopwatch timer = new P110Stopwatch();
        for (int i = 0; i < N; i++)
            stackOfInts.push(i);
        for (int i = 0; i < N; i++)
            stackOfInts.pop();
        double intTime =  timer.elapsedTime();
        P082FixedCapacityStack<Integer> stackIntegers = new P082FixedCapacityStack<Integer>(N);
        P110Stopwatch timer2 = new P110Stopwatch();
        for (int i = 0; i < N; i++)
            stackIntegers.push(i);
        for (int i = 0; i < N; i++)
            stackIntegers.pop();
        double integerTime = timer2.elapsedTime();
        return integerTime / intTime;
    }

    public static double timeTrialIntegers(int N) {
        int MAX = 100000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        P082FixedCapacityStack<Integer> stackIntegers = new P082FixedCapacityStack<Integer>(N);
        P110Stopwatch timer = new P110Stopwatch();
        for (int i = 0; i < N; i++)
            stackIntegers.push(i);
        for (int i = 0; i < N; i++)
            stackIntegers.pop();
        return timer.elapsedTime();
    }

    private int[] a;//stack entries
    private int N; //size

    public Ex10437FixedCapacityStackOfInts(int capacity) {
        a = new int[capacity];
    }

    public void push(int item) {
        a[N++] = item;
    }

    public int pop() {
        return a[--N];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }
}
