package com.分类题型.链表;

import com.tools.ListNode;
import com.tools.Print;

/**
 * Description:给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created By @Author my on @Date 2020/6/15 13:06
 */
public class _328奇偶链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        OddEvenList proc = new OddEvenList();
        Print.printNode(proc.oddEvenList(head));
    }
}
class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode evenHead = new ListNode(-1);
        ListNode even = evenHead;
        ListNode cur = head;
        ListNode next;
        while(cur.next != null){
            next = cur.next.next;
            cur.next.next = null;
            even.next = cur.next;
            even = even.next;
            cur.next = next;
            if(next == null){
                break;
            }
            cur = next;
        }
        cur.next = evenHead.next;
        return head;
    }
}