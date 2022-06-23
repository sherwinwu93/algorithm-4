package cat30;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/6/23.
 * Symbol table 行为测试用例
 **/
public class P233BehaviorTest {
    public static void main(String[] args) {
//        P238SequentialSearchST<String, Integer> st = new P238SequentialSearchST<>();
        P239BinarySearchST<String, Integer> st = new P239BinarySearchST<>(10);
        for (int i = 0; !StdIn.isEmpty(); i++)
            st.put(StdIn.readString(), i);

        for (String key : st.keys()) StdOut.println(key + " " + st.get(key));
    }
}
/**
 * idea 运行, 然后命令行输入  S E A R C H E X A M P L E Ctrl-D
 */