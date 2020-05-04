package com.pu.树;

import com.tools.TreeNode;

import java.util.Stack;

/**
 * 搜索二叉树：左子树比他小，右子树比他大
 *
 * 问题点，中序遍历依次升序
 */
public class 判断是否是搜索二叉树 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);

        head.left = node1;
        node1.left = node2;
        head.right = node3;
        node3.right = node5;
        node3.left = node4;
        System.out.println(isBST(head));
        System.out.println(isBST1(head));
        System.out.println(isBSTv3(head));
    }

    private static boolean isBST1(TreeNode head) {
        if(head == null){
            return false;
        }
        return process(head);
    }

    private static boolean process(TreeNode head) {
        if(head == null){
            return true;
        }
        if(head.left != null){
            if(head.left.val >  head.val){
                return false;
            }
        }
        if(head.right != null){
            if(head.right.val < head.val){
                return false;
            }
        }
        return process(head.left) && process(head.right);
    }

    public static boolean isBSTv3(TreeNode head){
        if (head == null) {
            return true;
        }
        boolean res = true;
        TreeNode pre = null;
        TreeNode cur1 = head;
        TreeNode cur2 = null;
        while (cur1 != null) { // moris中序遍历？
            cur2 = cur1.left; //先遍历左孩子
            if (cur2 != null) { //左孩子不为空
                while (cur2.right != null && cur2.right != cur1) {//左孩子的右孩子不为null且不cur1
                    cur2 = cur2.right;//找到最右的孩子
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            if (pre != null && pre.val > cur1.val) {
                res = false;
            }
            pre = cur1;
            cur1 = cur1.right;
        }
        return res;
    }

    public static boolean isBST(TreeNode head) { // 中序遍历
        Stack<TreeNode> stack = new Stack<>();
        int last = Integer.MIN_VALUE;
        while (head != null || !stack.isEmpty()) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (last < head.val) {
                    last = head.val;
                } else {
                    return false;
                }
                head = head.right;
            }
        }
        return true;
    }
}
