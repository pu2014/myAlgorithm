package com.剑指Offer;


import java.util.Arrays;

/**
 * description：输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中
 * 都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}
 * 和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @author Pubojian
 * @date 2020/2/24 11:00
 */
public class _04重建二叉树 {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x){
          val = x;
        }
     }
    public static void main(String[] args) {
        int[] pre = {1,2,3};
        int[] in = {3,2,1};
        TreeNode head = reConstructBinaryTree(pre, in);
        print(head);
    }
    public static TreeNode reConstructBinaryTree(int [] preorder,int [] inorder){
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        return process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public static TreeNode process(int[] preorder, int pl, int pr, int[] inorder, int il, int ir){
        if(pl > pr || il > ir){
            return null;
        }
        if(pl == pr && il == ir){
            return new TreeNode(preorder[pl]);
        }
        TreeNode head = new TreeNode(preorder[pl]);
        int i = 0;
        for(;i <= ir - il; i++){
            if(preorder[pl] == inorder[i + il]){
                head.left = process(preorder, pl + 1, pl + i, inorder, il, il + i - 1);
                head.right = process(preorder, pl + i + 1, pr, inorder,il + i + 1, ir);
                break;
            }
        }
        return head;
    }
    public static void print(TreeNode head){
        if(head == null){
            System.out.print("#" + " ");
            return;
        }
        print(head.left);
        print(head.right);
        System.out.print(head.val + " ");
    }
}
