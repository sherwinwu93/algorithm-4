package cat10.ex;

import lib.PrintUtils;

public class Ex10113 {
    public static void main(String[] args) {
        int M = 5;
        int N = 6;
        String[][] a = new String[M][N];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                a[i][j] = " " + i + "," + j + " ";
        PrintUtils.print2DArray(a);
        String[][] b = new String[N][M];
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < b[i].length; j++)
                b[i][j] = a[j][i];
        PrintUtils.print2DArray(b);
    }
}
