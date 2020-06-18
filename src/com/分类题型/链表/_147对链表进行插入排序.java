package com.分类题型.链表;

import com.tools.ListNode;
import com.tools.Print;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/6/18 9:38
 */
public class _147对链表进行插入排序 {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(4);
        InsertionSortList proc = new InsertionSortList();
        Print.printNode(proc.insert(head));
    }
}
class InsertionSortList {
    public ListNode insert(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode cur = newHead.next;
        ListNode next = null;
        ListNode insert = newHead;
        while(cur != null){
            if(cur.val >= pre.val){
                pre = cur;
                cur = cur.next;
            }else{
                next = cur.next;
                insert = newHead;
                while(insert.next != cur && insert.next.val < pre.val){
                    insert = insert.next;
                }
                cur.next = insert.next;
                insert.next = cur;
                pre.next = next;
                cur = next;
            }
        }
        return newHead.next;
    }
}