package lib;

import edu.princeton.cs.algs4.StdOut;

public class PrintUtils {
    public static void print2DArray(String[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                StdOut.print(a[i][j]);
            StdOut.println();
        }
    }
    public static void print2DArray(boolean[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                StdOut.print(a[i][j]);
            StdOut.println();
        }
    }
    public static void print2DArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                StdOut.print(a[i][j] + " ");
            StdOut.println();
        }
    }
    public static void printArray(int[] a){
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
    public static void printArray(String[] a){
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
    public static void printArray(double[] a){
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
}
