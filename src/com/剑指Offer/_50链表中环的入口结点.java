package com.剑指Offer;

import com.tools.ListNode;

import java.util.Scanner;

/**
 * @DESC 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @CREATE BY @Author pbj on @Date 2020/5/21 15:00
 */
public class _50链表中环的入口结点 {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next.next;
        System.out.println(new EntryNodeOfLoop().fun(head).val);
    }
}
class EntryNodeOfLoop {
    /**
     * 快慢指针 ： 假设p点相遇： (A + B)*2 = A + B + C + B --> C = A
     * @param pHead
     * @return
     */
    public ListNode fun(ListNode pHead) {
        if(pHead == null || pHead.next == null || pHead.next.next == null){
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = pHead;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}