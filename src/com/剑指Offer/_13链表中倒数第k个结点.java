package com.剑指Offer;

import com.tools.Node;
import com.tools.Print;

import java.util.List;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/3/8 10:13
 */
public class _13链表中倒数第k个结点 {
    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Print.printNode(head);
        System.out.println(new FindKthToTail().method(head, 4).val);
    }
}
class FindKthToTail {
    public Node method(Node head, int k) {
        //双指针
        Node fast = head;
        Node slow = head;
        while(k > 0 && fast != null){
            fast = fast.next;
            k--;
        }
        if(fast == null && k > 0){
            return null;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}