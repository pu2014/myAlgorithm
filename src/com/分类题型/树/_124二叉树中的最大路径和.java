package com.分类题型.树;

import com.tools.TreeNode;
import sun.security.util.Length;

/**
 * Description:
 * Created By @Author my on @Date 2020/6/27 23:41
 */
public class _124二叉树中的最大路径和 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(new Solution().maxPathSum(root));
    }
    static class Solution {
        private int res = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            getMax(root);
            return res;
        }

        private int getMax(TreeNode root) {
            if(root == null){
                return 0;
            }
            int left = Math.max(0, getMax(root.left));
            int right = Math.max(0, getMax(root.right));
            res = Math.max(res, left + right + root.val);
            return Math.max(left, right) + root.val;
        }
    }
}
