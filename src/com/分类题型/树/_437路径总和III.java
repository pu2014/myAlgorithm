package com.分类题型.树;

import com.tools.TreeNode;

/**
 * @DESC 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @CREATE BY @Author pbj on @Date 2020/6/28 11:33
 */
public class _437路径总和III {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        System.out.println(new Solution().pathSum(root, 3));
    }
    static class Solution {
        private int cnt = 0;
        public int pathSum(TreeNode root, int sum) {
            process(root, sum, false);
            return cnt;
        }

        private void process(TreeNode root, int sum, boolean flag){
            if(root == null){
                return;
            }
            int cur = sum - root.val;
            if(cur == 0){
                cnt++;
            }
            if(flag == true){
                process(root.right, cur, flag);
                process(root.left, cur, flag);
            }else{
                process(root.right, cur, true);
                process(root.left, cur, true);
                process(root.left, sum, false);
                process(root.right, sum, false);
            }

        }
    }
}
