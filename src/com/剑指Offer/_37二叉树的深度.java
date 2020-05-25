package com.剑指Offer;

import com.tools.Print;
import com.tools.TreeNode;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/19 14:44
 */
public class _37二叉树的深度 {
    public static void main(String[] args) {
        com.tools.TreeNode root = new com.tools.TreeNode(0);
        root.left = new com.tools.TreeNode(1);
        root.right = new com.tools.TreeNode(4);
        root.left.left = new com.tools.TreeNode(2);
        root.left.right = new com.tools.TreeNode(3);
        root.right.right = new TreeNode(5);
        Print.printTree(root);
        Print.out(new TreeDepth().fun(root));

    }
}
class TreeDepth {
    public int fun(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(fun(root.left),fun(root.right)) + 1;
    }
}
