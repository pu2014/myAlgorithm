package com.分类题型.树;

import java.util.ArrayList;
import java.util.List;

/**
 * description：公司开会，每个人有自己的活跃度，已知一个人上级来自己肯定不回来
 * 求最大的活跃度。
 *
 * @author Pubojian
 * @date 2020/2/17 20:52
 */
public class 二叉树公司最大的活跃度 {
    //多叉树
    public static class Node{
        public int huo;
        public List<Node> nexts;
        public Node(int huo){
            this.huo = huo;
            nexts = new ArrayList<>();
        }
    }

    public static class ReturnData{
        public int laiHuo;
        public int buLaiHuo;
        public ReturnData(int laiHuo, int buLaiHuo){
            this.laiHuo = laiHuo;
            this.buLaiHuo = buLaiHuo;
        }
    }

    public static int getMaxHou(Node head){
        ReturnData data = process(head);
        return Math.max(data.buLaiHuo, data.laiHuo);
    }

    public static ReturnData process(Node head){
        int laiHuo = head.huo;
        int buLaiHuo = 0;
        for(Node cur : head.nexts){
            ReturnData data = process(cur);
            laiHuo += data.buLaiHuo; //父节点来子节点不能来
            buLaiHuo += Math.max(data.buLaiHuo, data.laiHuo);//父节点不来，子节点可来可不来
        }
        return new ReturnData(laiHuo, buLaiHuo);
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        Node node1 = new Node(10);
        Node node2 = new Node(5);
        head.nexts.add(node1);
        node1.nexts.add(node2);
        System.out.println(getMaxHou(head));

        int[][] matrix = { { 1, 8 }, { 1, 9 }, { 1, 10 } };
        System.out.println(maxHappy(matrix));
    }
    public static int maxHappy(int[][] matrix) {
        int[][] dp = new int[matrix.length][2];
        boolean[] visited = new boolean[matrix.length];
        int root = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i == matrix[i][0]) {
                root = i;
            }
        }
        process(matrix, dp, visited, root);
        return Math.max(dp[root][0], dp[root][1]);
    }

    public static void process(int[][] matrix, int[][] dp, boolean[] visited, int root) {
        visited[root] = true;
        dp[root][1] = matrix[root][1];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == root && !visited[i]) {
                process(matrix, dp, visited, i);
                dp[root][1] += dp[i][0];
                dp[root][0] += Math.max(dp[i][1], dp[i][0]);
            }
        }
    }
}
