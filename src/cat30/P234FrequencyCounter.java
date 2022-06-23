package cat30;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/6/23.
 **/
public class P234FrequencyCounter {
    public static void main(String[] args) {
        // 从输入获取最小长度
        int minlen = Integer.parseInt(args[0]);
        // 构造并put word 和出现次数 到ST
        P239BinarySearchST<String, Integer> st = new P239BinarySearchST<>(999999);
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.length() < minlen) continue;
            if (!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word) + 1);
        }
        // 从ST中找出频率最高的元素
        String max = "";//哨兵
        st.put(max, 0);

        for (String key : st.keys())
            if (st.get(key) > st.get(max))
                max = key;
        StdOut.println(max + " " + st.get(max));
    }
}
