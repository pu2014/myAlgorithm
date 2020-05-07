package com.分类题型.树;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:    输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @Author: pubojian
 * @Date: Created in 20:00 2019/11/20
 **/
public class 二叉搜索树转换为双向链表 {

    static TreeNode pre = null;

    public static  void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(6);

        preTail(root);
        System.out.println();

        TreeNode head2 = covert2(root);
        print(head2);
        System.out.println();

//        TreeNode head1 = covert(root);
//        print(head1);
//        System.out.println();



    }

    public static TreeNode covert2(TreeNode root) {
        /**
         *@Description：using a new node
         *@Author: newcoder
         *@Date: 2019/11/20 20:40
         **/
        if(root == null){
            return null;
        }
        covert2(root.right);
        if(pre == null){
            pre = root;
        }else{
            root.right = pre;
            pre.left = root;
            pre = root;
        }
        covert2(root.left);
        return pre;
    }


    private static TreeNode covert(TreeNode root) {
        /**
         *@Description：using Arraylist
         *@Author: pbj
         *@Date: 2019/11/20 20:24
         **/
        List<TreeNode> list = new ArrayList<>(20);
        process(list, root);
        for(int i = 0; i < list.size() - 1; i++){
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        return list.get(0);
    }

    private static void process(List<TreeNode> list, TreeNode root) {
        /**
         *@Description：前序遍历加入List
         *@Author:
         *@Date: 2019/11/20 20:29
         **/
        if(root == null){
            return;
        }
        process(list, root.left);
        list.add(root);
        process(list, root.right);
    }

    private static void preTail(TreeNode root) {
        /**
         *@Description：前序遍历一下搜索二叉树
         *@Author:
         *@Date: 2019/11/20 20:21
         **/
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        preTail(root.left);
        preTail(root.right);
    }

    private static void print(TreeNode head) {
        while(head != null){
            System.out.print(head.val + " ");
            head = head.right;
        }
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
