package com.分类题型.树;

import com.tools.TreeNode;

import java.util.Stack;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/7 10:57
 */
public class _144二叉树的前序遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        preTravel(root);
    }
    private static void preTravel(TreeNode root) {
        if(root != null){
            Stack<TreeNode> stack = new Stack();
            TreeNode p = root;
            while (p != null || !stack.isEmpty()){
                while(p != null){
                    System.out.print(p.val + "-->");
                    stack.push(p);
                    p = p.left;
                }
                if(!stack.isEmpty()){
                    p = stack.pop();
                    p = p.right;
                }
            }
            System.out.println();
        }
    }
}


