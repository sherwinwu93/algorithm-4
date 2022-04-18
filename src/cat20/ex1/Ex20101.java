package cat20.ex1;

import cat20.P156Selection;

public class Ex20101 {
    // 选择排序EASYQUESTION排序轨迹
    public static void main(String[] args) {
        String s = "E A S Y Q U E S T I O N";
        String[] a = s.split(" ");
        P156Selection.sort(a);
        P156Selection.show(a);
    }
}
