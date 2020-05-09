package com.分类题型.树;
import com.tools.TreeNode;

/**
 * @DESC 给定二叉树的根节点 root，找出存在于不同节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 *
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：[8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 * 解释：
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @CREATE BY @Author pbj on @Date 2020/5/4 11:11
 */
public class _1026节点与其祖先之间的最大差值 {
    public static void main(String[] args) {
        MaxAncestorDiff proc = new MaxAncestorDiff();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        System.out.println(proc.method(root));
    }
}
class MaxAncestorDiff{
    //DFS
    int res = -1;
    public int method(TreeNode root) {
        if(root == null){
            return -1;
        }
        process(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return res;
    }

    private void process(TreeNode root, int max, int min) {
        if(root == null){
            return;
        }
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        if(root.left == null && root.right == null){
           res =  Math.max(max - min, res);
        }
        process(root.left, max, min);
        process(root.right, max, min);
    }
}
