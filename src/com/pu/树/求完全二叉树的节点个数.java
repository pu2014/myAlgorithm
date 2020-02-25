package com.pu.树;

import com.tools.TreeNode;

/**
 * 已知一棵完全二叉树，求其节点的个数
 * 要求：时间复杂度低于O(N)，N为这棵树的节点个数
 *
 * 若设二叉树的深度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，
 * 第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。
 * 满树的节点数=2 ^ h - 1;
 *
 * 算法复杂度：遍历节点logN 获取左边界LogN  总的复杂度 2LogN
 * @author Pubojian
 * @date 2019/11/7 15:15
 */
public class 求完全二叉树的节点个数 {
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
        System.out.println(nodeNum1(head));
        System.out.println(nodeNum2(head));
    }

    public static int nodeNum1(TreeNode head){
        /**
         * Description:就判断右树的左边界是否到最后一层，到了左树就是满的，
         * 没到右树就是满的，只不过左树和右树满的高度不一样而已，
         * 都可以使用公式来计算。剩下的节点递归去求
         * @auther
         */
        if(head == null){
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    private static int bs(TreeNode head, int level, int h) {
        /**
         * h:整棵树的高度
         * level：当前层
         */
        if(level == h){
            return 1;
        }
        //左右高度一致（左子树为满二叉树）
        if(mostLeftLevel(head.right, level + 1) == h){
            //返回 左子树的节点 2*(h-level) - 1 + 右子树的节点 + 1顶点
            return(1 << (h - level)) + bs(head.right, level + 1, h);
        }else{
            //左右不一致，右子树为h-1 的满二叉树
            return (1 << (h - level - 1)) + bs(head.left, level + 1, h);
        }
    }

    private static int mostLeftLevel(TreeNode head, int level) {
        while(head != null){
            level ++;
            head = head.left;
        }
        return level - 1;
    }

    public static int nodeNum2(TreeNode head){
        if(head == null){
            return 0;
        }
        int leftCount = 0;
        int rightCount = 0;
        TreeNode leftNode = head;
        TreeNode rightNode = head;
        while(leftNode != null){
            leftCount++;
            leftNode = leftNode.left;
        }
        while(rightNode != null){
            rightCount++;
            rightNode = rightNode.right;
        }
        if(rightCount == leftCount){
            return (1 << leftCount) - 1;
        }else{
            return 1 + nodeNum2(head.left) + nodeNum2(head.right);
        }

    }

}
