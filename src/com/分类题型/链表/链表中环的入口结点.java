package com.分类题型.链表;

import java.util.ArrayList;

/**
 * description：给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * @author Pubojian
 * @date 2020/2/4 21:42
 */
public class 链表中环的入口结点 {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);
        Node node8 = new Node(9);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node5;
        Node t1 = EntryNodeOfLoopByList(head1);
        if(t1 == null){
            System.out.println("null");
        }else{
            System.out.println(t1.val);
        }
        Node t2 = EntryNodeOfLoopByTwoPointers(head1);
        if(t2 == null){
            System.out.println("null");
        }else{
            System.out.println(t2.val);
        }

    }

    private static Node EntryNodeOfLoopByTwoPointers(Node pHead) {
        Node slow = pHead.next;
        Node fast = pHead.next.next;
        while(fast != slow){
            if(fast.next == null || fast.next.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        //得到环的长度
        Node mid = pHead;
        fast = fast.next;
        while(fast != slow){
            fast = fast.next;
            mid = mid.next;
        }
        System.out.println("1");
        mid = mid.next;
        fast = pHead;
        while(fast != mid){
            fast = fast.next;
            mid = mid.next;
        }
        return fast;
    }

    private static Node EntryNodeOfLoopByList(Node pHead) {
        ArrayList<Node> list = new ArrayList<>();
        Node node = pHead;
        while(node != null){
            if(list.contains(node)){
                return node;
            }else{
                list.add(node);
                node = node.next;
            }
        }
        return null;
    }


}
