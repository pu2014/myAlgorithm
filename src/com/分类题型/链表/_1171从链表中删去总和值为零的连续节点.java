package com.分类题型.链表;

import com.tools.ListNode;
import com.tools.Print;

import java.util.HashMap;
import java.util.Map;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/6/21 9:54
 */
public class _1171从链表中删去总和值为零的连续节点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(-3);
        head.next.next.next.next = new ListNode(5);
        RemoveZeroSumSublists proc = new RemoveZeroSumSublists();
        Print.printNode(proc.fun(head));
    }
}
class RemoveZeroSumSublists {
    public ListNode fun(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        for(ListNode cur = newHead; cur != null; cur = cur.next){
            sum += cur.val;
            map.put(sum, cur);
        }
        sum = 0;
        for(ListNode cur = newHead; cur != null; cur = cur.next){
            sum += cur.val;
            cur.next = map.get(sum).next;
        }
        return newHead.next;
    }
}