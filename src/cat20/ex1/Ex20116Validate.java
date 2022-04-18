package cat20.ex1;

import java.util.Arrays;

public class Ex20116Validate {
    static public boolean check(Comparable[] a) {
        int N = a.length;
        Comparable[] b = new Comparable[N];
        for (int i = 0; i < N; i++)
            b[i] = a[i];
        Arrays.sort(b);
        for (int i = 0; i < N; i++)
            if (!a[i].equals(b[i])) return false;
        return true;
    }
}
