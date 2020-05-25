package com.分类题型.树;
import com.tools.Print;
import com.tools.TreeNode;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/7 11:55
 */
public class _617合并二叉树 {
    public static void main(String[] args) {
        TreeNode root = new com.tools.TreeNode(5);
        root.left = new com.tools.TreeNode(1);
        root.right = new com.tools.TreeNode(7);
        root.right.left = new com.tools.TreeNode(6);
        root.right.right = new com.tools.TreeNode(8);

        TreeNode head = new com.tools.TreeNode(5);
        head.left = new com.tools.TreeNode(1);
        head.right = new com.tools.TreeNode(7);
        head.right.right = new com.tools.TreeNode(9);

        Print.printTree(new MergeTrees().method(root, head));
    }

}
class MergeTrees {
    public TreeNode method(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return null;
        }
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        t1.val += t2.val;
        t1.left = method(t1.left, t2.left);
        t1.right = method(t1.right, t2.right);
        return t1;
    }
}
