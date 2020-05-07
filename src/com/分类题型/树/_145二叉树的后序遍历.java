package com.分类题型.树;

import com.tools.TreeNode;

import java.util.Stack;

/**
 * @DESC 二叉树的后序遍历
 * @CREATE BY @Author pbj on @Date 2020/5/7 11:16
 */
public class _145二叉树的后序遍历 {
    public static void main(String[] args) {
        com.tools.TreeNode root = new com.tools.TreeNode(5);
        root.left = new com.tools.TreeNode(1);
        root.right = new com.tools.TreeNode(7);
        root.right.left = new com.tools.TreeNode(6);
        root.right.right = new TreeNode(8);
        posTravel(root);
    }

    private static void posTravel(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);  // 2（1，3）
        TreeNode p;
        while(!stack.isEmpty()){
            p = stack.peek(); //2  //1  //2
            if(p.left != null && p.left != root && p.right != root){//2->left == 1 right = 3  // 1.left = null //2.left == 1
                stack.push(p.left); //left 1 进来
            }else if(p.right != null && p.right != root){ //1.right == null //2.right == 3 进
                stack.push(p.right);// right 进来
            }else{
                System.out.print(stack.pop().val + " "); //1出
                root = p; //root = 1;
            }
        }
    }
}
