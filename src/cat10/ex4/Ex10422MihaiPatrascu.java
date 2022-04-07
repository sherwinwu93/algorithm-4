package cat10.ex4;

public class Ex10422MihaiPatrascu {
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }
    public static int rank(int key,int[] a, int min, int max) {
        if (min > max) return -1;
        else {
            int fib1 = 0;
            int fib2 = 1;
            while (max > fib2) {
                fib2 = fib2 + fib1;
                fib1 = fib2 - fib1;
            }
            int rank = rank(key, a, max - fib1, fib1, fib2 - fib1);
            if (rank == -1) return rank(key, a, 0, min - 1);
            else return rank;
        }
    }
    public static int rank(int key, int[] a, int i, int fib2, int fib1) {
        int fib0 = fib2 - fib1;
        if (a[i + fib0] == key) return i + fib0;
        else if (a[i + fib0] > 0) return rank(key, a, i, fib0, fib1 - fib0);
        else return rank(key, a, i, fib0 - 1);
    }
}
