package com.分类题型.树;

import com.tools.TreeNode;

/*
给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。

添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。

将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。

如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。

示例 1:

输入:
二叉树如下所示:
       4
     /   \
    2     6
   / \   /
  3   1 5

v = 1

d = 2

输出:
       4
      / \
     1   1
    /     \
   2       6
  / \     /
 3   1   5

示例 2:

输入:
二叉树如下所示:
      4
     /
    2
   / \
  3   1

v = 1

d = 3

输出:
      4
     /
    2
   / \
  1   1
 /     \
3       1

注意:

    输入的深度值 d 的范围是：[1，二叉树最大深度 + 1]。
    输入的二叉树至少有一个节点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-one-row-to-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import com.tools.Print;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/9 10:05
 */
public class _623在二叉树中增加一行 {
    public static void main(String[] args) {
        AddOneRow proc  = new AddOneRow();
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.left.left = new TreeNode(4);
        head.right = new TreeNode(3);
        Print.printTree(head);
        proc.method(head, 5, 4);
        Print.printTree(head);

    }
}
class AddOneRow {
    public TreeNode method(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode newHead = new TreeNode(v);
            newHead.left = root;
            return newHead;
        }
        int k = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(k < d - 1){
            if(queue.isEmpty()){
                return root;
            }
            Queue<TreeNode> newQue = new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode cur = queue.poll();
                if(cur.left != null){
                    newQue.offer(cur.left);
                }
                if(cur.right != null){
                    newQue.offer(cur.right);
                }
            }
            k++;
            queue =  newQue;
        }
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            TreeNode left = cur.left;
            TreeNode right = cur.right;
            cur.left = new TreeNode(v);
            cur.left.left = left;
            cur.right = new TreeNode(v);
            cur.right.right = right;
        }
        return root;
    }
}
