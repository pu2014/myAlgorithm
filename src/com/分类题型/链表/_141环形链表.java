package com.分类题型.链表;

import com.tools.ListNode;

/**
 * @DESC 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @CREATE BY @Author pbj on @Date 2020/6/11 15:45
 */
public class _141环形链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = head;

        HasCycle proc = new HasCycle();
        System.out.println(proc.fun(head));
    }
}
class HasCycle {
    public boolean fun(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(fast != null && fast.next != null && fast != slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast == slow;
    }
}
