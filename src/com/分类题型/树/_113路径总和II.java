package com.分类题型.树;

import com.tools.Print;
import com.tools.Tree;
import com.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/11 9:58
 */
public class _113路径总和II {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        Print.printTree(root);
        System.out.println(new PathSum().pathSum(root, 18));
    }
}
class PathSum {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return res;
        }
        process(root, sum, new ArrayList<>());
        return res;
    }

    private void process(TreeNode root, int sum, List<Integer> list) {
        if(root == null){
            return;
        }
        list.add(root.val);
        sum = sum - root.val;
        if(sum == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(list));
            return;
        }
        process(root.left, sum, list);
        process(root.right, sum, list);
        list.remove(list.size() -1);
    }
}