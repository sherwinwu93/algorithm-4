package cat10;

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
        return rank(key) != -1;
    }
    private int rank(int key) {
        int lo = 0;
        int hi = a.length -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key<a[mid]) hi = mid -1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
