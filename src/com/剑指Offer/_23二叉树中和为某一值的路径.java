package com.剑指Offer;

import com.tools.Print;
import com.tools.TreeNode;

import java.util.ArrayList;

/**
 * Description:
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所
 * 有路径。路径定义为从树的根结点开始往下一直到叶结点所经过
 * 的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * Created By @Author my on @Date 2020/4/8 23:50
 */
public class _23二叉树中和为某一值的路径 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        Print.printTree(root);
        Print.printTree(root);

        System.out.println(new FindPath().method(root, 9));

        System.out.println(new FindPath().method2(root, 9));
    }
}
class FindPath{
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private ArrayList<Integer> arr = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> method(TreeNode root, Integer target){
        if(root == null){
            return res;
        }
        arr.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(arr));
        }
        if(root.left != null) method(root.left, target);
        if(root.right != null) method(root.right, target);
        arr.remove(arr.size() - 1);//
        return res;
    }

    public ArrayList<ArrayList<Integer>> method2(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        if(root == null || target < root.val){
            return list;
        }
        Find(list, arr, root, target);
        return list;

    }
    public void Find(ArrayList<ArrayList<Integer>> list,
                     ArrayList<Integer> arr, TreeNode root,
                     int target){
        if(root == null){
            return;
        }
        if(root.val == target && root.left == null && root.right == null){
            arr.add(root.val);
            list.add(arr);
            return;
        }else{
            arr.add(root.val);
            Find(list, new ArrayList<>(arr), root.left, target - root.val);
            Find(list, new ArrayList<>(arr), root.right, target - root.val);
        }
    }
}
