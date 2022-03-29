package cat10.ex1;

public class Ex10112 {
    public static void main(String[] args) {
        // 9876543210
        // true->0123443210
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;
        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];
        for (int i = 0; i < 10; i++)
            System.out.println(a[i]);
    }
}
