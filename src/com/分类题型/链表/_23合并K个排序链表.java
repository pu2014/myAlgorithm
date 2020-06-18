package com.分类题型.链表;

import com.tools.ListNode;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/6/18 10:57
 */
public class _23合并K个排序链表 {
}
class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    public ListNode mergeKListsHelper(ListNode[] lists, int L, int R){
        if(L == R){
            return lists[L];
        }
        int mid = L + (R - L)/2;
        return mergeTwoLists(mergeKListsHelper(lists, L, mid), mergeKListsHelper(lists, mid + 1, R));
    }


    public ListNode mergeTwoLists(ListNode head1, ListNode head2){
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                cur.next = head1;
                head1 = head1.next;
            }else{
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return newHead.next;
    }
}