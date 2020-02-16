package com.pu.树;

import com.tools.Print;

/**
 * description：找出二叉树子树中的最大搜索二叉树
 * tips:递归实现
 *  找出左子树的最大二叉树，找出右子树的最大二叉树。
 *  3种情况分析。
 *
 * @author Pubojian
 * @date 2020/2/16 22:16
 */
public class 找出二叉树子树中的最大搜索二叉树 {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class ReturnType{
        public int size;
        public Node head;
        public int min;
        public int max;

        public ReturnType(int size, Node head, int min, int max) {
            this.size = size;
            this.head = head;
            this.min = min;
            this.max = max;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(2);
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(7);
        Node node5 = new Node(8);
        head.left = node1;
        head.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        System.out.println(biggestSubBST(head).value);

    }
    public static Node biggestSubBST(Node head){
        return process(head).head;
    }

    private static ReturnType process(Node head) {
        if(head == null){
            return new ReturnType(0, null, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Node left = head.left;
        ReturnType leftSubTreeInfo = process(left);
        Node right = head.right;
        ReturnType rightSubTreeInfo = process(right);
        int includeItSelf = 0;
        if(leftSubTreeInfo.head == left && rightSubTreeInfo.head == right
                && head.value > leftSubTreeInfo.max && head.value < rightSubTreeInfo.min){
            includeItSelf = 1 + leftSubTreeInfo.size + rightSubTreeInfo.size;
        }
        int leftSize = leftSubTreeInfo.size;
        int rightSize = rightSubTreeInfo.size;
        int maxSize = Math.max(Math.max(leftSize, rightSize), includeItSelf);
        Node maxHead = leftSize > rightSize ? leftSubTreeInfo.head : rightSubTreeInfo.head;
        if(maxSize == includeItSelf){
            maxHead = head;
        }
        return new ReturnType(maxSize, maxHead,
                Math.min(Math.min(leftSubTreeInfo.min, rightSubTreeInfo.min), head.value),
                Math.max(Math.max(leftSubTreeInfo.max, rightSubTreeInfo.max), head.value));
    }
}
