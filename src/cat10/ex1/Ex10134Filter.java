package cat10.ex1;

import edu.princeton.cs.algs4.StdOut;
import lib.PrintUtils;

import java.util.Arrays;

public class Ex10134Filter {
    public static void main(String[] args) {

    }
    public static void  printMoreAverageRate(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        double average = 1. * sum / a.length;
        Arrays.sort(a);
        int k = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] > average) {
                k = i;
                break;
            }
        StdOut.println((a.length - k) / a.length);
    }
    public static void printAverage(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        StdOut.println(sum / a.length);
    }
    public static void printSumOfSquare(int[] a) {
        int sumOfSquare = 0;
        for (int i = 0; i < a.length; i++) {
            sumOfSquare += a[i] * a[i];
        }
        StdOut.println(sumOfSquare);
    }
    public static void printLessK(int[] a, int k)  {
        Arrays.sort(a);
        StdOut.println(a[k - 1]);
    }
    public static void printMid(int[] a) {
        Arrays.sort(a);
        int mid = a.length - 1 / 2;
        StdOut.println(a[mid]);
    }
    public static void printMin$Max(int[] a) {
        int[] filteredArray = new int[2];
        filteredArray[0] = a[0];
        filteredArray[1] = a[1];
        for (int i = 0; i < a.length; i++) {
            if (filteredArray[0] > a[i])
                filteredArray[0] = a[i];
            if (filteredArray[1] < a[i])
                filteredArray[1] = a[i];
        }
        PrintUtils.printArray(filteredArray);
    }
}
