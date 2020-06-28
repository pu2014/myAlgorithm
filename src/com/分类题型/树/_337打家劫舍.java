package com.分类题型.树;

import com.tools.TreeNode;

/**
 * @DESC
在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

示例 1:

输入: [3,2,3,null,3,null,1]

3
/ \
2   3
\   \
3   1

输出: 7
解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * @CREATE BY @Author pbj on @Date 2020/6/28 13:22
 */
public class _337打家劫舍 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        System.out.println(new Solution().rob(root));
    }
    static class Solution {
        public int rob(TreeNode root) {
            int[] ret = process(root);
            return Math.max(ret[0], ret[1]);
        }

        /**
         * 0 表示 不偷  1 表示偷
         * @param root
         * @return
         */
        private int[] process(TreeNode root) {
            if(root == null){
                return new int[2];
            }
            int[] ret = new int[2];
            int[] left = process(root.left);
            int[] right = process(root.right);
            ret[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            ret[1] = root.val + left[0] + right[0];
            return ret;
        }
    }
}
