package com.pu.数组;

public class 排序矩阵中找数 {
    /**
     * 给定n*m的整形矩阵mat和整数k，mat的每一行和每一列都是排好序的，实现一个函数判断k是
     * 在mat中
     *
     * 要求：时间复杂度为O（n+m） 额外空间复杂度为O(1)
     */

    public static void main(String[] args){
        int[][] mat = createMat();
        System.out.println(isHave(mat,0));
        System.out.println(isHave(mat,1));
        System.out.println(isHave(mat,2));
        System.out.println(isHave(mat,3));
        System.out.println(isHave(mat,4));
        System.out.println(isHave(mat,5));
        System.out.println(isHave(mat,6));
        System.out.println(isHave(mat,7));
        System.out.println(isHave(mat,8));
        System.out.println(isHave(mat,9));
        System.out.println(isHave(mat,10));
        System.out.println(isHave(mat,11));

    }

    public static int[][] createMat(){
        int[][] mat = {
                {0,1,2,5},
                {2,3,4,7},
                {4,4,4,8},
                {5,7,7,9}
        };
        return mat;
    }

    public static boolean isHave(int[][] m,int value){
        int row = m.length - 1;
        int col = m[0].length - 1;
        int i = 0;
        int j = col;
        while(i >= 0 && j >= 0 && i <= row && j <= col){
            if(m[i][j] == value){
                return true;
            }else if(m[i][j] > value){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}
