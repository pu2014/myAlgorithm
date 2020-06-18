package com.分类题型.链表;

import com.tools.ListNode;
import com.tools.Print;

/**
 * @DESC 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *  
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 *  
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @CREATE BY @Author pbj on @Date 2020/6/18 21:53
 */
public class _25K个一组翻转链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseKGroup proc = new ReverseKGroup();
        Print.printNode(proc.reverseKGroup(head,2));
    }
}
class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        for(int i = 0; i < k; i++){
            if(cur == null){
                return head;
            }
            cur = cur.next;
        }
        ListNode newHead = reverseList(head, cur);
        head.next = reverseKGroup(cur, k);
        return newHead;

    }
    public ListNode reverseList(ListNode head, ListNode tail){
        if(head == tail || head.next == tail){
            return head;
        }
        ListNode pre = tail;
        ListNode next;
        while(head != tail){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}