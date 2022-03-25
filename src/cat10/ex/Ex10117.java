package cat10.ex;

public class Ex10117 {
    public static void main(String[] args) {
        // stackoverflow
        exR2(6);
    }
    public static String exR2(int n) {
        String s = exR2(n - 3) + n + exR2(n - 2) + n;
        if (n <= 0) return "";
        return s;
    }
}
