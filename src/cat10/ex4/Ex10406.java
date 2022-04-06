package cat10.ex4;

public class Ex10406 {
    // 给出增长数量级

    // O(N)
    public static void a(int N) {
        int sum = 0;
        for (int n = N; n > 0; n /= 2)
            for (int i = 0; i < n; i++)
                sum++;
    }
    // O(N)
    public static void b(int N) {
        int sum = 0;
        for (int i = 1; i < N; i *= 2)
            for (int j = 0; j < i; j++)
                sum++;
    }
    // O(NlogN)
    public static void c(int N) {
        int sum = 0;
        for (int i = 1; i < N; i *= 2)
            for (int j = 0; j < N; j++)
                sum++;
    }
}
