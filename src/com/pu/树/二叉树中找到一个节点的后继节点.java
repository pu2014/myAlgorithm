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
        System.out.println(res1.value);//68
        Node res2 = getSuccessorNode(node4);//73
        System.out.println(res2.value);//89
        Node res3 = getSuccessorNode(node2);//35
        System.out.println(res3.value);//45
        Node res4 = getSuccessorNode(node3);//56
        System.out.println(res4.value);//66

        System.out.println(getSuccessorNodeByNoParent(head, node4).value);//89
    }

    /**
     * 有父节点，如果当前节点有右节点，找右节点的最左节点就可
     *      如果当前节点没有右节点，找当前节点的父节点，
     *                  当节点为父节点左节点，说明已经遍历过，再继续找
     *                  如果当前节点为父节点的左节点，返回该节点
     * @param node
     * @return
     */
    public static Node getSuccessorNode(Node node) {
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    /**
     * 没有父节点，思路
     *      如果cur.val 比 root.val 值大，肯定在右节点上，从右节点找，找不到直接为null
     *      反之，在左节点上找。找不到就是root
     *
     * @param root
     * @param node
     * @return
     */
    public static Node getSuccessorNodeByNoParent(Node root, Node node){
        if(root == null || node == null){
            return null;
        }
        if(root.value <= node.value){
            Node right = getSuccessorNodeByNoParent(root.right, node);
            return right;
        }else{
            Node left = getSuccessorNodeByNoParent(root.left, node);
            return left == null ? root : node;
        }

    }
}
