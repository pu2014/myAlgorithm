package com.pu.树;

import com.tools.TreeNode;

/**
 * description：判断是否是满二叉树
 *
 * @author Pubojian
 * @date 2019/11/7 15:57
 */
public class 判断是否为满二叉树 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(8);

        head.left = node1;
        head.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        //node2.right = node6;
        // head.right = node3;
        //node3.right = node5;
        //node3.left = node4;
        System.out.println(isFBT(head));
    }

    private static boolean isFBT(TreeNode head) {
        if(head == null){
            return false;
        }
        //判定叶子节点
        if(head.left != null && head.right != null
                && head.left.right == null && head.left.left == null
                && head.right.left == null && head.right.right == null){
            return true;
        }else if(head.left != null && head.right != null){
            return isFBT(head.left) && isFBT(head.right);
        }else {
            return false;
        }
    }
}
