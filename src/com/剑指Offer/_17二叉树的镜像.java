package com.剑指Offer;


import com.tools.Print;
import com.tools.Tree;
import com.tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description：操作给定的二叉树，将其变换为源二叉树的镜像。
 * 和_16思路一样
 *
 * @author Pubojian
 * @date 2020/3/10 9:53
 */
public class _17二叉树的镜像 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        Print.printTree(root);


        new Mirror().fun1(root);
        Print.printTree(root);

        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(5);
        Print.printTree(root1);
        new Mirror().fun2(root1);
        Print.printTree(root1);
    }
}
class Mirror {
    public void fun1(TreeNode root) {
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            swap(node);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }

    }
    public void swap(TreeNode node){
        if(node == null){
            return;
        }
        TreeNode help = node.left;
        node.left = node.right;
        node.right = help;
    }

    public void fun2(TreeNode root){
        if(root == null){
            return;
        }
        swap(root);
        fun2(root.left);
        fun2(root.right);
    }
}
