package com.剑指Offer;

import com.tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description：
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * @author Pubojian
 * @date 2020/3/10 9:17
 */
public class _16树的子结构 {

}
class HasSubtree {
    //递归实现
    public boolean fun1(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        return isSame(root1, root2)
                || isSame(root1.left, root2)
                || isSame(root1.right,root2);
    }
    public boolean isSame(TreeNode root1,TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        return root1.value == root2.value
                && isSame(root1.left, root2.left)
                && isSame(root1.right, root2.right);
    }
    //非递归实现
    public boolean fun2(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(isSame(cur, root2)){
                return true;
            }else{
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
        }
        return false;
    }

}
