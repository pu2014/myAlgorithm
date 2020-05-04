package com.pu.树;

import java.util.ArrayList;
import java.util.List;

import com.tools.Print;
import com.tools.TreeNode;

/**
 * @DESC 给你 root1 和 root2 这两棵二叉搜索树。
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 *
 * @CREATE BY @Author pbj on @Date 2020/5/4 10:37
 */
public class _1305两棵二叉搜索树中的所有元素 {
    public static void main(String[] args) {
        GetAllElements proc = new GetAllElements();

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        Print.printTree(root1);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);
        Print.printTree(root2);

        System.out.println(proc.method(root1, root2));
    }
}
class GetAllElements{
    public List<Integer> method(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        process(root1, list1);
        process(root2, list2);
        int i1 = 0, i2 = 0;
        while(i1 < list1.size() && i2 < list2.size()){
            if(list1.get(i1) <= list2.get(i2)){
                res.add(list1.get(i1));
                i1++;
            }else{
                res.add(list2.get(i2));
                i2++;
            }
        }
        while(i1 != list1.size()){
            res.add(list1.get(i1));
            i1++;
        }
        while(i2 != list2.size()){
            res.add(list2.get(i2));
            i2++;
        }
        return res;
    }

    private void process(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        process(root.left, list);
        list.add(root.val);
        process(root.right, list);
    }
}
