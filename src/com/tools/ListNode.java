package com.tools;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/2/25 16:40
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode createListNode(int len){
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for(int i = 0; i < len; i++){
            cur.next = new ListNode(i + 1);
            cur = cur.next;
        }
        return head.next;
    }

    public static ListNode createListNode(int[] obs){
        ListNode head = new ListNode(obs[0]);
        ListNode cur = head;
        for(int i = 1; i < obs.length; i++){
            cur.next = new ListNode(obs[i]);
            cur = cur.next;
        }
        return head;
    }

}
