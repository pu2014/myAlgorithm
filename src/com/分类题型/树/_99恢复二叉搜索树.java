package com.分类题型.树;

import java.util.Stack;

import com.tools.Print;
import com.tools.TreeNode;
/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/7 16:40
 */
public class _99恢复二叉搜索树 {
    public static void main(String[] args) {
        TreeNode root = new com.tools.TreeNode(5);
        root.left = new com.tools.TreeNode(1);
        root.right = new com.tools.TreeNode(7);
        root.right.left = new com.tools.TreeNode(8);
        root.right.right = new com.tools.TreeNode(6);

        Print.printTree(root);
        new RecoverBinaryTree().recoverTree(root);
        Print.printTree(root);
    }
}
class RecoverBinaryTree{
    TreeNode pre;
    TreeNode a,b;
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        inOrder(root);
        int temp = a.val;
        a.val = b.val;
        b.val = temp;

    }
    public void inOrder(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while(p != null || !s.isEmpty()){
            while(p != null){
                s.push(p);
                p = p.left;
            }
            if(!s.isEmpty()){
                p = s.pop();
                if(pre != null && pre.val > p.val){
                    if(a == null){
                        a = pre;
                    }
                    b = p;
                }
                pre = p;
                p = p.right;
            }
        }
    }
}
