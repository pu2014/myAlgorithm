package com.分类题型.树;

import com.tools.Print;
import com.tools.TreeNode;

import java.util.Stack;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/3/10 9:37
 */
public class 树的按深度遍历DFS {
    public static void main(String[] args) {
        TreeNode root = new com.tools.TreeNode(0);
        root.left = new com.tools.TreeNode(1);
        root.right = new com.tools.TreeNode(4);
        root.left.left = new com.tools.TreeNode(2);
        root.left.right = new com.tools.TreeNode(3);
        root.right.right = new TreeNode(5);
        Print.printTree(root);
        dfs(root);
    }

    private static void dfs(TreeNode root) {
        preOrder(root);
        inOrder(root);
        posOrder(root);
    }

    private static void posOrder(TreeNode root) {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() + ": ");
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if(root.right == null || root.right == pre){
                System.out.print(stack.pop().val + "--");
                pre = root;
                root = null;
            }else{
                root = root.right;
            }
        }
        System.out.println();
    }

    private static void inOrder(TreeNode root) {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() + ": ");
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                TreeNode cur = stack.pop();
                System.out.print(cur.val + "--");
                root = cur.right;
            }
        }
        System.out.println();
    }

    private static void preOrder(TreeNode root) {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() + ": ");
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                System.out.print(root.val + "--");
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop().right;
            }
        }
        System.out.println();
    }
}
