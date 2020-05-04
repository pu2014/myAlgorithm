package com.pu.树;

/**
 * @DESC 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *          两结点之间的路径长度是以它们之间边的数目表示。
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 *
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @CREATE BY @Author pbj on @Date 2020/5/4 10:13
 */
public class _543二叉树的直径 {
    public static void main(String[] args) {
        DiameterOfBinaryTree pro = new DiameterOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        System.out.println(pro.method(root));
    }
}

class DiameterOfBinaryTree{
    private int maxPath = -1;
    public int method(TreeNode root) {
        if(root == null){
            return 0;
        }
        depth(root);
        return maxPath;
    }

    private int depth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        maxPath = Math.max(maxPath, left + right);
        return Math.max(left, right) + 1;
    }
}
