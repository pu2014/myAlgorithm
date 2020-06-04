package com.分类题型.树;

import com.tools.ListNode;
import com.tools.Print;
import com.tools.TreeNode;

import java.util.Scanner;

/**
 * Description: 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created By @Author my on @Date 2020/5/25 17:27
 */
public class _109有序链表转换二叉搜索树 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SortedListToBST proc = new SortedListToBST();
        while(sc.hasNext()){
            int N = sc.nextInt();
            int[] nums = new int[N];
            for(int i = 0; i < N; i++){
                nums[i] = sc.nextInt();
            }
            ListNode head = ListNode.createListNode(nums);
            Print.printTree(proc.fun(head));
        }

    }
}
class SortedListToBST{
    public TreeNode fun(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return new TreeNode(head.val);
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        ListNode pre = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = fun(head);
        root.right = fun(slow.next);
        return root;
    }
}
