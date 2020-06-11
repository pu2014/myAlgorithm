package com.分类题型.链表;

import com.tools.ListNode;
import com.tools.Print;

/**
 * @DESC 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @CREATE BY @Author pbj on @Date 2020/6/11 10:04
 */
public class _92反转链表2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseBetween proc = new ReverseBetween();
        Print.printNode(proc.reverseBetween(head, 2, 4));
    }
}
class ReverseBetween {
    ListNode pos = null;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == 1){
            return process(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    private ListNode process(ListNode head, int n) {
        if(n == 1){
            pos = head.next;
            return head;
        }
        ListNode newHead = process(head.next, n - 1);
        head.next.next = head;
        head.next = pos;
        return newHead;
    }
}