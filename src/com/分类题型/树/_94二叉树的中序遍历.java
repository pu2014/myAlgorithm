package com.分类题型.树;

import com.tools.TreeNode;

import java.util.Stack;

/**
 * @DESC 二叉树的中序遍历
 * @CREATE BY @Author pbj on @Date 2020/5/7 11:09
 */
public class _94二叉树的中序遍历 {
    public static void main(String[] args) {
        com.tools.TreeNode root = new com.tools.TreeNode(5);
        root.left = new com.tools.TreeNode(1);
        root.right = new com.tools.TreeNode(7);
        root.right.left = new com.tools.TreeNode(6);
        root.right.right = new TreeNode(8);
        inTravel(root);
    }

    private static void inTravel(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while(p != null || !s.isEmpty()){
            while(p != null){
                s.push(p);
                p = p.left;
            }
            if(!s.isEmpty()){
                p = s.pop();
                System.out.print(p.val + "-->");
                p = p.right;
            }
        }
    }
}
