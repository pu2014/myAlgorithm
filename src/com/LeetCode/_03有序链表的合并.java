package com.LeetCode;

/**
 * description：
 * 题目1：合并两个有序链表  //简单
 * 题目2：合并K个有序链表     //采用归并的手段简化
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * @author Pubojian
 * @date 2020/2/23 14:13
 */
public class _03有序链表的合并 {
    static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        /**
         * 1->4->5,
         * 1->3->4,
         * 2->6
          */

        Node head1 = new Node(1);
        head1.next = new Node(4);
        head1.next.next = new Node(5);

        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(4);

        Node head3 = new Node(2);
        head3.next = new Node(6);

        Node[] nodes = {head1, head2, head3};

        Node res = mergeKLists(nodes);

        while(res != null){
            System.out.print(res.val + "");
            res = res.next;
        }
    }

    private static Node mergeKLists(Node[] nodes) {
        if(nodes == null || nodes.length == 0){
            return null;
        }
        return mergeKListsHelper(nodes, 0, nodes.length - 1);
    }

    private static Node mergeKListsHelper(Node[] nodes, int L, int R) {
        if(L == R){
            return nodes[L];
        }
        int mid = L + (R - L) / 2;
        return mergeTwoLists(mergeKListsHelper(nodes, L, mid), mergeKListsHelper(nodes, mid + 1, R));
    }

    private static Node mergeTwoLists(Node head1, Node head2) {
        Node head = new Node(-1);
        Node cur = head;
        while(head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return head.next;
    }

}
