package com.分类题型.树;

import com.tools.TreeNode;

import java.util.*;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/9 12:08
 */
public class _103二叉树的锯齿形层次遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(new ZigzagLevelTravel().method(root));
    }
}
class ZigzagLevelTravel{
    public List<List<Integer>> method(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean flag = false;
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> newList = new ArrayList<>();
            LinkedList<TreeNode> newQue = new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode cur = queue.poll();
                newList.add(cur.val);
                if(cur.left != null){
                    newQue.add(cur.left);
                }
                if(cur.right != null){
                    newQue.add(cur.right);
                }
            }
            if(flag){
                Collections.reverse(newList);
            }
            list.add(newList);
            flag = !flag;
            queue = newQue;
        }
        return list;
    }
}
