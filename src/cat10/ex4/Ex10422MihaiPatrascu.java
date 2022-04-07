package cat10.ex4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import lib.PrintUtils;

import java.util.Arrays;

public class Ex10422MihaiPatrascu {
    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        int key = Integer.parseInt(args[1]);
        StdOut.println(rank(key, a));
    }

    public static int rank(int key, int[] a) {
        Arrays.sort(a);
        return rank(key, a, a.length - 1);
    }

    private static int rank(int key, int[] a, int max) {
        if (max < 0) return -1;
        int Fk1 = 0;
        int Fk = 1;
        while (Fk1 + Fk <= max) {
            Fk = Fk + Fk1;
            Fk1 = Fk - Fk1;
        }
        int i = max - Fk;
        int rank = rank(key, a, i, Fk, Fk1);
        if (rank != -1) return rank;
        else return rank(key, a, i - 1);
    }
    private static int rank(int key, int[] a, int i, int Fk, int Fk1) {
        if (Fk == 0) {
            if (a[i] == key) return i;
            else return -1;
        } else if (Fk1 == 0 && Fk == 1) {
            if (a[i] == key) return i;
            else if (a[i + 1] == key) return i+1;
            else return -1;
        } else {
            int Fk2 = Fk - Fk1;
            if (a[i + Fk2] > key) return rank(key, a, i, Fk2, Fk1 - Fk2);
            else if (a[i + Fk2] < key) return rank(key, a, i + Fk2, Fk1, Fk2);
            else return i + Fk2;
        }
    }

}
