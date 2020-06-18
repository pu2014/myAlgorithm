package com.分类题型.链表;

import com.tools.ListNode;
import com.tools.Print;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/6/18 10:08
 */
public class _148排序链表归并 {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(4);
        SortList proc = new SortList();
        Print.printNode(proc.sortList(head));
    }
}
class SortList {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head.next.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rr = mergeSort(slow.next);
        slow.next = null;
        ListNode ll = mergeSort(head);
        return recurMerge(ll, rr);
    }

    public ListNode recurMerge(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = recurMerge(list1.next, list2);
            return list1;
        }else{
            list2.next = recurMerge(list1, list2.next);
            return list2;
        }
    }
}