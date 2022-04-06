package cat10;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class P061StaticSETofInts {
    private int[] a;
    public P061StaticSETofInts(int[] keys) {
        // 保护性复制是能用二分查找,且不影响keys
        a = new int[keys.length];
        for (int i = 0; i< keys.length; i++)
            a[i] = keys[i];//保护性复制
        Arrays.sort(a);
    }
    public boolean contains(int key) {
        return minRank(key) != -1;
    }
    private int minRank(int key) {
        int lo = 0;
        int hi = a.length -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key<a[mid]) hi = mid -1;
            else if (key > a[mid]) lo = mid + 1;
            else {
                if (mid == 0) return 0;
                else if (key == a[mid - 1]) hi = mid - 1;
                else return mid;
            }
        }
        return -1;
    }
    private int maxRank(int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else {
                if (mid == a.length - 1) return mid;
                else if (key == a[mid + 1]) lo = mid + 1;
                else return mid;
            }
        }
        return -1;
    }
    public int howMany(int key) {
        int minRank = minRank(key);
        if (minRank == -1) return 0;
        int maxRank = maxRank(key);
        return maxRank - minRank + 1;
    }

    public static void main(String[] args) {
        int[] a =In.readInts(args[0]);
        P061StaticSETofInts s = new P061StaticSETofInts(a);
        int cnt = s.howMany(Integer.parseInt(args[1]));
        StdOut.println(cnt);
    }
}
