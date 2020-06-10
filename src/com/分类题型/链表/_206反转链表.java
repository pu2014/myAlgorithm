package com.分类题型.链表;

import com.tools.ListNode;
import com.tools.Print;

import java.util.List;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/6/10 11:45
 */
public class _206反转链表 {
    public static void main(String[] args) {
        ReverseList proc = new ReverseList();
        ListNode list1 = ListNode.createListNode(10);
        ListNode list2 = ListNode.createListNode(10);
        proc.fun1(list1);
        Print.printNode(list1);
    }
}
class ReverseList {
    public ListNode fun1(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode fun2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = fun2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
