package com.pu.数组;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/2/8 10:58
 */
public class 机器人的运动范围 {
    private static int res = 0;
    public static void main(String[] args) {
        System.out.println(movingCount(15, 20, 20));
    }
    public static int movingCount(int threshold, int rows, int cols){
        if(rows < 0 || cols < 0 || threshold < 0){
            return 0;
        }
        boolean[][] mat = new boolean[rows][cols];
        infect(mat, threshold, 0,0, rows, cols);
        return res;
    }

    public static void infect(boolean[][] mat, int threshold, int i, int j, int rows, int cols){
        if(i >= rows || i < 0 || j < 0 || j >= cols || mat[i][j] || !isQualified(threshold, i, j)){
            return;
        }
        res++;
        mat[i][j] = true;
        if(j != 0){
            infect(mat, threshold,i - 1, j, rows, cols);
        }
        if(j != cols - 1) {
            infect(mat, threshold, i + 1, j, rows, cols);
        }
        if(i != 0){
            infect(mat, threshold, i,j - 1, rows, cols);
        }
        if(i != rows - 1){
            infect(mat, threshold, i,j + 1, rows, cols);
        }

    }

    public static boolean isQualified(int p, int i, int j){
        int res = 0;
        while(i != 0){
            res += i % 10;
            i = i / 10;
        }
        while(j != 0){
            res += j % 10;
            j = j / 10;
        }
        return res <= p;
    }
}
