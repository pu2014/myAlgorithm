package com.分类题型.链表;

import com.tools.ListNode;
import com.tools.Print;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/6/11 10:44
 */
public class _19删除链表的倒数第N个节点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        RemoveNthFromEnd proc = new RemoveNthFromEnd();
        Print.printNode(proc.fun(head, 2));
    }
}
class RemoveNthFromEnd {
    public ListNode fun(ListNode head, int n) {
        if(head == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(n-- > 0){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}