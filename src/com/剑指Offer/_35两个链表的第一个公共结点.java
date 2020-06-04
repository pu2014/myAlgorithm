package com.剑指Offer;
import com.tools.ListNode;
import com.tools.Print;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/19 12:06
 */

public class _35两个链表的第一个公共结点 {
    public static void main(String[] args) {
        ListNode pHead1 = new ListNode(1);
        pHead1.next = new ListNode(2);
        pHead1.next.next = new ListNode(3);

        ListNode pHead2 = pHead1.next;

        Print.printNode(new FindFirstCommonNode().fun(pHead1,pHead2));
    }
}
class FindFirstCommonNode {
    public ListNode fun(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1 != p2){
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }
}

