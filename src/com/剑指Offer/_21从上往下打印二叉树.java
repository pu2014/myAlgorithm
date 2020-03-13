package com.剑指Offer;

import com.tools.Print;
import com.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * description： 数的bfs
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * @author Pubojian
 * @date 2020/3/13 9:56
 */
public class _21从上往下打印二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        System.out.println(new PrintFromTopToBottom().method(root));
    }
}
class PrintFromTopToBottom{
    public ArrayList<Integer> method(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            list.add(cur.value);
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
        return list;
    }
}
