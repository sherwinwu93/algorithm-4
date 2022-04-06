package cat10.ex4;

import edu.princeton.cs.algs4.StdOut;

public class Ex10412 {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6, 9, 10};
        int[] b = {2, 3, 4, 5, 7, 9};
        int N = a.length;
        for (int i = 0, j = 0; i < N && j < N; ) {
            if (a[i] == b[j]){
                StdOut.println(a[i]);
                i++;
                j++;
            } else if (a[i] > b[j]) j++;
            else i++;
        }
    }
}
