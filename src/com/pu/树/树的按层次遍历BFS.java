package com.pu.树;

import com.tools.TreeNode;
import com.tools.Print;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/2/1 21:57
 */
public class
树的按层次遍历BFS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        Print.printTree(root);
        bfs(root);
    }

    private static void bfs(TreeNode root) {
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.value + " ");
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
    }
}
