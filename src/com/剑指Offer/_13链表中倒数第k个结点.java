package com.剑指Offer;

import com.tools.ListNode;
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
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Print.printNode(head);
        System.out.println(new FindKthToTail().method(head, 4).val);
    }
}
class FindKthToTail {
    public ListNode method(ListNode head, int k) {
        //双指针
        ListNode fast = head;
        ListNode slow = head;
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