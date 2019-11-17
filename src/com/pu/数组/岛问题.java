package com.pu.数组;

/**
 * 一个矩阵中只有0和1 每个位置都可以和自己的上、下、左、右四
 * 个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个矩阵中有多少个岛？
 * 举例：
 *
 * 0 0 1 0 1 0
 *
 * 1 1 1 0 1 0
 *
 * 1 0 0 1 0 0
 *
 * 0 0 0 0 0 0
 *
 * 这个矩阵中有三个岛。
 *
 * 如果矩阵巨大无比，但是有几个CPU，设计一个多任务并行的算法。(并查集实现，无代码，记住思路）
 */
public class 岛问题 {
    public static void main(String[] args){
        int[][] island = {
                {0,0,1,0,1,0},
                {1,1,1,0,1,0},
                {1,0,0,1,0,0},
                {0,0,0,0,0,0}
        };
        System.out.println(getTheCountsOfIslands(island));
    }

    private static int getTheCountsOfIslands(int[][] m) {
        if(m == null || m[0] ==null){
            return 0;
        }
        int rows = m.length;
        int cols = m[0].length;
        int res = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(m[i][j] == 1){
                    res++;
                    infect(m,i,j,rows,cols);
                }
            }
        }
        return res;
    }
    public static void infect(int[][] m, int i, int j, int row, int col){
        if(i < 0 || i >= row || j < 0 || j >= col || m[i][j] != 1){
            return;
        }
        m[i][j] = 2;
        infect(m,i + 1, j , row, col);
        infect(m,i - 1, j , row, col);
        infect(m, i, j + 1 , row, col);
        infect(m, i, j - 1, row, col);
    }
}
