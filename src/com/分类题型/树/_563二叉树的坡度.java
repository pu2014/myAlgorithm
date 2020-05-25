package com.分类题型.树;

import com.tools.TreeNode;
/**
 * @DESC 给定一个二叉树，计算整个树的坡度。
 *
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 *
 * 整个树的坡度就是其所有节点的坡度之和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入:
 *          1
 *        /   \
 *       2     3
 * 输出: 1
 * 解释:
 * 结点的坡度 2 : 0
 * 结点的坡度 3 : 0
 * 结点的坡度 1 : |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @CREATE BY @Author pbj on @Date 2020/5/6 10:38
 */
public class _563二叉树的坡度 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        System.out.println(new FindTilt().method(root));

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.left.left = new TreeNode(4);
        root1.left.left.left.left = new TreeNode(5);
        System.out.println(new FindTilt().method(root1));
    }
}
class FindTilt {
    int tilt = 0;
    public int method(TreeNode root) {
        if(root == null){
            return 0;
        }
        process(root);
        return tilt;
    }

    private int process(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = 0, right = 0;
        if(root.left != null){
            left = process(root.left);
        }
        if(root.right != null){
            right = process(root.right);
        }
        tilt += Math.abs(left - right);
        return root.val + left + right;
    }
}