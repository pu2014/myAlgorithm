package com.剑指Offer;


import com.tools.Tree;

/**
 * Description:
 *  输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *  要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * Created By @Author my on @Date 2020/4/20 19:51
 */
public class _25二叉搜索树与双向链表 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(7);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(12);
/*
        TreeNode convert_1 = new ConvertDoubleLis().convert_1(root);
        while(convert_1 != null){
            System.out.println(convert_1.val);
            convert_1 = convert_1.right;
        }

*/
        TreeNode convert_2 = new ConvertDoubleLis().convert_2(root);
        while(convert_2 != null){
            System.out.println(convert_2.val);
            convert_2 = convert_2.right;
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

class ConvertDoubleLis {
    public TreeNode convert_1(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        TreeNode headNode = convertHelp_1(pRootOfTree, null);
        if(headNode == null){
            return null;
        }
        while(headNode.left != null){
            headNode = headNode.left;
        }
        return headNode;
    }

    private TreeNode convertHelp_1(TreeNode pRootOfTree, TreeNode lastNode) {
        if(pRootOfTree == null){
            return null;
        }
        if(pRootOfTree.left != null){
            lastNode = convertHelp_1(pRootOfTree.left, lastNode);
        }
        pRootOfTree.left = lastNode;
        if(lastNode != null){
            lastNode.right = pRootOfTree;
        }
        lastNode = pRootOfTree;
        if(pRootOfTree.right != null){
            lastNode = convertHelp_1(pRootOfTree.right, lastNode);
        }
        return lastNode;

    }

    /**
     * Description: 直接右边插入null
     * @auther
     */
    public TreeNode convert_2(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode head = convertHelp_2(root, null);
        return head;
    }

    private TreeNode convertHelp_2(TreeNode root, TreeNode rightNode) {
        if(root == null){
            return null;
        }
        if(root.right != null)
        rightNode = convertHelp_2(root.right, rightNode);
        if(rightNode != null){
            root.right = rightNode;
            rightNode.left = root;
        }
        rightNode = root;
        if(root.left != null)
        rightNode = convertHelp_2(root.left, rightNode);
        return rightNode;
    }
}
