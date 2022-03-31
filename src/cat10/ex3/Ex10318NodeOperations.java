package cat10.ex3;

import edu.princeton.cs.algs4.StdOut;

public class Ex10318NodeOperations {
    private Node node;

    public Ex10318NodeOperations(Node node) {
        this.node = node;
    }

    public String max() {
        Node maxNode = node;
        for (Node currentNode = node; currentNode != null; currentNode = currentNode.next)
            if (currentNode.item.compareTo(maxNode.item) > 0) maxNode = currentNode;
        return maxNode.item;
    }
    public String maxRecur() {
        return maxRecur(node, node);
    }

    public String maxRecur(Node currentNode, Node maxNode) {
        if (currentNode == null) return maxNode.item;
        if (currentNode.item.compareTo(maxNode.item) > 0) maxNode = currentNode;
        return maxRecur(currentNode.next, maxNode);
    }

    //1.3.26
    public void remove(String key) {
        while (node != null && node.item.equals(key))
            node = node.next;
        Node currentNode = node;
        while (currentNode != null && currentNode.next != null) {
            if (currentNode.next.item.equals(key)) deleteNext(currentNode);
            currentNode = currentNode.next;
        }
    }

    // 1.3.25
    public void insertAfter(Node t) {
        t.next = node.next;
        node.next = t;
    }

    //1.3.24删除后续节点
    public void removeAfter() {
        if (node.next == null) ;
        else node.next = node.next.next;
    }

    //1.3.23
    public void errorInsertNext(Node t) {
        node.next = t;
        //x的next已经变成了t. oldX的next全部丢失
        t.next = node.next;
    }

    //1.3.22
    public void insertNext(Node t) {
        t.next = node.next;
        node.next = t;
    }

    // 1.3.21
    public boolean find(String key) {
        Node currentNode = node;
        while (currentNode != null) {
            if (currentNode.item.equals(key)) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    // 1.3.20
    public void delete(int k) {
        if (k == 0) node = node.next;
        else {
            Node currentNode = node;
            while (k-- != 1)
                currentNode = currentNode.next;
            deleteNext(currentNode);
        }
    }

    // 1.3.19
    public void deleteLast() {
        if (node.next == null) node = null;
        else {
            Node currentNode = node;
            while (currentNode.next.next != null)
                currentNode = currentNode.next;
            deleteNext(currentNode);
        }
    }

    public Node node() {
        return node;
    }

    /**
     * 删除x的下一个节点
     *
     * @param x
     */
    public static void deleteNext(Node x) {
        x.next = x.next.next;
    }

    public static void main(String[] args) {
        Node first = new Node();
        first.item = "to";
        Node second = new Node();
        second.item = "be";
        Node third = new Node();
        third.item = "or";
        Node fourth = new Node();
        fourth.item = "not";

        first.next = second;
        second.next = third;

        Ex10318NodeOperations operations = new Ex10318NodeOperations(first);

//        operations.deleteLast();
//        operations.delete(0);
//        operations.find("be");
//        operations.find("not");
//        operations.find("or");
//        operations.insertAfter(fourth);
        StdOut.println(operations.max());
    }

    private static class Node {
        String item;
        Node next;
    }
}
