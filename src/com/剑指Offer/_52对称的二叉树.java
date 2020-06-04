package com.剑指Offer;

/**
 * @DESC 二叉树的对称
 * @CREATE BY @Author pbj on @Date 2020/5/22 14:56
 */
public class _52对称的二叉树 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(2);
        IsSymmetrical proc = new IsSymmetrical();
        System.out.println(proc.fun(head));
    }
}
class IsSymmetrical{
    public boolean fun(TreeNode root){
        return root == null ? false : process(root.left, root.right);
    }
    private boolean process(TreeNode left, TreeNode right){
        if(left== null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        return left.val == right.val && process(left.right,right.left) && process(left.left, right.right);
    }
}


