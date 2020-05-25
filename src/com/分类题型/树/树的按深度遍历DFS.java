package com.分类题型.树;

import com.tools.Print;
import com.tools.TreeNode;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/3/10 9:37
 */
public class 树的按深度遍历DFS {
    public static void main(String[] args) {
        com.tools.TreeNode root = new com.tools.TreeNode(0);
        root.left = new com.tools.TreeNode(1);
        root.right = new com.tools.TreeNode(4);
        root.left.left = new com.tools.TreeNode(2);
        root.left.right = new com.tools.TreeNode(3);
        root.right.right = new TreeNode(5);
        Print.printTree(root);
        dfs(root);
    }

    private static void dfs(TreeNode root) {
        //pre in pos
    }
}
