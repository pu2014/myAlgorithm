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
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode head = reConstructBinaryTree(pre, in);
        print(head);
    }
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in){
        if(pre.length == 0 || in.length == 0){
            return null;
        }
        TreeNode parent = new TreeNode(pre[0]);
        for(int i = 0; i < in.length; i++){
            if(pre[0] == in[i]){
                parent.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                parent.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return parent;
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
