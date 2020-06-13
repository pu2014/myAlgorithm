package com.分类题型.链表;

import com.tools.ListNode;
import com.tools.Print;
import com.tools.TreeNode;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/6/14 0:14
 */
public class _109有序链表转换二叉搜索树 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        SortedListToBST sortedListToBST = new SortedListToBST();
        Print.printTree(sortedListToBST.sortedListToBST(head));
    }
}
class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return new TreeNode(head.val);
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.right = sortedListToBST(slow.next);
        pre.next = null;
        root.left = sortedListToBST(head);
        return root;
    }
}