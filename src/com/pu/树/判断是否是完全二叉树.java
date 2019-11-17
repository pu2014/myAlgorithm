package com.pu.树;

import com.tools.Node;
import com.tools.Queue;

/**
 * 按层遍历，以下条件按照顺序判断
 *
 * 1、如果一个子树有右孩子没左孩子肯定不是完二叉。返回false
 *
 * 2、如果一个节点，不是左右孩子都全，出现这种情况，他后面出现的节点，
 * 都必须是叶子节点，否则false。
 */

public class 判断是否是完全二叉树 {
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
        System.out.println(isCST1(head));
    }

    private static boolean isCST1(Node head) {
       /**
        * Description:
        * @auther zuocongyun
        */
        if(head == null){
            return false;
        }
        Queue<Node> queue = new Queue<>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;
            if((leaf && (l != null || r != null)) || (l == null && r != null)){
                return false;
            }
            if(l != null){
                queue.offer(l);
            }
            if(r != null){
                queue.offer(r);
            }else{
                leaf = true;
            }
        }
        return true;
    }
}
