package com.分类题型.树;

import com.tools.Tree;
import com.tools.TreeNode;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/7/5 15:11
 */
public class _236二叉树的最近公共祖先 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        System.out.println(new Solution().lowestCommonAncestor(root,root.right.left, root.right.right));
    }
    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null || root == p || root == q){
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(left == null) return right;
            if(right == null) return left;
            return root;
        }
    }
}
