package com.分类题型.数组;

import java.util.Arrays;

public class 之字形打印矩阵 {
    /**
     * 给定一个矩阵，按照之字形打印这个矩阵
     * 例如
     * 1 2 3 4
     * 5 6 7 8
     * 9 10 11 12
     *
     * out：1，2，5，9，6，3，4，7，10，11，8，12
     *
     * 要求：额外空间复杂度为o(1)
     */

    public static void main(String[] args){
        int[][] mat = createMat(4,4);
        int row1 = 0;
        int row2 = 0;
        int col1 = 0;
        int col2 = 0;
        int endR = mat.length - 1;
        int endC = mat[0].length - 1;
        boolean fromUp = false;
        while(row1 != endR + 1){
            printLevel(mat,row1,col1,row2,col2,fromUp);
            System.out.println();
            row1 = col1 == endC ? row1 + 1 : row1;
            col1 = col1 == endC ? col1 : col1 + 1;
            col2 = row2 == endR ? col2 + 1 : col2;
            row2 = row2 == endR ? row2 : row2 + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    //打印对角线
    public static void printLevel(int[][] m,int row1,int col1,int row2,int col2,boolean fromUp){
        if(fromUp){
            while(row1 != row2 + 1){
                System.out.print(m[row1++][col1--] + " ");
            }
        }else{
            while(col2 != col1 + 1){
                System.out.print(m[row2--][col2++] + " ");
            }
        }
    }
    public static int[][] createMat(int m,int n){
        int[][] mat = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                mat[i][j] = (int)(Math.random() * 10);
            }
        }
        for(int i = 0;i < m;i++){
            System.out.print(Arrays.toString(mat[i]));
            System.out.println();
        }
        return mat;
    }
}
