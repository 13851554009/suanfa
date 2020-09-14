package com.example.demo.list;

import java.util.ArrayList;
import java.util.List;

public class Reverse {
    public static void main(String[] args) {
        Node node5 = new Node(null, 5);
        Node node4 = new Node(node5, 4);
        Node node3 = new Node(node4, 3);
        Node node2 = new Node(node3, 2);
        Node node1 = new Node(node2, 1);
        Node node0 = new Node(node1, 0);
        Node head = node0;
        for (int i = 0; i < 5; i++) {
            head = head.getNext();
            System.out.println(head.getValue());
        }

//        Node reverse = reverse(node1);

        Node reverseMiddle = reverseMiddle(node1, 2, 4);

        System.out.println(reverseMiddle);
    }

    /**
     * input: 1->2->3->4->5
     * output: 5->4->3->2->1
     *
     * @param head
     * @return
     */
    public static Node reverse(Node head) {   // 入参一个节点
        if (head == null) {
            return null;
        }
        Node pre = head;       // 定义为头节点
        Node current = head.getNext();  // 下一个节点定义为当前节点
        pre.setNext(null);
        while (current != null) {
            Node next = current.getNext();  // 记录当前节点的 下一个节点
            current.setNext(pre);   // 当前节点的下一个节点指向 前一个节点
            pre = current;  // 当前节点作为前节点
            current = next; // 下一个节点作为当前节点
        }
        return pre;
    }

    /**
     * input: 1->2->3->4->5->null, m=2,n=4
     * output: 1->4->3->2->5->null
     *
     * @param head
     * @return
     */
    public static Node reverseMiddle_own(Node head, int m, int n) {
        Node nodem = getNode(head, m);
        Node noden = getNode(head, n);

        Node nPre = getNode(head, n-1);
        Node nNext = noden.getNext();

        Node mPre = getNode(head, m-1);
        Node mNext = nodem.getNext();

        mPre.setNext(noden);
        noden.setNext(mNext);

        nPre.setNext(nodem);
        nodem.setNext(nNext);

        return head;
    }

    public static  Node getNode(Node head, int i){
        Node current = head;
        if(i == 1){
            return current;
        }else {
            int count = 0;
            while (true) {
                if(count++ == i){
                    return current.getNext();
                } else {
                    current = current.getNext();
                }
            }
        }
    }

    /**
     * input: 1->2->3->4->5->null, m=2,n=4
     * output: 1->4->3->2->5->null
     *
     * @param head
     * @return
     */
    public static Node reverseMiddle(Node head, int m, int n) {
        if(head == null){
            return null;
        }

        Node dummy = new Node(); // 定义一个哨兵节点，放在head前面
        dummy.setNext(head);
        head = dummy;

        for (int i = 0; i < m-1; i++) { // 遍历到 m 的前一个节点
            head = head.getNext();
        }
        Node mpre = head;   // 记录 m 前一个节点
        Node mNode = head.getNext();    // m节点
        Node mNext = mNode.getNext(); // 记录 m节点 下一个节点

        for (int i = m-1; i < n-1; i++) {   // 遍历到 n 的前一个节点
            head = head.getNext();
        }
        Node npre = head;   // 记录 n 的前一个节点
        Node nNode = head.getNext();    // n 节点
        Node nNext = nNode.getNext();   // 记录 n节点 下一个节点


        mpre.setNext(nNode);    // 设置m前节点的 下一个节点为  n节点

        nNode.setNext(mNext);   // 设置 n节点的下一个节点 为 原来m的下一个节点

        npre.setNext(mNode);    // 设置 n前节点的 下一个节点 为m节点

        mNode.setNext(nNext);   // 设置 m 节点的 下一个节点 为 原来n的下一个节点


        return dummy.getNext();
    }
}
