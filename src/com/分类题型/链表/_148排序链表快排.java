package com.分类题型.链表;

import com.tools.ListNode;
import com.tools.Print;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/6/18 10:19
 */
public class _148排序链表快排 {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(4);
        QuickSortList proc = new QuickSortList();
        Print.printNode(proc.sortList(head));
    }
}
class QuickSortList{
    public ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        return quickSort(newHead, null);
    }

    private ListNode quickSort(ListNode head, ListNode end) {
        if(head == end || head.next == end || head.next.next == end){
            return head;
        }
        ListNode smaller = new ListNode(-1);
        ListNode partition = head.next;
        ListNode p = partition;
        ListNode tp = smaller;
        while(p.next != end){
            if(p.next.val < partition.val){
                tp.next = p.next;
                tp = tp.next;
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }
        tp.next = head.next;
        head.next = smaller.next;
        quickSort(head, partition);
        quickSort(partition,end);
        return head.next;
    }
}

