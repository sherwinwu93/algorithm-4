package cat10.ex3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class Ex10312StackIterableUseCase {
    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        s.push("a");
        s.push("b");
        s.push("c");
        s.push("d");
        Stack<String> copy = copy(s);
        for (String s0 : s)
            StdOut.println(s0);
        for (String s0 : copy)
            StdOut.println(s0);
    }

    //复制正是迭代器价值的重要体现
    // 有迭代器,无需修改api,就可以实现复制
    public static <Item> Stack<Item> copy(Stack<Item> s) {
        Stack<Item> copy = new Stack<Item>();
        Stack<Item> temp = new Stack<Item>();
        for (Item item : s)
            temp.push(item);
        for (Item item : temp)
            copy.push(item);
        return copy;
    }
}
