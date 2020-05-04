package com.pu.树;

import com.tools.TreeNode;
import com.tools.Print;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/2/1 19:36
 */
public class 树的序列化非递归按层次版本 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        Print.printTree(root);
        String str = serialize(root);
        System.out.println(str);
        TreeNode node = deserialize(str);
        Print.printTree(node);
    }

    private static TreeNode deserialize(String str) {
        if(str == null || str.length() == 0){
            return null;
        }
        String[] strs = str.split("_");
        TreeNode[] nodes = new TreeNode[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if(!strs[i].equals("#")){
                nodes[i] = new TreeNode(Integer.valueOf(strs[i]));
            }
        }
        for (int i = 0, j = 1; i < nodes.length; i++) {
            if(nodes[i] != null){
                nodes[i].left = nodes[j++];
                nodes[i].right = nodes[j++];
            }
        }
        return nodes[0];
    }

    private static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                queue.offer(node.left);
                queue.offer(node.right);
                sb.append(node.val + "_");
            }else{
                sb.append("#_");
            }
        }
        if(sb.length() != 0){
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();


    }

}
