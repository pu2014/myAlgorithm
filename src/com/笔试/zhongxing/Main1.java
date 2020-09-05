package com.笔试.zhongxing;

import com.tools.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/9/5 15:44
 */
public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        int[] nums = Arrays.stream(strs).mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(nums));
        System.out.println(TreeNode.createTree(nums));
    }

    static class TreeNode {
        public static Node root;
        public static Node current;
        public static int leftMax;
        public static int rightMax;

        static class Node {
            public Node left;
            public Node right;
            public int data;

            public Node(int data) {
                this.left = null;
                this.right = null;
                this.data = data;
            }
        }

        public static int createTree(int[] nums){
            for(int i : nums){
                addNode(i);
            }
            return leftMax + rightMax + 1;
        }
        public static void addNode(int data) {
            int leftCnt = 0;
            int rightCnt = 0;
            if (root == null) {
                root = new Node(data);
            } else {
                current = root;
                while (current != null) {
                    if (data <= current.data) {
                        leftCnt++;
                        if (current.left == null) {
                            current.left = new Node(data);
                            break;
                        }
                        current = current.left;
                    } else {
                        rightCnt++;
                        if (current.right == null) {
                            current.right = new Node(data);
                            break;
                        }
                        current = current.right;
                    }
                }
            }
            leftMax = Math.max(leftCnt, leftMax);
            rightMax = Math.max(rightCnt, rightMax);
        }
    }
}
