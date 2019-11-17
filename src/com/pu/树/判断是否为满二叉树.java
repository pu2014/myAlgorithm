package com.pu.树;

import com.tools.Node;

/**
 * description：判断是否是满二叉树
 *
 * @author Pubojian
 * @date 2019/11/7 15:57
 */
public class 判断是否为满二叉树 {
    public static void main(String[] args) {
        Node head = new Node(3);
        Node node1 = new Node(2);
        Node node2 = new Node(1);
        Node node3 = new Node(6);
        Node node4 = new Node(4);
        Node node5 = new Node(7);
        Node node6 = new Node(8);

        head.left = node1;
        head.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        //node2.right = node6;
        // head.right = node3;
        //node3.right = node5;
        //node3.left = node4;
        System.out.println(isFBT(head));
    }

    private static boolean isFBT(Node head) {
        if(head == null){
            return false;
        }
        //判定叶子节点
        if(head.left != null && head.right != null
                && head.left.right == null && head.left.left == null
                && head.right.left == null && head.right.right == null){
            return true;
        }else if(head.left != null && head.right != null){
            return isFBT(head.left) && isFBT(head.right);
        }else {
            return false;
        }
    }
}
