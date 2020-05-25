package com.分类题型.树;

import com.tools.Print;
import com.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/13 12:25
 */
public class _637二叉树的层平均值 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.left.left = new TreeNode(4);
        head.right = new TreeNode(3);
        Print.printTree(head);
        System.out.println(new AverageOfLevels().method(head));
        //Print.printTree(head);
    }
}
class AverageOfLevels {
    public List<Double> method(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            double sum = 0d;
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                sum += cur.val;
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            list.add(Double.valueOf(sum / size));
        }
        return list;
    }
}