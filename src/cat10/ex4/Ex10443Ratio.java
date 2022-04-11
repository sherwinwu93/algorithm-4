package cat10.ex4;

import cat10.*;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex10443Ratio {
    public static void main(String[] args) {
        double prev = fasterScale(125);
        for (int N = 250; true; N += N) {
            double fasterScale = fasterScale(N);
            StdOut.printf("%7d %7.1f %5.1f\n", N, fasterScale, fasterScale/prev);
            prev = fasterScale;
        }
    }
    public static double fasterScale(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        P094Stack<Integer> linkedStack = new P094Stack<Integer>();
        P088ResizingArrayStack<Integer> resizingArrayStack = new P088ResizingArrayStack<Integer>();
        P110Stopwatch timer = new P110Stopwatch();
        for (int i = 0; i< N; i++)
            resizingArrayStack.push(a[i]);
        double time = timer.elapsedTime();
        P110Stopwatch fastTimer = new P110Stopwatch();
        for (int i = 0; i< N; i++)
            linkedStack.push(a[i]);
        double fastTime = fastTimer.elapsedTime();
        return time / fastTime;
    }
}
/**
 *     250     NaN   NaN
 *     500     NaN   NaN
 *    1000     NaN   NaN
 *    2000 Infinity   NaN
 *    4000 Infinity   NaN
 *    8000     1.0   0.0
 *   16000     2.0   2.0
 *   32000     2.0   1.0
 *   64000     1.5   0.8
 *  128000     0.6   0.4
 *  256000     0.6   0.9
 *  512000     0.7   1.2
 * 1024000     1.0   1.5
 * 2048000     0.6   0.6
 * 4096000     0.1   0.2
 * 8192000     1.5  13.3
 * 16384000     2.0   1.4
 * 32768000     0.6   0.3
 * 65536000     0.1   0.2
 * ---------
 * 创建对象的成本是普通的10倍
 * 基于链表 2N + 10*N
 * 基于数组 5N + lgN
 */
