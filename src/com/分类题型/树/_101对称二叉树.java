package com.分类题型.树;

import com.tools.Print;
import com.tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @DESC 给定一个二叉树，检查它是否是镜像对称的。
 * @CREATE BY @Author pbj on @Date 2020/5/9 10:45
 */
public class _101对称二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(6);
        root.right.right = new TreeNode(6);

        IsSymmetric tree = new IsSymmetric();
        System.out.println(tree.method(root));
        System.out.println(tree.methodNonRec(root));
    }
}
class IsSymmetric {
    public boolean method(TreeNode root) {
        return process(root, root);
    }

    private boolean process(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        return root1.val == root2.val
                && process(root1.left, root2.right)
                && process(root2.left, root1.right);
    }

    public boolean methodNonRec(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}
