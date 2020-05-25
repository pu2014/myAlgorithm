package com.分类题型.树;

import com.tools.Print;
import com.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/9 11:50
 */
public class _102二叉树的层序遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(new LevelOrder().method(root));
    }
}
class LevelOrder {
    public List<List<Integer>> method(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> newList = new ArrayList<>();
            Queue<TreeNode> newQue = new LinkedList<>();
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
            list.add(newList);
            queue = newQue;
        }
        return list;
    }
}
