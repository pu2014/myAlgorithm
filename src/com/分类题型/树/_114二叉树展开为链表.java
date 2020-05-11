package com.分类题型.树;

import com.tools.Print;
import com.tools.TreeNode;

/**
 * @DESC 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @CREATE BY @Author pbj on @Date 2020/5/11 9:53
 */
public class _114二叉树展开为链表 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        Print.printTree(root);

        new Flatten().flatten(root);

        Print.printTree(root);
    }

}
class Flatten {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left != null){
            TreeNode left = root.left;
            TreeNode cur = left;
            while(cur.right != null){
                cur = cur.right;
            }
            cur.right = root.right;
            root.right = left;
            root.left = null;
        }
        flatten(root.right);
    }
}
