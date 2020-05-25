package com.分类题型.树;

import com.tools.TreeNode;
/**
 * @DESC
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 *
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @CREATE BY @Author pbj on @Date 2020/5/6 11:11
 */
public class _572另一个树的子树 {
    public static void main(String[] args) {
        IsSubtree isSub = new IsSubtree();

        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(2);
        s.right = new TreeNode(3);
        s.left.left = new TreeNode(4);

        TreeNode t = new TreeNode(2);
        t.left = new TreeNode(5);

        System.out.println(isSub.method(s, t));
    }
}

/**
 * 题目有坑， 注意 s 的一个子树包括 s 的一个节点和这个节点的所有子孙这句话  例如
 * [3,4,5,1,2,null,null,0]
 * [4,1,2]  为false
 */
class IsSubtree {
    public boolean method(TreeNode s, TreeNode t) {
        if(s == null){
            return false;
        }
        return isSame(s,t) || method(s.left, t) || method(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if(t == null && s == null){
            return true;
        }
        if(s != null && t != null){
            if(s.val == t.val){
                return isSame(s.left, t.left) && isSame(s.right, t.right);
            }
        }
        return false;
    }

    // 优化后一步到位
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return true;
        }
        boolean res = false;
        if(t1 != null && t2 != null){
            if(t1.val == t2.val){
                res = checkSubTree(t1.left, t2.left) && checkSubTree(t1.right, t2.right);
            }else{
                res = res || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
            }
        }
        return res;
    }
}
