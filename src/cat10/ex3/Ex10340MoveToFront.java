package cat10.ex3;

import edu.princeton.cs.algs4.StdOut;

public class Ex10340MoveToFront {
    public static void main(String[] args) {
        // 前移编码策略,策略假设最近访问过的元素可能会再次访问,因此可以用于缓存`数据压缩等许多场景
        // recentf
        Ex10340MoveToFront recentf = new Ex10340MoveToFront();
        recentf.insert("第1章");
        recentf.insert("第2章");
        recentf.insert("第1章");
        recentf.insert("第3章");
        recentf.insert("第1章");
        recentf.insert("第1章");
        StdOut.println(recentf);
    }

    private Node sentinel = new Node();

    public void insert(String item) {
        delete(item);
        Node t = new Node(item);
        t.next = sentinel.next;
        sentinel.next = t;
    }

    private void delete(String item) {
        if (sentinel.next == null) ;
        else {
            Node zeroth = sentinel;
            while (zeroth.next != null) {
                if (zeroth.next.item.equals(item)) {
                    zeroth.next = zeroth.next.next;
                    break;
                }
                zeroth = zeroth.next;
            }
        }
    }

    private class Node {
        String item;
        Node next;

        public Node(String item) {
            this.item = item;
        }

        public Node() {
        }
    }
}
