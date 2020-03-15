package com.LeetCode;

/**
 * description：
 * 一个矩阵中只有0和1 每个位置都可以和自己的上、下、左、右四
 *  * 个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个矩阵中有多少个岛？
 *  * 举例：
 *  *
 *  * 0 0 1 0 1 0
 *  *
 *  * 1 1 1 0 1 0
 *  *
 *  * 1 0 0 1 0 0
 *  *
 *  * 0 0 0 0 0 0
 *  *
 *  * 这个矩阵中有三个岛。
 *  *
 *  * 如果矩阵巨大无比，但是有几个CPU，设计一个多任务并行的算法。(并查集实现，无代码，记住思路）
 * 200：岛屿的数量
 * 695. 岛屿的最大面积
 * @author Pubojian
 * @date 2020/3/15 13:53
 */
public class _08岛屿问题 {
    public static void main(String[] args) {
        int[][] island = {
                {0,0,1,0,1,0},
                {1,1,1,0,1,0},
                {1,0,0,1,0,0},
                {0,0,0,0,0,0}
        };
        System.out.println(new NumbersOfIsland().getTheCountsOfIslands(island));
        int[][] island2 = {
                {0,0,1,0,1,0},
                {1,1,1,0,1,0},
                {1,0,0,1,0,0},
                {0,0,0,0,0,0}
        };
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(island2));
    }
}
class NumbersOfIsland{
    public  int getTheCountsOfIslands(int[][] m) {
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
class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
            return 0;
        }
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int num = inject(i, j, grid);
                    max = Math.max(num, max);
                }
            }
        }
        return max;
    }

    private int inject(int i, int j, int[][] grid){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != 1){
            return 0;
        }
        grid[i][j] = 2;
        return 1 + inject(i - 1, j, grid) + inject(i + 1, j, grid) + inject(i, j - 1, grid) + inject(i, j + 1, grid);
    }
}