package cat20.ex1;

import cat10.P110Stopwatch;
import cat20.P156Selection;
import cat20.P157Insertion;
import cat20.P163Shell;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex20127Runtime {
    public static double time(String alg, Double[] a) {
        P110Stopwatch timer = new P110Stopwatch();
        if (alg.equals("selection")) P156Selection.sort(a);
        if (alg.equals("insertion")) P157Insertion.sort(a);
        if (alg.equals("shell")) P163Shell.sort(a);
        return timer.elapsedTime();
    }

    /**
     * 输入规模为N,重复T次
     */
    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }

    /**
     * % java SortCompare insertion selection 1000 100
     */
    public static void main(String[] args) {
        String alg = args[0];
        int T = Integer.parseInt(args[1]);
        double prev = timeRandomInput(alg, 64, T);
        for (int N = 128; true; N+= N) {
            double time = timeRandomInput(alg, N, T);
            StdOut.printf("%6d %7.1f %7.1f\n", N, time, time / prev);
            prev = time;
        }
    }
}
/**
 * java cat20.ex1.Ex20127ShellRuntime shell 50
 *    128     0.0     1.2
 *    256     0.0     0.5
 *    512     0.0     2.3
 *   1024     0.0     1.1
 *   2048     0.0     3.6
 *   4096     0.0     1.3
 *   8192     0.1     2.4
 *  16384     0.2     2.2
 *  32768     0.6     3.1
 *  65536     1.8     2.9
 * 131072     4.3     2.3
 * 262144    14.4     3.4
 * 次平方级别
 * ******************************
 *java cat20.ex1.Ex20127ShellRuntime insertion 50
 *    128     0.0     0.7
 *    256     0.0     1.6
 *    512     0.0     2.0
 *   1024     0.1     4.1
 *   2048     0.3     4.4
 *   4096     1.2     4.2
 *   8192     6.1     5.2
 *   平方级别
 *   ***********************************
 *java cat20.ex1.Ex20127ShellRuntime selection 50
 *   128     0.0     0.8
 *    256     0.0     5.2
 *    512     0.0     0.3
 *   1024     0.0     4.0
 *   2048     0.2     4.8
 *   4096     0.7     4.0
 *   8192     3.1     4.5
 * 平方级别
 */
