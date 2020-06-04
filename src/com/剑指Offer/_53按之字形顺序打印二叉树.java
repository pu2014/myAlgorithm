package com.剑指Offer;

import java.util.*;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/22 16:52
 */
public class _53按之字形顺序打印二叉树 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        PrintZTreeNode pros = new PrintZTreeNode();
        System.out.println(pros.Print(head));
    }
}
class PrintZTreeNode {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null){
            return res;
        }
        Queue<TreeNode> deque = new LinkedList<>();
        deque.add(pRoot);
        ArrayList<Integer> list;
        boolean rev = false;
        TreeNode cur;
        while(!deque.isEmpty()){
            int size = deque.size();
            list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                cur = deque.poll();
                list.add(cur.val);
                if(cur.left != null){
                    deque.add(cur.left);
                }
                if(cur.right != null){
                    deque.add(cur.right);
                }
            }
            if(rev) {
                Collections.reverse(list);
            }
            res.add(list);
            rev = !rev;
        }
        return res;
    }

}
