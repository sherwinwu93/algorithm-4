package cat10.ex4;

public class Ex10414FourSum {
    public static int count(int[] a) {
        int cnt = 0;
        int N = a.length;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                for (int k = j + 1; k < N; k++)
                    for (int g = k + 1; g < N; g++)
                        if (a[i] + a[j] + a[k] + a[g] == 0)
                            cnt++;
        return cnt;
    }
    public static void main(String[] args) {

    }
}
