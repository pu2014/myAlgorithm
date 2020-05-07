package com.分类题型.动态规划;

/**
 * 给你一个二维数组，二维数组的每个数都是正数，
 * 要求从左上角走到右下角，每一步只能向右或者向下，
 * 沿途经过的数字要累加起来，返回最小的路径和。
 */

public class 二维数组最短路径 {
    public static void main(String[] args){
        int[][] m = {
                {1,3,5,9},
                {8,1,3,4},
                {5,0,6,1},
                {8,8,4,0}
        };
        System.out.println(minPath(m));
        System.out.println(minPathDP(m));

    }
    //暴力递归转化为动态规划
    private static int minPathDP(int[][] m) {
        if(m == null || m.length == 0 || m[0] == null || m[0].length == 0){
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for(int i = 1; i < row; i++){
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for(int j = 1; j < col; j++){
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                dp[i][j] = m[i][j] + Math.min(dp[i - 1][j],dp[i][j - 1]);
            }
        }
        return dp[row - 1][col - 1];
    }

    private static int minPath(int[][] m) {
        return walk(m,0,0);
    }
    //枚举（穷举法）列出了该点每一个选择。
    public static int walk(int[][] mat, int i, int j){
        if(i == mat.length - 1 && j == mat[0].length - 1)
            return mat[i][j];
        if(i == mat.length - 1){
            return mat[i][j] + walk(mat, i, j + 1);
        }
        if(j == mat[0].length - 1){
            return mat[i][j] + walk(mat, i + 1, j);
        }
        //无后效性问题
        int right = walk(mat, i, j + 1) < walk(mat, i + 1, j)
                ? walk(mat, i, j + 1)
                : walk(mat, i + 1, j);
        return mat[i][j] + right;
    }

}
