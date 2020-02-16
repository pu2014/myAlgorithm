package com.pu.树;

import com.tools.Node;

import java.util.Stack;

/**
 * 搜索二叉树：左子树比他小，右子树比他大
 *
 * 问题点，中序遍历依次升序
 */
public class 判断是否是搜索二叉树 {

    public static void main(String[] args) {
        Node head = new Node(3);
        Node node1 = new Node(2);
        Node node2 = new Node(1);
        Node node3 = new Node(6);
        Node node4 = new Node(4);
        Node node5 = new Node(7);

        head.left = node1;
        node1.left = node2;
        head.right = node3;
        node3.right = node5;
        node3.left = node4;
        System.out.println(isBST(head));
        System.out.println(isBST1(head));
        System.out.println(isBSTv3(head));
    }

    private static boolean isBST1(Node head) {
        if(head == null){
            return false;
        }
        return process(head);
    }

    private static boolean process(Node head) {
        if(head == null){
            return true;
        }
        if(head.left != null){
            if(head.left.value >  head.value){
                return false;
            }
        }
        if(head.right != null){
            if(head.right.value < head.value){
                return false;
            }
        }
        return process(head.left) && process(head.right);
    }

    public static boolean isBSTv3(Node head){
        if (head == null) {
            return true;
        }
        boolean res = true;
        Node pre = null;
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) { // moris中序遍历？
            cur2 = cur1.left; //先遍历左孩子
            if (cur2 != null) { //左孩子不为空
                while (cur2.right != null && cur2.right != cur1) {//左孩子的右孩子不为null且不cur1
                    cur2 = cur2.right;//找到最右的孩子
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            if (pre != null && pre.value > cur1.value) {
                res = false;
            }
            pre = cur1;
            cur1 = cur1.right;
        }
        return res;
    }

    public static boolean isBST(Node head) { // 中序遍历
        Stack<Node> stack = new Stack<>();
        int last = Integer.MIN_VALUE;
        while (head != null || !stack.isEmpty()) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (last < head.value) {
                    last = head.value;
                } else {
                    return false;
                }
                head = head.right;
            }
        }
        return true;
    }
}
