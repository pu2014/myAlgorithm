package com.pu.树;

/**
 * 只给出一个在二叉树中的某一个节点，请实现返回Node的后继节点的函数
 * 在二叉树的中序遍历的序列中，Node的下一个节点叫做Node的后继节点。
 */

public class 二叉树中找到一个节点的后继节点 {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args){
        Node head = new Node(66);
        Node node1 = new Node(45);
        Node node2 = new Node(35);
        Node node3 = new Node(56);
        Node node4 = new Node(73);
        Node node5 = new Node(68);
        Node node6 = new Node(89);
        head.left = node1;
        head.right = node4;
        node1.parent = head;
        node1.left = node2;
        node1.right = node3;
        node2.parent = node1;
        node3.parent = node1;
        node4.parent = head;
        node4.left = node5;
        node4.right = node6;
        node5.parent = node4;
        node6.parent = node4;

        Node res1 = getSuccessorNode(head);//66
        System.out.println(res1.value);
        Node res2 = getSuccessorNode(node4);//73
        System.out.println(res2.value);
        Node res3 = getSuccessorNode(node2);//35
        System.out.println(res3.value);
        Node res4 = getSuccessorNode(node3);//56
        System.out.println(res4.value);
    }

    public static Node getSuccessorNode(Node node){
        if (node.right != null) {
            node = node.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }else{
            Node parent = node.parent;
            while(parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }
                return parent;
        }
    }
}
