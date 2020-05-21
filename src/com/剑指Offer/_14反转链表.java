package com.剑指Offer;

import com.tools.ListNode;
import com.tools.Print;

/**
 * description：
 *输入一个链表，反转链表后，输出新链表的表头。
 * @author Pubojian
 * @date 2020/3/8 20:42
 */
public class _14反转链表 {
    public static void main(String[] args) {
        ListNode head = ListNode.createListNode(6);
        Print.printNode(head);
        Print.printNode(new ReverseList().method(head));
    }
}
class ReverseList {
    public ListNode method(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

