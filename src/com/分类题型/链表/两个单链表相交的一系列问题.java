package com.分类题型.链表;

import java.util.HashSet;

public class 两个单链表相交的一系列问题 {
    /**
     * 在本题中，单链表可能有环，也可能无环，给定两个单链表的头结点，
     * 这两个链表可能相交可能不相交，实现函数如果两个链表相交。请返回
     * 相交的第一个节点，如果不相交，返回null即可。
     *
     * 要求：时间复杂度O（N+M） 额外空间复杂度为O（1）
     */

    public static void main(String[] args){
        Node head1 = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node head2 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);
        Node node8 = new Node(9);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        head2.next = node6;
        node6.next = node2;
        node7.next = node8;
        //Node res1 = getFirstLoopNode(head1);
        //Node res2 = getFirstLoopNodeNoUsingHashMap(head1);
        //System.out.println(res1.val);
        //System.out.println(res2.val);
        Node res3 = getFirstNonLoopIntersectNode(head1,head2);
        System.out.println(res3.val);

    }
    //use HashMap  contains()
    public static Node getFirstLoopNode(Node head){
        HashSet<Node> set = new HashSet<Node>();
        while(head != null){
            if(set.contains(head)){
                return head;
            }else{
                set.add(head);
                head = head.next;
            }
        }
        return null;
    }

    //no using HashMap  use math theory
    public static Node getFirstLoopNodeNoUsingHashMap(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node fast = head.next.next;
        Node slow = head.next;
        while(fast != slow){
            if(fast.next == null || fast.next.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    //using hashset

    public static Node getFirstIntersectionNode(Node head1,Node head2){
        // If the non-cyclic single linked list intersects,
        // the intersection must be the last node of the two linked lists
        if(getFirstLoopNodeNoUsingHashMap(head1) == null && getFirstLoopNodeNoUsingHashMap(head2) == null){
            return getFirstNonLoopIntersectNode(head1,head2);
        }else if(getFirstLoopNodeNoUsingHashMap(head1) != null && getFirstLoopNodeNoUsingHashMap(head2) != null){
            Node loop1 = getFirstLoopNodeNoUsingHashMap(head1);
            Node loop2 = getFirstLoopNodeNoUsingHashMap(head2);
            if(loop1 == loop2){
                loop1.next = null;
                loop2.next = null;
                return getFirstNonLoopIntersectNode(head1,head2);
            }else{
                Node cur = loop1.next;
                while(cur != loop1){
                    if(cur == loop2){
                        return loop1;  // or loop2
                    }
                    cur = cur.next;
                }
                return null;
            }

        }else{
            //non-circlar single linkedlist and circular linkedlist cannot intersect
            return null;
        }

    }

    public static Node getFirstNonLoopIntersectNode(Node head1,Node head2){
        // If the non-cyclic single linked list intersects,
        // the intersection must be the last nodes of the two linked lists
        HashSet<Node> set = new HashSet<>();
        while(head1 != null){
            set.add(head1);
            head1 = head1.next;
        }
        while(head2 != null){
            if(set.contains(head2)){
                return head2;
            }
            head2 = head2.next;
        }
        return null;
    }

    //no using HashSet
    public static Node getFirstNonLoopIntersectNodeNoUsingHashMap(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node node1 = head1;
        Node node2 = head2;
        int n1 = 0;
        int n2 = 0;
        while(node1 != null){
            n1++;
            node1 = node1.next;
        }
        while(node2 != null){
            n2++;
            node2 = node2.next;
        }
        if(node1 != node2){
            return null;
        }
        node1 = n1 > n2 ? head1 : head2;
        node2 = node1 == head1 ? head2 : head1;
        int n = n1 > n2 ? n1 - n2 : n2 - n1;
        while(n > 0){
            n--;
            node1 = node1.next;
        }
        while(node1 != node2){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }
}
