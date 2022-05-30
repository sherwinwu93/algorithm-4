package cat20.ex2;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Wusd on 2022/5/30.
 * 1. 找到lastHi
 * 2. 如果lastHi.next为空,那么就结束
 * 3. 找到hi
 * 4. merge (source,lastHi.next,hi)
 * 5. 更新lastHi
 **/
public class Ex20217LinkedListNatureMerge {
    public static Node sort(Node source) {
        Node lastHi = findSortedHi(source);
        while (lastHi.next != null) {
            Node hi = findSortedHi(lastHi.next);
            source = merge(source, lastHi, hi);
            lastHi = findSortedHi(source);
        }
        return source;
    }
    private static Node merge(Node lo, Node mid, Node hi) {
        Node left = lo;
        Node right = mid.next;
        Node result = new Node(null);
        Node currNode = result;
        while (true) {
            if (left == mid.next) {
                currNode.next = right;
                return result.next;
            } else if (right == hi.next) {
                mid.next = hi.next;
                currNode.next = left;
                return result.next;
            } else if (left.item < right.item) {
                Node oldLeft = new Node(left.item);
                left = left.next;

                currNode.next = oldLeft;
                currNode = currNode.next;
            } else {
                Node oldRight = new Node(right.item);
                right = right.next;

                currNode.next = oldRight;
                currNode = currNode.next;
            }
        }
    }

    public static Node findSortedHi(Node currentNode) {
        Node hi = currentNode;
        while (true) {
            if (hi.next == null) return hi;
            if (hi.item > hi.next.item) return hi;
            hi = hi.next;
        }
    }

    public static void main(String[] args) {
        testFindHi();
        Node first = createNode();
        first = sort(first);
        StdOut.println(first);
    }
    public static void testFindHi() {
        Node firstNode = createNode();
        Node sortedHi = findSortedHi(firstNode);
        StdOut.println();
    }
    public static Node createNode() {
        Node first = new Node(1);

        Node second = new Node(0);
        first.next = second;

        Node third = new Node(6);
        second.next = third;

        Node fourth = new Node(3);
        third.next = fourth;

        Node fifth = new Node(4);
        fourth.next = fifth;
        return first;
    }
}
class Node {
    Integer item;
    Node next;
    public Node(Integer item) {
        this.item = item;
    }
}
