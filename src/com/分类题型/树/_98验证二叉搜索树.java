package com.分类题型.树;

import java.util.Stack;

/**
 * @DESC 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 *     节点的左子树只包含小于当前节点的数。
 *     节点的右子树只包含大于当前节点的数。
 *     所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @CREATE BY @Author pbj on @Date 2020/5/7 10:01
 */
public class _98验证二叉搜索树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);


        IsValidBST isBST = new IsValidBST();
        System.out.println(isBST.isBST(root));
        System.out.println(isBST.isBSTByInTravel(root));
    }
}
class IsValidBST {
    public boolean isBST(TreeNode root) {
        if(root == null){
            return true;
        }
        TreeNode left = root.left;
        if(left != null){
            while(left.right != null){
                left = left.right;
            }
            if(root.val <= left.val){
                return false;
            }
        }
        TreeNode right = root.right;
        if(right != null){
            while(right.left != null){
                right = right.left;
            }
            if(root.val >= right.val){
                return false;
            }
        }
        return isBST(root.left) && isBST(root.right);
    }

    /**
     * 中序遍历判断升序即可
     * @param root
     * @return
     */
    public boolean isBSTByInTravel(TreeNode root) {
        if(root == null){
            return true;
        }
        Long max = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                TreeNode pre = stack.pop();
                if(pre.val <= max){
                    return false;
                }
                max = Long.valueOf(pre.val);
                root = pre.right;
            }
        }
        return true;
    }
}

