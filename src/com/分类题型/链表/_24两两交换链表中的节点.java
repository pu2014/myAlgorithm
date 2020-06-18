package com.分类题型.链表;

import com.tools.ListNode;
import com.tools.Print;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/6/18 21:25
 */
public class _24两两交换链表中的节点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        SwapPairs proc = new SwapPairs();
        Print.printNode(proc.fun(head));
    }
}
class SwapPairs {
    public ListNode fun(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = head.next;
        head.next = fun(tmp.next);
        tmp.next = head;
        return tmp;
    }
}
