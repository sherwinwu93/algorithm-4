package cat10.ex;

public class Ex10126Sort {
    public static void main(String[] args) {
    }
    public static void sort(int a, int b, int c) {
        // a>b, 则a,b互换
        // a>c, 则a,c互换. 那么a<b`c小
        // b>c,则b, c互换,那么b<c
        // 所以a< b <c
        int t;
        if (a > b) {
            t = a;
            a = b;
            b = t;
        }
        if (a > c) {
            t = a;
            a = c;
            c = t;
        }
        if (b > c) {
            t = b;
            b = c;
            c = t;
        }
    }
}
