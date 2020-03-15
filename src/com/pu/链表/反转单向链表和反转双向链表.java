package com.pu.链表;

import com.tools.Print;

import java.math.BigInteger;

public class 反转单向链表和反转双向链表 {
    public static void main(String[] args){
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        head.next = node1;
        head.next.next = node2;
        head.next.next.next = node3;
        head.next.next.next.next = node4;



        DoubleNode dHead = new DoubleNode(1);
        DoubleNode dNode1 = new DoubleNode(2);
        DoubleNode dNode2 = new DoubleNode(3);
        DoubleNode dNode3 = new DoubleNode(4);
        DoubleNode dNode4 = new DoubleNode(5);

        dHead.next = dNode1;
        dNode1.next = dNode2;
        dNode2.next = dNode3;
        dNode3.next = dNode4;
        dNode1.last = dHead;
        dNode2.last = dNode1;
        dNode3.last = dNode2;
        dNode4.last = dNode3;

        printDNode(dHead);
        printNode(head);
        Node res = reverseList(head);
        printNode(res);
        DoubleNode res1 = reverseDoubleList(dHead);
        printDNode(res1);



    }

    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;
        public DoubleNode(int value){
            this.value = value;
        }
    }
    //todo 迭代
    public static Node reverseList(Node head){
        Node pre = null;
        Node next;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    //todo 递归
    public static Node reverseList2(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next;
        while(head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;

    }

    public static void printNode(Node head){
        if(head == null){
            return;
        }
        while(head != null){
            if(head.next == null){
                System.out.print(head.value);
                System.out.println();
                break;
            }
            System.out.print(head.value + "-->");
            head = head.next;
        }
    }

    public static void printDNode(DoubleNode head){
        if(head == null){
            return;
        }
        while(head != null){
            if(head.next == null){
                System.out.print(head.value);
                System.out.println();
                break;
            }
            System.out.print(head.value + "-->");
            head = head.next;
        }
    }
}
