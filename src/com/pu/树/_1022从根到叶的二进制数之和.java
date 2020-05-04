package com.pu.树;

import com.tools.Print;
import com.tools.TreeNode;

/**
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * 以 10^9 + 7 为模，返回这些数字之和
 */
public class _1022从根到叶的二进制数之和 {
    public static void main(String[] args) {
        SumRootToLeaf solution = new SumRootToLeaf();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        Print.printTree(root);
        System.out.println(solution.method(root));
    }
}
class SumRootToLeaf{
    private int sum = 0;
    public int method(TreeNode root) {
        int mod = (int) (Math.pow(10, 9) + 7);
        if(root == null){
            return -1;
        }
        process(root, 0);
        return sum % mod;
    }

    private void process(TreeNode root, int num) {
        if(root == null){
            return;
        }
        num += root.val;
        if(root.left == null && root.right == null){ //该点为叶子节点，就加入sum
            sum += num;
        }else{
            process(root.left, num << 1);
            process(root.right, num << 1);
        }
    }
}
