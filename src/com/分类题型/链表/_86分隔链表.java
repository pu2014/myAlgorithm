package com.分类题型.链表;

import com.tools.ListNode;
import com.tools.Print;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/6/11 11:29
 */
public class _86分隔链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);

        ListPartition proc = new ListPartition();
        Print.printNode(proc.fun(head,3));
    }
}
class ListPartition {
    public ListNode fun(ListNode head, int x) {
        if(head == null){
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cur = newHead;
        ListNode sHead = new ListNode(-1);
        ListNode ps = sHead;
        ListNode next;
        while(cur.next != null){
            if(cur.next.val >= x){
                next = cur.next.next;
                cur.next.next = null;
                ps.next = cur.next;
                ps = ps.next;
                cur.next = next;
            }else{
                cur = cur.next;
            }
        }
        cur.next = sHead.next;
        return newHead.next;
    }

    public ListNode fun2(ListNode head, int x) {
        if(head == null){
            return head;
        }
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        ListNode sHead = new ListNode(-1);
        ListNode ps = sHead;
        while(head != null){
            if(head.val >= x){
                ps.next = head;
                ps = ps.next;
            }else{
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
        }
        ps.next = null;
        cur.next = sHead.next;
        return newHead.next;
    }
}
