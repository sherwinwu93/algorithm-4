package cat20.ex2;

/**
 * Created by Wusd on 2022/5/31.
 **/
// 切分轨迹
public class Ex20301 {
    // 切分时,左右扫描共有四种情况
    // 假设a[lo]为0
    //      1. 左边0, 右边0
    //      2. 左边1, 右边0
    //      3. 左边0, 右边-1
    //      4. 左边1, 右边-1
    // 1. 左右两边无论谁是0都无法阻挡指针继续前进.
    // 2. 最终左指针>=右指针时,<左指针的<=0,>右指针的>=0.那么lo与右指针交换后,必然右指针和>右指针的>=0
}
