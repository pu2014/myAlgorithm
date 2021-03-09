package com.分类题型.测试;
import java.util.*;

/*

 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2021/2/21 0:44
 */
public class sys {


    public static boolean isSymmetric (TreeNode root) {
        // write code here
        if(root == null){
            return true;
        }
        return helper(root.left, root.right);
    }

    private static boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left != null && right != null){
            System.out.println(left.val + "...." + right.val);
            return left.val == right.val && helper(left.right, right.left) && helper(left.left, right.right);
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));

    }
}
